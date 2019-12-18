package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.LogInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenbo
 * @Date 2019/10/9
 * @Version V1.0
 * @Description: 登录controller
 **/
@Api(description = "登录相关接口")
@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

    /**
     * @param logInfo
     * @return
     * @author chen bo
     * @date 2019/10/15
     * @description: 登录操作
     */
    @ApiOperation(value = "登录接口",httpMethod = "POST",notes = "登录接口")
    @PostMapping("")
    public HttpResult userLogin(@ApiParam(name="用户对象",value="json格式",required=true) @RequestBody LogInfo logInfo){
        return loginService.userLogin(logInfo);
    }

    /**
     * @param logInfo
     * @return
     * @author chen bo
     * @date 2019/10/15
     * @description: 网页登录操作
     */
    @ApiOperation(value = "管理员登录",httpMethod = "POST",notes = "登录接口")
    @PostMapping("/admin")
    public HttpResult adminLogin(@ApiParam(name="用户对象",value="json格式",required=true) @RequestBody LogInfo logInfo){
        return loginService.adminLogin(logInfo);
    }

    /**
     * @param logInfo
     * @return
     * @author chen bo
     * @date 2019/11/1
     * @description: 微信端登录
     */
    @ApiOperation(value = "微信端登录接口",httpMethod = "POST",notes = "登录接口")
    @PostMapping("/wechat")
    public HttpResult wechatLogin(@ApiParam(name="用户对象",value="json格式",required=true) @RequestBody LogInfo logInfo){
        return loginService.wechatLogin(logInfo);
    }
}
