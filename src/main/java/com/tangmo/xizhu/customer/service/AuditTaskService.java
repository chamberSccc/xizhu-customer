package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.AuditTask;

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
}
