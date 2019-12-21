package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.constant.*;
import com.tangmo.xizhu.customer.dao.AuditTaskDao;
import com.tangmo.xizhu.customer.dao.FieldApplyDao;
import com.tangmo.xizhu.customer.dao.TaskAttachDao;
import com.tangmo.xizhu.customer.dao.TaskDao;
import com.tangmo.xizhu.customer.entity.AuditTask;
import com.tangmo.xizhu.customer.entity.FastFeedBack;
import com.tangmo.xizhu.customer.entity.FieldApply;
import com.tangmo.xizhu.customer.entity.TaskAttach;
import com.tangmo.xizhu.customer.entity.converter.FastFbConverter;
import com.tangmo.xizhu.customer.entity.converter.TaskAttachConverter;
import com.tangmo.xizhu.customer.service.*;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description: 现场服务申请单service实现类
 **/
@Service("fieldApplyService")
public class FieldApplyServiceImpl implements FieldApplyService {
    @Resource
    private FieldApplyDao fieldApplyDao;
    @Resource
    private TaskAttachDao taskAttachDao;
    @Resource
    private FastFeedbackService fastFeedbackService;
    @Resource
    private TaskDao taskDao;
    @Resource
    private AuditTaskService auditTaskService;
    @Resource
    private OptRecordService optRecordService;
    @Resource
    private FormStateService formStateService;
    @Override
    public HttpResult addApply(FieldApply fieldApply) {
        if(fieldApply == null || fieldApply.getTaskId() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        String uuid = EncryptUtil.get32Uuid();
        fieldApply.setUuid(uuid);
        fieldApplyDao.insertFieldApply(fieldApply);
        //存储附件
        List<String> picture = fieldApply.getDetailPictureList();
        List<TaskAttach> list = TaskAttachConverter.String2Entity(picture, uuid,TaskAttachConst.FIELD_APPLY,
                TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
        if(list != null){
            taskAttachDao.insertBatchAttach(list);
        }
        //修改任务审批状态
        taskDao.updateStatusAndType(fieldApply.getTaskId(), TaskStatusConst.INITIAL, TaskTypeConst.FIELD_SERVICE);
        //增加审批流程
        auditTaskService.addAuditTask(fieldApply.getTaskId(),fieldApply.getCreatedBy(),
                TaskTypeConst.FIELD_SERVICE,AuditOperateConst.INITIAL);
        //操作记录
        optRecordService.addOptRecord(fieldApply.getTaskId(),fieldApply.getCreatedBy(), OptConst.FIELD_APPLY);
        //任务流程
        formStateService.changeFormState(fieldApply.getTaskId(),"form04");
        return HttpResult.success();
    }

    @Override
    public HttpResult changeApply(FieldApply fieldApply) {
        fieldApplyDao.updateFieldApply(fieldApply);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        FieldApply fieldApply = fieldApplyDao.selectByTaskId(taskId);
        if(fieldApply == null){
            FastFeedBack fastFeedBack = (FastFeedBack) fastFeedbackService.getByTaskId(taskId).getData();
            fieldApply = FastFbConverter.fastFb2FieldApply(fastFeedBack);
        }else{
            List<String> detail = taskAttachDao.selectByParentAndType(fieldApply.getUuid(), TaskAttachConst.FIELD_APPLY,
                    TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
            fieldApply.setDetailPictureList(detail);
        }
        return HttpResult.success(fieldApply);
    }
}
