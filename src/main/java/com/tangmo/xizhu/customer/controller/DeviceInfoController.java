package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.DeviceInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/11/5
 * @Version V1.0
 * @Description:用户设备接口
 **/
@Api(description="客户设备接口")
@RestController
@RequestMapping("/device")
public class DeviceInfoController extends BaseController {

    /**
     * @param deviceInfo
     * @return
     * @author chen bo
     * @date 2019/11/5
     * @description: 添加设备
     */
    @ApiOperation(value = "新增用户设备",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult addDevice(@RequestBody DeviceInfo deviceInfo){
        return deviceService.addDevice(deviceInfo);
    }

    /**
     * @param deviceInfo
     * @return
     * @author chen bo
     * @date 2019/11/5
     * @description: 修改设备信息
     */
    @ApiOperation(value = "修改用户设备",httpMethod = "PUT",notes = "")
    @PutMapping("")
    public HttpResult changeDevice(@RequestBody DeviceInfo deviceInfo){
        return deviceService.changeDevice(deviceInfo);
    }

    /**
     * @param deviceId
     * @return
     * @author chen bo
     * @date 2019/11/5
     * @description: 获取设备详情
     */
    @ApiOperation(value = "获取设备详情",httpMethod = "GET",notes = "")
    @GetMapping("/{deviceId}")
    public HttpResult getDeviceInfo(@PathVariable String deviceId){
        return deviceService.getDeviceInfo(deviceId);
    }
}
