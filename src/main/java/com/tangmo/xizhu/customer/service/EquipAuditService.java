package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.OutEquipAudit;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件安装审批service
 **/
public interface EquipAuditService {

    /**
     * @param outEquipAudit
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 添加外购件安装审批
     */
    HttpResult addOutApply(OutEquipAudit outEquipAudit);

    /**
     * @param outEquipAudit
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 外购件安装审批
     */
    HttpResult changeOutApply(OutEquipAudit outEquipAudit);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 通过任务id查询外购件安装审批
     */
    HttpResult getByTaskId(String taskId);
}
