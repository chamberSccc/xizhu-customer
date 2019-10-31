package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.OutEquipApply;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件安装申请service
 **/
public interface EquipApplyService {

    /**
     * @param outEquipApply
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 添加外购件安装申请单
     */
    HttpResult addOutApply(OutEquipApply outEquipApply);

    /**
     * @param outEquipApply
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 修改外购件安装申请单
     */
    HttpResult changeOutApply(OutEquipApply outEquipApply);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 通过任务id查询外购件安装申请单
     */
    HttpResult getByTaskId(String taskId);
}
