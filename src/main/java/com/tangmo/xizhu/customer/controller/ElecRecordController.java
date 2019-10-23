package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
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
public class ElecRecordController extends BaseController{

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
        return null;
    }

    @ApiOperation(value = "新增安装工作记录(电气)表",httpMethod = "PUT",notes = "")
    @PutMapping("")
    public HttpResult changeElecRecord(@ApiParam(name="安装工作记录(电气)表对象",value="json格式",required=true) @RequestBody ElecRecord elecRecord){
        return null;
    }
}
