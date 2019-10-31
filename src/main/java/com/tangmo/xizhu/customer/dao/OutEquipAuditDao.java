package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.OutEquipAudit;
import org.springframework.stereotype.Repository;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件安装调试授权审批单dao
 **/
@Repository
public interface OutEquipAuditDao {

    /**
     * @param outEquipAudit
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 新增外购件安装调试授权审批单
     */
    Integer insertOutAudit(OutEquipAudit outEquipAudit);

    /**
     * @param outEquipAudit
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 修改外购件安装调试授权审批单
     */
    Integer updateOutAudit(OutEquipAudit outEquipAudit);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 通过任务id查询外购件安装调试授权审批单
     */
    OutEquipAudit selectByTaskId(String taskId);
}
