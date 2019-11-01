package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.OutEquipApply;
import com.tangmo.xizhu.customer.entity.OutEquipNotice;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件安装通知service
 **/
public interface EquipNoticeService {

    /**
     * @param outEquipNotice
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 添加外购件安装通知
     */
    HttpResult addOutNotice(OutEquipNotice outEquipNotice);

    /**
     * @param outEquipNotice
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 修改外购件安装通知
     */
    HttpResult changeOutNotice(OutEquipNotice outEquipNotice);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 通过任务id查询外购件安装通知
     */
    HttpResult getByTaskId(String taskId);
}
