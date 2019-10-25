package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.Department;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/24
 * @Version V1.0
 * @Description:
 **/
public interface DeptDao {
    /**
     * @param department
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 新增部门
     */
    void insertDept(Department department);

    /**
     * @param department
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 修改部门
     */
    void updateDept(Department department);

    /**
     * @param deptId
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 通过id删除部门
     */
    void deleteById(String deptId);

    /**
     * @param deptId
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 查询部门详情
     */
    Department selectById(String deptId);

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 查询所有部门列表
     */
    List<Department> selectAllDept();
}
