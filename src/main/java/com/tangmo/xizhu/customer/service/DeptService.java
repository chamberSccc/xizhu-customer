package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.Department;
import com.tangmo.xizhu.customer.entity.search.DeptSearch;

/**
 * @author boge
 * @date 2019/10/25
 * @description 部门service
 */

public interface DeptService {

    /**
     * @param department
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 添加部门
     */
    HttpResult addDept(Department department);

    /**
     * @param department
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 修改部门
     */
    HttpResult changeDept(Department department);

    /**
     * @param deptId
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 删除部门
     */
    HttpResult delDeptById(String deptId);

    /**
     * @param deptId
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 获取部门详情
     */
    HttpResult getDeptDetail(String deptId);

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 获取部门列表
     */
    HttpResult getDeptList();

    /**
     * @param deptSearch
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 获取分页部门列表
     */
    HttpResult getPageDept(DeptSearch deptSearch);

    /**
     * @param deptId
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 获取部门人员
     */
    HttpResult getDeptUser(String deptId);
}
