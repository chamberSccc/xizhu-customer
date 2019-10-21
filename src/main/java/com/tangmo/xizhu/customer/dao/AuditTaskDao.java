package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.AuditTask;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/21
 * @Version V1.0
 * @Description: 审核任务dao
 **/
@Repository
public interface AuditTaskDao {

    /**
     * @param auditTask
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 新增审核任务
     */
    void insertAuditTask(AuditTask auditTask);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 查询任务的审核信息
     */
    List<AuditTask> selectByTaskId(Integer taskId);
}
