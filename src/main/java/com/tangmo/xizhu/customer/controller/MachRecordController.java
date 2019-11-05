package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.MachRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/10/22
 * @Version V1.0
 * @Description: 安装工作记录(机械)表controller
 **/
@Api(description="安装工作记录(机械)表接口")
@RestController
@RequestMapping("/machineRecord")
public class MachRecordController extends BaseController {

    /**
     * @param machRecord
     * @return
     * @author chen bo
     * @date 2019/10/22
     * @description: 新增安装工作记录(机械)表
     */
    @ApiOperation(value = "新增安装工作记录(机械)表",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult addMachRecord(@ApiParam(name="安装工作记录(机械)表对象",value="json格式",required=true) @RequestBody MachRecord machRecord){
        return machRecordService.addRecord(machRecord);
    }

    /**
     * @param machRecord
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 修改安装工作记录机械表
     */
    @ApiOperation(value = "修改安装工作记录(机械)表",httpMethod = "PUT",notes = "")
    @PutMapping("")
    public HttpResult changeMachRecord(@ApiParam(name="安装工作记录(机械)表对象",value="json格式",required=true) @RequestBody MachRecord machRecord){
        return machRecordService.changeRecord(machRecord);
    }

    /**
     * @param recordId
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 通过id获取安装工作记录机械表详情
     */
    @ApiOperation(value = "通过id获取安装工作记录机械表详情",httpMethod = "GET",notes = "")
    @GetMapping("/{recordId}")
    public HttpResult getRecordById(@PathVariable String recordId){
        return machRecordService.getByRecordId(recordId);
    }
}
