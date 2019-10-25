package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.Department;

/**
 * @author boge
 * @date 2019/10/25
 * @description 部门service
 */

public interface DeptService {

    HttpResult addDept(Department department);

    HttpResult getDeptList();

    HttpResult getDeptUser(String userId);
}
