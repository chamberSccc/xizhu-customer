package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.DeviceInfo;
import com.tangmo.xizhu.customer.entity.search.TaskSearch;
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

    /**
     * @param pid
     * @return
     * @author chen bo
     * @date 2019/11/12
     * @description: 通过设备pid查询设备信息
     */
    @ApiOperation(value = "通过设备pid获取设备详情",httpMethod = "GET",notes = "")
    @GetMapping("/pidSearch/{pid}")
    public HttpResult getDeviceByPid(@PathVariable String pid){
        return deviceService.getDeviceByPid(pid);
    }

    /**
     * @param pid
     * @return
     * @author chen bo
     * @date 2019/11/12
     * @description: 通过设备pid模糊查询设备信息
     */
    @ApiOperation(value = "通过设备pid模糊查询设备信息",httpMethod = "GET",notes = "")
    @GetMapping("/pidFuzzy/{pid}")
    public HttpResult getDeviceByFuzzyPid(@PathVariable String pid){
        return deviceService.getDeviceByFuzzyPid(pid);
    }

    /**
     * @param pid
     * @return
     * @author chen bo
     * @date 2019/11/12
     * @description: 通过设备pid查询设备维修历史
     */
    @ApiOperation(value = "通过设备pid查询设备维修历史，分页",httpMethod = "GET",notes = "")
    @GetMapping("/{pid}/task")
    public HttpResult getDeviceTaskByPid(@PathVariable String pid, TaskSearch taskSearch){
        return taskService.getTaskListByPid(taskSearch,pid);
    }
}
