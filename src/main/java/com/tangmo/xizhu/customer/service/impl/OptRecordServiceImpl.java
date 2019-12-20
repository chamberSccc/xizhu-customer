package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.dao.OptRecordDao;
import com.tangmo.xizhu.customer.dao.TaskDao;
import com.tangmo.xizhu.customer.entity.OptRecord;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.service.OptRecordService;
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
    public HttpResult getTaskRecord(String taskId) {
        Task task = taskDao.selectById(taskId);
        Byte type = task.getTaskType();
        if(type == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        return HttpResult.success(optRecordDao.selectByTaskIdAndType(taskId,type));
    }
}
