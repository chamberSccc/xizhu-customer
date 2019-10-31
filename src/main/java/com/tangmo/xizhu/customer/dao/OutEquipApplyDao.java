package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.OutEquipApply;
import org.springframework.stereotype.Repository;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件安装调试申请单dao
 **/
@Repository
public interface OutEquipApplyDao {

    /**
     * @param outEquipApply
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 新增外购件安装调试申请单
     */
    Integer insertOutApply(OutEquipApply outEquipApply);

    /**
     * @param outEquipApply
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 修改外购件安装调试申请单
     */
    Integer updateOutApply(OutEquipApply outEquipApply);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 通过任务id查询外购件安装调试申请单
     */
    OutEquipApply selectByTaskId(String taskId);
}
