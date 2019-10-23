package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.SafeConfide;

/**
 * @Author chen bo
 * @Date 2019/10/23
 * @Version V1.0
 * @Description: 安全交底表service
 **/
public interface SafeConfideService {

    /**
     * @param safeConfide
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 新增安全交底表
     */
    HttpResult addSafeConfide(SafeConfide safeConfide);

    /**
     * @param safeConfide
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 修改安全交底表
     */
    HttpResult changeSafeConfide(SafeConfide safeConfide);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 获取任务的安全交底表
     */
    HttpResult getByTaskId(String taskId);
}
