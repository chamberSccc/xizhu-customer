package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.PwdInfo;
import com.tangmo.xizhu.customer.entity.User;
import com.tangmo.xizhu.customer.entity.search.UserSearch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    /**
     * @param userId
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 删除用户信息
     */
    @ApiOperation(value = "删除用户",httpMethod = "DELETE",notes = "")
    @DeleteMapping("/{userId}")
    public HttpResult<User> delUser(@PathVariable String userId){
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
        user.setCreatedBy(getUserId());
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
    public HttpResult changeUser(@ApiParam(name="审批信息对象",value="json格式",required=true) @RequestBody User user){
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
    public HttpResult changePwd(@RequestBody PwdInfo pwdInfo){
        pwdInfo.setUserId(getUserId());
        return userService.changePwd(pwdInfo);
    }
    /**
     * @param userId
     * @return
     * @author chen bo
     * @date 2019/11/1
     * @description: 获取用户设备列表
     */
    @ApiOperation(value = "获取用户设备列表",httpMethod = "PUT",notes = "")
    @GetMapping("/{userId}/device")
    public HttpResult getUserDevice(@PathVariable String userId){
        return null;
    }

    /**
     * @param userSearch
     * @return
     * @author chen bo
     * @date 2019/11/2
     * @description: 获取用户列表，分页
     */
    @ApiOperation(value = "获取用户列表，分页",httpMethod = "POST",notes = "")
    @PostMapping("/list")
    public HttpResult getUserList(@RequestBody UserSearch userSearch){
        return userService.getUserList(userSearch);
    }

    /**
     * @param userSearch
     * @return
     * @author chen bo
     * @date 2019/11/2
     * @description: 获取客户列表，分页
     */
    @ApiOperation(value = "获取客户列表，分页",httpMethod = "POST",notes = "")
    @PostMapping("/customer/list")
    public HttpResult getCustomerList(@RequestBody UserSearch userSearch){
        return userService.getCustomerList(userSearch);
    }
}
