package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.DeviceInfo;

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

    /**
     * @param deviceId
     * @return
     * @author chen bo
     * @date 2019/11/5
     * @description: 查看设备详情
     */
    HttpResult getDeviceInfo(String deviceId);

    /**
     * @param devicePid
     * @return
     * @author chen bo
     * @date 2019/11/12
     * @description: 通过pid查询设备详情
     */
    HttpResult getDeviceByPid(String devicePid);

    /**
     * @param devicePid
     * @return
     * @author chen bo
     * @date 2019/11/12
     * @description: 通过pid模糊查询设备详情
     */
    HttpResult getDeviceByFuzzyPid(String devicePid);

    /**
     * @param deviceInfo
     * @return
     * @author chen bo
     * @date 2019/11/2
     * @description: 增加设备信息
     */
    HttpResult addDevice(DeviceInfo deviceInfo);

    /**
     * @param deviceInfo
     * @return
     * @author chen bo
     * @date 2019/11/2
     * @description: 修改设备信息
     */
    HttpResult changeDevice(DeviceInfo deviceInfo);
}
