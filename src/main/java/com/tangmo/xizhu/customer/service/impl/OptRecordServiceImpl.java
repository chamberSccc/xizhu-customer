package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.dao.OptRecordDao;
import com.tangmo.xizhu.customer.dao.TaskDao;
import com.tangmo.xizhu.customer.entity.OptRecord;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.service.OptRecordService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/12/20
 * @Version V1.0
 * @Description: 操作记录service实现类
 **/
@Service("optRecordService")
public class OptRecordServiceImpl implements OptRecordService {
    @Resource
    private TaskDao taskDao;
    @Resource
    private OptRecordDao optRecordDao;
    @Override
    public HttpResult addOptRecord(OptRecord optRecord) {
        optRecordDao.insertOptRecord(optRecord);
        return HttpResult.success();
    }

    @Override
    public HttpResult addOptRecord(Task task, String operation) {
        OptRecord optRecord = new OptRecord();
        optRecord.setTaskId(task.getUuid());
        optRecord.setTaskType(task.getTaskType());
        optRecord.setOperation(operation);
        optRecord.setUserId(task.getCreatedBy());
        optRecord.setUuid(EncryptUtil.get32Uuid());
        return HttpResult.success();
    }

    @Override
    public HttpResult addOptRecord(String taskId, String userId, String operation) {
        OptRecord optRecord = new OptRecord();
        Task task = taskDao.selectById(taskId);
        optRecord.setTaskId(taskId);
        optRecord.setTaskType(task.getTaskType());
        optRecord.setOperation(operation);
        optRecord.setUserId(userId);
        optRecord.setUuid(EncryptUtil.get32Uuid());
        return HttpResult.success();
    }

    @Override
    public HttpResult getTaskRecord(String taskId) {
        Task task = taskDao.selectById(taskId);
        Byte type = task.getTaskType();
        if(type == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        return HttpResult.success(optRecordDao.selectByTaskIdAndType(taskId,type));
    }
}
