package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.DeviceInfo;
import com.tangmo.xizhu.customer.service.DeviceService;
import org.springframework.stereotype.Service;

/**
 * @Author chen bo
 * @Date 2019/11/1
 * @Version V1.0
 * @Description: 设备信息service实现类
 **/
@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {
    @Override
    public HttpResult getDeviceByUserId(String userId) {
        return null;
    }

    @Override
    public HttpResult addDevice(DeviceInfo deviceInfo) {
        return null;
    }

    @Override
    public HttpResult changeDevice(DeviceInfo deviceInfo) {
        return null;
    }
}
