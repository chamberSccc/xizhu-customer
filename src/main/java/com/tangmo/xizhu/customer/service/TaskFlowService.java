package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.TaskFlow;

/**
 * @Author chen bo
 * @Date 2019/10/15
 * @Version V1.0
 * @Description: 任务审核流程服务
 **/
public interface TaskFlowService {

    /**
     * @param taskFlow
     * @return
     * @author chen bo
     * @date 2019/10/15
     * @description: 新增任务操作流程
     */
    HttpResult addFlowService(TaskFlow taskFlow);
}
