package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(description="主页相关接口")
@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public HttpResult test(String a, String b){
        return HttpResult.success();
    }
}
