package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.constant.PunchTypeConst;
import com.tangmo.xizhu.customer.dao.TaskDao;
import com.tangmo.xizhu.customer.dao.TaskPunchDao;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.TaskPunch;
import com.tangmo.xizhu.customer.service.TaskPunchService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/11/16
 * @Version V1.0
 * @Description: 任务打卡实现类
 **/
@Service("taskPunchService")
public class TaskPunchServiceImpl implements TaskPunchService {
    @Resource
    private TaskPunchDao taskPunchDao;
    @Resource
    private TaskDao taskDao;

    @Override
    public HttpResult startPunch(TaskPunch taskPunch) {
        if(taskPunch == null || taskPunch.getTaskId() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        taskPunch.setUuid(EncryptUtil.get32Uuid());
        taskPunch.setPunchType(PunchTypeConst.OnDuty);
        Task task = taskDao.selectById(taskPunch.getTaskId());
        taskPunch.setTaskType(task.getTaskType());
        taskPunchDao.insertPunch(taskPunch);
        return HttpResult.success();
    }

    @Override
    public HttpResult endPunch(TaskPunch taskPunch) {
        if(taskPunch == null || taskPunch.getTaskId() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        taskPunch.setUuid(EncryptUtil.get32Uuid());
        taskPunch.setPunchType(PunchTypeConst.OffDuty);
        Task task = taskDao.selectById(taskPunch.getTaskId());
        taskPunch.setTaskType(task.getTaskType());
        taskPunchDao.insertPunch(taskPunch);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeStartPunch(TaskPunch taskPunch) {
        if(taskPunch == null || taskPunch.getUuid() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        taskPunchDao.updatePunch(taskPunch);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeEndPunch(TaskPunch taskPunch) {
        if(taskPunch == null || taskPunch.getUuid() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        taskPunchDao.updatePunch(taskPunch);
        return HttpResult.success();
    }

    @Override
    public HttpResult getUserPunch(String taskId, String userId, Byte punchType) {
        Task task = taskDao.selectById(taskId);
        return HttpResult.success(taskPunchDao.selectByUserAndType(taskId,userId,punchType,task.getTaskType()));
    }
}
