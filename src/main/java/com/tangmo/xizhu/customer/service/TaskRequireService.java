package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.TaskRequire;

/**
 * @Author chen bo
 * @Date 2019/10/9
 * @Version V1.0
 * @Description: 任务需求单服务接口
 **/
public interface TaskRequireService {
    /**
     * @param taskRequire
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 新增服务任务需求单
     */
    HttpResult addTaskRequire(TaskRequire taskRequire);

    /**
     * @param taskRequire
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 修改服务任务需求单
     */
    HttpResult changeTaskRequire(TaskRequire taskRequire);

    /**
     * @param taskId 任务uuid
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 通过任务id查询服务任务需求单详情
     */
    HttpResult getByTaskId(String taskId);
}
