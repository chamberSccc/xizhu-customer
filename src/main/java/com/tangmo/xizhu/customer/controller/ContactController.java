package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chen bo
 * @Date 2020/1/16
 * @Version V1.0
 * @Description: 通讯录接口
 **/
@Api(description="通讯录接口")
@RestController
@RequestMapping("/contact")
public class ContactController extends BaseController {

    @ApiOperation(value = "获取所有通讯录",httpMethod = "GET",notes = "")
    @GetMapping("/all")
    public HttpResult getAllContact(){
        return userService.getAllContact();
    }
}
