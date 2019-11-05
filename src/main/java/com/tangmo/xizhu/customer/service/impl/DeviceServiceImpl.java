package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.dao.DeviceDao;
import com.tangmo.xizhu.customer.entity.DeviceInfo;
import com.tangmo.xizhu.customer.service.DeviceService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/11/1
 * @Version V1.0
 * @Description: 设备信息service实现类
 **/
@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {
    @Resource
    private DeviceDao deviceDao;
    @Override
    public HttpResult getDeviceByUserId(String userId) {
        return HttpResult.success(deviceDao.selectByUserId(userId));
    }

    @Override
    public HttpResult getDeviceInfo(String deviceId) {
        return HttpResult.success(deviceDao.selectById(deviceId));
    }

    @Override
    public HttpResult addDevice(DeviceInfo deviceInfo) {
        if(deviceInfo == null || deviceInfo.getUserId() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        deviceInfo.setUuid(EncryptUtil.get32Uuid());
        deviceDao.insertDevice(deviceInfo);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeDevice(DeviceInfo deviceInfo) {
        if(deviceInfo == null || deviceInfo.getUuid() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        return HttpResult.success();
    }
}
