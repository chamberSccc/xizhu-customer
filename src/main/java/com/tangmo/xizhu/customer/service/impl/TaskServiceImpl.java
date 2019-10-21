package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.Page;
import com.tangmo.xizhu.customer.constant.TaskAssignType;
import com.tangmo.xizhu.customer.constant.TaskStatus;
import com.tangmo.xizhu.customer.dao.TaskDao;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.search.TaskSearch;
import com.tangmo.xizhu.customer.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/10/15
 * @Version V1.0
 * @Description: 任务服务实现类
 **/
@Service("taskService")
public class TaskServiceImpl implements TaskService {
    @Resource
    private TaskDao taskDao;
    @Override
    public HttpResult createTask(Task task) {
        taskDao.insertTask(task);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeTask(Task task) {
        return null;
    }

    @Override
    public HttpResult changeTaskUser(String taskId, String userId, Byte taskStatus) {
        taskDao.updateTaskUser(taskId, userId, taskStatus);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeTaskStatus(String taskId, Byte status) {
        taskDao.updateStatus(taskId,status);
        return HttpResult.success();
    }

    @Override
    public HttpResult getUndoTaskList(String userId, TaskSearch taskSearch) {
        return HttpResult.success(taskDao.selectByStatusAndUser(userId,TaskStatus.DEALING));
    }

    @Override
    public HttpResult getDoneTaskList(String userId, TaskSearch taskSearch) {
        return HttpResult.success(taskDao.selectByStatusAndUser(userId,TaskStatus.COMPLETE));
    }

    @Override
    public HttpResult getLaunchTaskList(String userId, TaskSearch taskSearch) {
        return null;
    }

    @Override
    public HttpResult getUndoTaskCount(String userId) {
        return null;
    }

    @Override
    public HttpResult getTaskListBySearch(TaskSearch taskSearch) {
        return null;
    }

    @Override
    public HttpResult commitTask(Task task) {
        return null;
    }
}
