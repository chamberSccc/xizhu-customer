package com.tangmo.xizhu.customer.service;


import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.Page;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.search.TaskSearch;
/**
 * @return
 * @author chen bo
 * @date 2019/10/15
 * @description: 任务service接口
 */
public interface TaskService {
    /**
     * @param task
     * @return com.tangmo.xizhu.customer.common.HttpResult
     * @author chen bo
     * @date 2019/10/15
     * @description: 发起任务
     */
    HttpResult createTask(Task task);

    /**
     * @param task
     * @return com.tangmo.xizhu.customer.common.HttpResult
     * @author chen bo
     * @date 2019/10/15
     * @description: 修改任务
     */
    HttpResult changeTask(Task task);

    /**
     * @param userId
     * @return com.tangmo.xizhu.customer.common.HttpResult
     * @author chen bo
     * @date 2019/10/15
     * @description: 获取未完成任务列表
     */
    HttpResult getUndoTaskList(String userId, TaskSearch taskSearch);

    /**
     * @param userId
     * @param taskSearch	分页和查询参数
     * @return com.tangmo.xizhu.customer.common.HttpResult
     * @author chen bo
     * @date 2019/10/15
     * @description: 已完成任务列表
     */
    HttpResult getDoneTaskList(String userId,TaskSearch taskSearch);

    /**
     * @param userId
     * @param taskSearch
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 我发起的任务列表
     */
    HttpResult getLaunchTaskList(String userId,TaskSearch taskSearch);

    /**
     * @param userId
     * @return com.tangmo.xizhu.customer.common.HttpResult
     * @author chen bo
     * @date 2019/10/15
     * @description: 获取未完成任务
     */
    HttpResult getUndoTaskCount(String userId);

    /**
     * @param taskSearch
     * @return com.tangmo.xizhu.customer.common.HttpResult
     * @author chen bo
     * @date 2019/10/15
     * @description: 通过搜索条件查询任务
     */
    HttpResult getTaskListBySearch(TaskSearch taskSearch);

    /**
     * @param task
     * @return com.tangmo.xizhu.customer.common.HttpResult
     * @author chen bo
     * @date 2019/10/15
     * @description: 提交任务
     */
    HttpResult commitTask(Task task);
}
