package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.MachineRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chen bo
 * @Date 2019/10/22
 * @Version V1.0
 * @Description: 安装工作记录(机械)表controller
 **/
@Api(description="安装工作记录(机械)表接口")
@RestController
@RequestMapping("/machineRecord")
public class MachineRecordController {

    /**
     * @param machineRecord
     * @return
     * @author chen bo
     * @date 2019/10/22
     * @description: 新增安装工作记录(机械)表
     */
    @ApiOperation(value = "新增安装工作记录(机械)表",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult addMachineRecord(@ApiParam(name="安装工作记录(机械)表对象",value="json格式",required=true) @RequestBody MachineRecord machineRecord){
        return null;
    }
}
