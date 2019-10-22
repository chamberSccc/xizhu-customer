package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.SafeConfide;
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
 * @Description: 安全交底表controller
 **/
@Api(description="安全交底表接口")
@RestController
@RequestMapping("/safeConfide")
public class SafeConfideController {

    @ApiOperation(value = "新增安全交底表",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult addSafeConfide(@ApiParam(name="安全交底表对象",value="json格式",required=true) @RequestBody SafeConfide safeConfide){
        return null;
    }
}
