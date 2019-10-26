package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.constant.TaskAttachConst;
import com.tangmo.xizhu.customer.dao.FastFeedbackDao;
import com.tangmo.xizhu.customer.dao.TaskAttachDao;
import com.tangmo.xizhu.customer.dao.TaskDao;
import com.tangmo.xizhu.customer.dao.TaskRequireDao;
import com.tangmo.xizhu.customer.entity.FastFeedBack;
import com.tangmo.xizhu.customer.entity.TaskAttach;
import com.tangmo.xizhu.customer.entity.TaskRequire;
import com.tangmo.xizhu.customer.entity.converter.TaskAttachConverter;
import com.tangmo.xizhu.customer.entity.converter.TaskRequireConverter;
import com.tangmo.xizhu.customer.service.FastFeedbackService;
import com.tangmo.xizhu.customer.service.TaskRequireService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description: 快速服务反馈单实现类
 **/
@Service("fastFeedbackService")
public class FastFeedbackServiceImpl implements FastFeedbackService {

    @Resource
    private FastFeedbackDao fastFeedbackDao;
    @Resource
    private TaskRequireService taskRequireService;
    @Resource
    private TaskAttachDao taskAttachDao;
    @Override
    public HttpResult addFastFeedback(FastFeedBack fastFeedBack) {
        String uuid = EncryptUtil.get32Uuid();
        fastFeedBack.setUuid(uuid);
        fastFeedbackDao.insertFastFeedback(fastFeedBack);
        //添加任务需求单图片附件
        List<TaskAttach> detailAttach = TaskAttachConverter.String2Entity(fastFeedBack.getDetailPictureList(),uuid,
                TaskAttachConst.FAST_FB_ATTACH,TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
        List<TaskAttach> solAttach = TaskAttachConverter.String2Entity(fastFeedBack.getDetailPictureList(),uuid,
                TaskAttachConst.FAST_FB_ATTACH,TaskAttachConst.PICTURE,TaskAttachConst.SOLUTION);
        if(detailAttach != null){
            taskAttachDao.insertBatchAttach(detailAttach);
        }
        if(solAttach != null){
            taskAttachDao.insertBatchAttach(solAttach);
        }
        return HttpResult.success();
    }

    @Override
    public HttpResult changeFastFeedback(FastFeedBack fastFeedBack) {
        fastFeedbackDao.updateFastFeedback(fastFeedBack);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        FastFeedBack fastFeedBack = fastFeedbackDao.selectByTaskId(taskId);
        //如果未填写，返回公共信息
        if(fastFeedBack == null){
            TaskRequire taskRequire = (TaskRequire) taskRequireService.getByTaskId(taskId).getData();
            if(taskRequire != null){
                fastFeedBack = TaskRequireConverter.require2FastFb(taskRequire);
            }
        }else {
            List<String> detail = taskAttachDao.selectByParentAndType(fastFeedBack.getUuid(), TaskAttachConst.FAST_FB_ATTACH,
                    TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
            List<String> solution = taskAttachDao.selectByParentAndType(fastFeedBack.getUuid(), TaskAttachConst.FAST_FB_ATTACH,
                    TaskAttachConst.PICTURE,TaskAttachConst.SOLUTION);
            fastFeedBack.setDetailPictureList(detail);
            fastFeedBack.setSolPictureList(solution);
        }
        return HttpResult.success(fastFeedBack);
    }
}
