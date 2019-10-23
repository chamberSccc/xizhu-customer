package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.DeviceFile;
import com.tangmo.xizhu.customer.entity.SafeConfide;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/10/22
 * @Version V1.0
 * @Description: 设备档案表controller
 **/
@Api(description="设备档案表接口")
@RestController
@RequestMapping("/deviceFile")
public class DeviceFileController extends BaseController{

    /**
     * @param deviceFile
     * @return
     * @author chen bo
     * @date 2019/10/22
     * @description: 新增设备档案表
     */
    @ApiOperation(value = "新增设备档案表",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult addDeviceFile(@ApiParam(name="设备档案表对象",value="json格式",required=true) @RequestBody DeviceFile deviceFile){
        return deviceFileService.addDeviceFile(deviceFile);
    }
    /**
     * @param deviceFile
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 修改设备档案表
     */
    @ApiOperation(value = "修改设备档案表",httpMethod = "PUT",notes = "")
    @PutMapping("")
    public HttpResult changeDeviceFile(@ApiParam(name="设备档案表对象",value="json格式",required=true) @RequestBody DeviceFile deviceFile){
        return deviceFileService.changeDeviceFile(deviceFile);
    }
}
