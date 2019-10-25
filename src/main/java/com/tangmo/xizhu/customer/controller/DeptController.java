package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.Department;
import com.tangmo.xizhu.customer.entity.User;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author boge
 * @date 2019/10/25
 * @description 部门
 */
@Api(description="部门接口")
@RestController
@RequestMapping("/dept")
public class DeptController {

    public HttpResult<Department> addDept(@RequestBody Department department){
        return null;
    }

    public HttpResult<List<Department>> getDeptList(){
        return null;
    }

    public HttpResult<List<User>> getDeptUser(String deptId){
        return null;
    }
}
