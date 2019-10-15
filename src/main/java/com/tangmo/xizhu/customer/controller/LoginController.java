package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.LogInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenbo
 * @Date 2019/10/9
 * @Version V1.0
 * @Description: 登录controller
 **/
@RestController
@RequestMapping("/login")
public class LoginController {

    /**
     * @param logInfo
     * @return
     * @author chen bo
     * @date 2019/10/15
     * @description: pc端登录
     */
    @PostMapping("/pc")
    public HttpResult pcLogin(LogInfo logInfo){
        return null;
    }
    /**
     * @param logInfo
     * @return
     * @author chen bo
     * @date 2019/10/15
     * @description: 移动端登录
     */
    @PostMapping("/mobile")
    public HttpResult mobileLogin(LogInfo logInfo){
        return null;
    }
}
