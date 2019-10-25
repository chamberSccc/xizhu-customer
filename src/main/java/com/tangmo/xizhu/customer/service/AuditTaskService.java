package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.AuditTask;
import com.tangmo.xizhu.customer.entity.search.TaskSearch;

/**
 * @Author chen bo
 * @Date 2019/10/21
 * @Version V1.0
 * @Description: 审核service
 **/
public interface AuditTaskService {

    /**
     * @param auditTask
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 分发任务
     */
    HttpResult assignTask(AuditTask auditTask);

    /**
     * @param auditTask
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 拒绝任务
     */
    HttpResult rejectTask(AuditTask auditTask);

    /**
     * @param auditTask
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 标记任务完成
     */
    HttpResult finishTask(AuditTask auditTask);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 检查任务是否已完成
     */
    Boolean checkTaskStatus(String taskId);

    /**
     * 获取待审批列表
     * @param userId
     * @param taskSearch
     * @return
     */
    HttpResult getUndoAuditList(String userId,TaskSearch taskSearch);

    /**
     * 获取已审批列表
     * @param userId
     * @param taskSearch
     * @return
     */
    HttpResult getDoneAuditList(String userId,TaskSearch taskSearch);

    /**
     * 获取已拒绝审批列表
     * @param userId
     * @param taskSearch
     * @return
     */
    HttpResult getRejectAuditList(String userId,TaskSearch taskSearch);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 获取任务审批流
     */
    HttpResult getAuditFlowList(String taskId);
}
