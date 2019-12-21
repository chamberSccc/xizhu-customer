package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.constant.OptConst;
import com.tangmo.xizhu.customer.constant.TaskAttachConst;
import com.tangmo.xizhu.customer.dao.FieldFeedbackDao;
import com.tangmo.xizhu.customer.dao.TaskAttachDao;
import com.tangmo.xizhu.customer.entity.FieldApply;
import com.tangmo.xizhu.customer.entity.FieldFeedBack;
import com.tangmo.xizhu.customer.entity.TaskAttach;
import com.tangmo.xizhu.customer.entity.converter.FieldApplyConverter;
import com.tangmo.xizhu.customer.entity.converter.TaskAttachConverter;
import com.tangmo.xizhu.customer.service.FieldApplyService;
import com.tangmo.xizhu.customer.service.FieldFeedbackService;
import com.tangmo.xizhu.customer.service.FormStateService;
import com.tangmo.xizhu.customer.service.OptRecordService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description: 现场服务反馈单service实现类
 **/
@Service("fieldFeedbackService")
public class FieldFeedbackServiceImpl implements FieldFeedbackService {
    @Resource
    private FieldFeedbackDao fieldFeedbackDao;
    @Resource
    private FieldApplyService fieldApplyService;
    @Resource
    private TaskAttachDao taskAttachDao;
    @Resource
    private OptRecordService optRecordService;
    @Resource
    private FormStateService formStateService;
    @Override
    public HttpResult addFeedback(FieldFeedBack feedBack) {
        String uuid = EncryptUtil.get32Uuid();
        feedBack.setUuid(uuid);
        fieldFeedbackDao.insertFeedback(feedBack);
        dealPictureList(feedBack.getDetailPictureList(),feedBack.getResPictureList(),uuid);
        //操作记录
        optRecordService.addOptRecord(feedBack.getTaskId(),feedBack.getCreatedBy(), OptConst.FIELD_FEED);
        //任务流程
        formStateService.changeFormState(feedBack.getTaskId(),"form06");
        return HttpResult.success();
    }

    @Override
    public HttpResult changeFeedback(FieldFeedBack fieldFeedBack) {
        fieldFeedbackDao.updateFeedback(fieldFeedBack);
        //先删除之前的附件内容
        taskAttachDao.deleteByParentAndType(fieldFeedBack.getUuid(),TaskAttachConst.FIELD_FB,TaskAttachConst.RESULT);
        //添加任务需求单图片附件
        dealPictureList(null,fieldFeedBack.getResPictureList(),fieldFeedBack.getUuid());
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        //现场服务反馈单来自于现场服务申请单
        FieldFeedBack fieldFeedBack = fieldFeedbackDao.selectByTaskId(taskId);
        if(fieldFeedBack == null){
            FieldApply fieldApply = (FieldApply) fieldApplyService.getByTaskId(taskId).getData();
            fieldFeedBack = FieldApplyConverter.apply2FieldFb(fieldApply);
        }else{
            List<String> detail = taskAttachDao.selectByParentAndType(fieldFeedBack.getUuid(), TaskAttachConst.FIELD_APPLY,
                    TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
            fieldFeedBack.setDetailPictureList(detail);
        }
        return HttpResult.success(fieldFeedBack);
    }


    /**
     * @param detail
     * @param solution
     * @param uuid
     * @return
     * @author chen bo
     * @date 2019/10/29
     * @description: 处理图片列表
     */
    private void dealPictureList(List<String> detail,List<String> solution,String uuid){
        List<TaskAttach> detailAttach = TaskAttachConverter.String2Entity(detail,uuid,
                TaskAttachConst.FIELD_FB,TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
        List<TaskAttach> solAttach = TaskAttachConverter.String2Entity(solution,uuid,
                TaskAttachConst.FIELD_FB,TaskAttachConst.PICTURE,TaskAttachConst.RESULT);
        if(detailAttach != null){
            taskAttachDao.insertBatchAttach(detailAttach);
        }
        if(solAttach != null){
            taskAttachDao.insertBatchAttach(solAttach);
        }
        return ;
    }
}
