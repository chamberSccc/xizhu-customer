package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;

/**
 * @Author chen bo
 * @Date 2019/11/1
 * @Version V1.0
 * @Description: 设备service
 **/
public interface DeviceService {

    /**
     * @param userId
     * @return
     * @author chen bo
     * @date 2019/11/1
     * @description: 获取用户设备信息
     */
    HttpResult getDeviceByUserId(String userId);
}
