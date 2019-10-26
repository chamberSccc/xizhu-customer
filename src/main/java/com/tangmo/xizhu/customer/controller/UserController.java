package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/10/24
 * @Version V1.0
 * @Description:
 **/
@Api(description="用戶接口")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 获取用户信息
     */
    @ApiOperation(value = "获取用户信息",httpMethod = "GET",notes = "")
    @GetMapping("/info")
    public HttpResult getUserInfo(){
        return userService.getUserInfo(getUserId());
    }

    @ApiOperation(value = "删除用户",httpMethod = "GET",notes = "")
    @DeleteMapping("/{userId}")
    public HttpResult delUser(@PathVariable String userId){
        return userService.delUser(userId);
    }

    /**
     * @param user
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 新增用户信息
     */
    @ApiOperation(value = "新增用户",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    /**
     * @param user
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 修改用户信息
     */
    @ApiOperation(value = "修改用户信息",httpMethod = "PUT",notes = "")
    @PutMapping("")
    public HttpResult changeUser(@RequestBody User user){
        return null;
    }
    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 修改密码
     */
    @ApiOperation(value = "修改密码",httpMethod = "PUT",notes = "")
    @PutMapping("/pwd")
    public HttpResult changePwd(){
        return null;
    }
}
