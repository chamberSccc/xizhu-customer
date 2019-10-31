package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.OutEquipCheck;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件调试现场服务验收单
 **/
public interface OutEquipCheckDao {

    /**
     * @param outEquipCheck
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 新增外购件调试现场服务验收单
     */
    Integer insertOutAudit(OutEquipCheck outEquipCheck);

    /**
     * @param outEquipCheck
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 修改外购件调试现场服务验收单
     */
    Integer updateOutApply(OutEquipCheck outEquipCheck);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 通过任务id查询外购件调试现场服务验收单
     */
    OutEquipCheck selectByTaskId(String taskId);
}
