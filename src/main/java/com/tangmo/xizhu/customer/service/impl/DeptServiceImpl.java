package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.Department;
import com.tangmo.xizhu.customer.service.DeptService;
import org.springframework.stereotype.Service;

/**
 * @author boge
 * @date 2019/10/25
 * @description 部门service实现类
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService{
    @Override
    public HttpResult addDept(Department department) {
        return null;
    }

    @Override
    public HttpResult getDeptList() {
        return null;
    }

    @Override
    public HttpResult getDeptUser(String userId) {
        return null;
    }
}
