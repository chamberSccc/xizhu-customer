package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.Page;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.dao.DeviceDao;
import com.tangmo.xizhu.customer.entity.DeviceInfo;
import com.tangmo.xizhu.customer.service.DeviceService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public HttpResult getDeviceByPid(String devicePid) {
        return HttpResult.success(deviceDao.selectByPid(devicePid));
    }

    @Override
    public HttpResult getDeviceByFuzzyPid(String devicePid) {
        return HttpResult.success(deviceDao.selectByFuzzyPid(devicePid));
    }

    @Override
    public HttpResult addDevice(DeviceInfo deviceInfo) {
        if(deviceInfo == null || deviceInfo.getUserId() == null || deviceInfo.getDevicePid() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        DeviceInfo result = deviceDao.selectByPid(deviceInfo.getDevicePid());
        if(result != null){
            return HttpResult.fail(ResultCode.PID_EXIST);
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
        deviceDao.updateDevice(deviceInfo);
        return HttpResult.success();
    }

    @Override
    public HttpResult getDeviceList(Page page) {
        if(page == null){
            page = new Page();
        }
        page.startPage();
        List<DeviceInfo> list = deviceDao.selectAllDevice();
        page.setResult(list);
        return HttpResult.success(page);
    }
}
