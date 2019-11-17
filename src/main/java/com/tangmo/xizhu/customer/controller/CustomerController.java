package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.User;
import com.tangmo.xizhu.customer.entity.search.UserSearch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/11/4
 * @Version V1.0
 * @Description:
 **/
@Api(description="客户管理接口")
@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController {

    /**
     * @param userId
     * @return
     * @author chen bo
     * @date 2019/11/5
     * @description: 获取客户设备列表
     */
    @ApiOperation(value = "获取客户设备列表",httpMethod = "GET",notes = "")
    @GetMapping("/{userId}/device")
    public HttpResult getUserDevice(@PathVariable String userId){
        return deviceService.getDeviceByUserId(userId);
    }

    /**
     * @param user
     * @return
     * @author chen bo
     * @date 2019/11/5
     * @description: 新增客户信息
     */
    @ApiOperation(value = "新增客户信息",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult addCustomer(@RequestBody User user){
        if(user == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        user.setCreatedBy(getUserId());
        return customerService.addCustomer(user);
    }

    /**
     * @param user
     * @return
     * @author chen bo
     * @date 2019/11/5
     * @description: 修改客户信息
     */
    @ApiOperation(value = "修改客户信息",httpMethod = "PUT",notes = "")
    @PutMapping("")
    public HttpResult changeCustomer(@RequestBody User user){
        return customerService.changeCustomer(user);
    }

    /**
     * @param userSearch
     * @return
     * @author chen bo
     * @date 2019/11/5
     * @description: 获取客户列表
     */
    @ApiOperation(value = "获取客户列表",httpMethod = "POST",notes = "")
    @PostMapping("/list")
    public HttpResult getCustomerList(@RequestBody UserSearch userSearch){
        return customerService.getCustomerList(userSearch);
    }

}
