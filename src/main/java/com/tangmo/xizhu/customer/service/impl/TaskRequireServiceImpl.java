package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.TaskRequireDao;
import com.tangmo.xizhu.customer.entity.TaskRequire;
import com.tangmo.xizhu.customer.service.TaskRequireService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description:
 **/
@Service("taskRequireService")
public class TaskRequireServiceImpl implements TaskRequireService {
    @Resource
    private TaskRequireDao taskRequireDao;
    @Override
    public HttpResult addTaskRequire(TaskRequire taskRequire) {
        taskRequireDao.insertTaskRequire(taskRequire);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeTaskRequire(TaskRequire taskRequire) {
        taskRequireDao.updateTaskRequire(taskRequire);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        return HttpResult.success(taskRequireDao.selectByTaskId(taskId));
    }
}
