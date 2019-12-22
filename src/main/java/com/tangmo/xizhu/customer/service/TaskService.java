package com.tangmo.xizhu.customer.service;


import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.Page;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.TaskPunch;
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
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 获取任务详情
     */
    HttpResult getTaskDetail(String taskId);

    /**
     * @param taskId
     * @param userId
     * @param taskStatus
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 修改任务执行人
     */
    HttpResult changeTaskUser(String taskId,String userId,Byte taskStatus,Byte taskType);

    /**
     * @param taskId
     * @param status
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 修改任务状态
     */
    HttpResult changeTaskStatus(String taskId,Byte status);

    /**
     * @param userId
     * @return com.tangmo.xizhu.customer.common.HttpResult
     * @author chen bo
     * @date 2019/10/15
     * @description: 获取未完成任务列表，分页
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
     * @description: 获取未完成任务数量
     */
    HttpResult getUndoTaskCount(String userId);

    /**
     * @param deptId
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 获取未审核任务数量
     */
    HttpResult getUnauditCount(String deptId);

    /**
     * @param taskSearch
     * @return com.tangmo.xizhu.customer.common.HttpResult
     * @author chen bo
     * @date 2019/10/15
     * @description: 通过搜索条件查询任务
     */
    HttpResult getTaskListBySearch(TaskSearch taskSearch);

    /**
     * @param taskSearch
     * @param pid
     * @return
     * @author chen bo
     * @date 2019/11/12
     * @description: 通过设备pid查询设备任务信息
     */
    HttpResult getTaskListByPid(TaskSearch taskSearch, String pid);

    /**
     * @param taskId
     * @return com.tangmo.xizhu.customer.common.HttpResult
     * @author chen bo
     * @date 2019/10/15
     * @description: 提交任务
     */
    HttpResult commitTask(String taskId,String userId);


    /**
     * @param taskId
     * @param userType
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 查询要显示的单子列表
     */
    HttpResult getFormList(String taskId,Byte userType);
}
