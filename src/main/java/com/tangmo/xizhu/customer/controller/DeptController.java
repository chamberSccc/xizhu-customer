package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.Department;
import com.tangmo.xizhu.customer.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author boge
 * @date 2019/10/25
 * @description 部门
 */
@Api(description="部门接口")
@RestController
@RequestMapping("/dept")
public class DeptController extends BaseController {
    /**
     * @param department
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 增加部门
     */
    @ApiOperation(value = "添加部门",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult<Department> addDept(@RequestBody Department department){
        return null;
    }

    /**
     * @param department
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 修改部门信息
     */
    @ApiOperation(value = "修改部门",httpMethod = "POST",notes = "")
    @PutMapping("")
    public HttpResult changeDept(@RequestBody Department department){
        return null;
    }

    /**
     * @param deptId
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 删除部门信息
     */
    @ApiOperation(value = "删除部门",httpMethod = "DELETE",notes = "")
    @DeleteMapping("/{deptId}")
    public HttpResult delDept(@PathVariable String deptId){
        return null;
    }


    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 查询部门列表
     */
    @ApiOperation(value = "添加部门",httpMethod = "POST",notes = "")
    @GetMapping("/deptList")
    public HttpResult<List<Department>> getDeptList(){
        return deptService.getDeptList();
    }

    /**
     * @param deptId
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 查询部门人员列表
     */
    @GetMapping("/{deptId}")
    public HttpResult<List<User>> getDeptUser(@PathVariable String deptId){
        return deptService.getDeptUser(deptId);
    }
}
