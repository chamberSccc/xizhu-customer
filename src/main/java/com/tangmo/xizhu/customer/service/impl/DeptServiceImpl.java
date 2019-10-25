package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.DeptDao;
import com.tangmo.xizhu.customer.dao.UserDao;
import com.tangmo.xizhu.customer.entity.Department;
import com.tangmo.xizhu.customer.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 2019/10/25
 * @description 部门service实现类
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService{
    @Resource
    private DeptDao deptDao;
    @Resource
    private UserDao userDao;
    @Override
    public HttpResult addDept(Department department) {
        return null;
    }

    @Override
    public HttpResult changeDept(Department department) {
        return null;
    }

    @Override
    public HttpResult delDeptById(String deptId) {
        return null;
    }

    @Override
    public HttpResult getDeptDetail(String deptId) {
        return null;
    }

    @Override
    public HttpResult getDeptList() {
        return HttpResult.success(deptDao.selectAllDept());
    }

    @Override
    public HttpResult getPageDept() {
        return null;
    }

    @Override
    public HttpResult getDeptUser(String deptId) {
        return HttpResult.success(userDao.selectByDeptId(deptId));
    }
}
