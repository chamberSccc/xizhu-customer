package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.ElecRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/10/22
 * @Version V1.0
 * @Description: 安装工作记录(电气)表 controller
 **/
@Api(description="安装工作记录(电气)表接口")
@RestController
@RequestMapping("/elecRecord")
public class ElecRecordController extends BaseController {

    /**
     * @param elecRecord
     * @return
     * @author chen bo
     * @date 2019/10/22
     * @description: 新增安装工作记录(电气)表
     */
    @ApiOperation(value = "新增安装工作记录(电气)表",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult addElecRecord(@ApiParam(name="安装工作记录(电气)表对象",value="json格式",required=true) @RequestBody ElecRecord elecRecord){
        return elecRecordService.addRecord(elecRecord);
    }

    /**
     * @param elecRecord
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 修改安装工作记录(电气)表
     */
    @ApiOperation(value = "修改安装工作记录(电气)表",httpMethod = "PUT",notes = "")
    @PutMapping("")
    public HttpResult changeElecRecord(@ApiParam(name="安装工作记录(电气)表对象",value="json格式",required=true) @RequestBody ElecRecord elecRecord){
        return elecRecordService.changeRecord(elecRecord);
    }

    /**
     * @param recordId
     * @return
     * @author chen bo
     * @date 2019/10/30
     * @description: 获取电气安装工作记录详情
     */
    @ApiOperation(value = "获取电气安装工作记录详情",httpMethod = "GET",notes = "")
    @GetMapping("/{recordId}")
    public HttpResult getRecordInfo(@PathVariable String recordId){
        return elecRecordService.getByRecordId(recordId);
    }
}
