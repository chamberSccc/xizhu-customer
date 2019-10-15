package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.Page;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.search.TaskSearch;
import com.tangmo.xizhu.customer.service.TaskService;
import org.springframework.stereotype.Service;

/**
 * @Author chen bo
 * @Date 2019/10/15
 * @Version V1.0
 * @Description: 任务服务实现类
 **/
@Service("taskService")
public class TaskServiceImpl implements TaskService {
    @Override
    public HttpResult createTask(Task task) {
        return null;
    }

    @Override
    public HttpResult changeTask(Task task) {
        return null;
    }

    @Override
    public HttpResult getUndoTaskList(String userId, Page page) {
        return null;
    }

    @Override
    public HttpResult getDoneTaskList(String userId, Page page) {
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
