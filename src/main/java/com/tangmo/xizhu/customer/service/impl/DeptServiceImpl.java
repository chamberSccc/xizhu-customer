package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.Page;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.dao.DeptDao;
import com.tangmo.xizhu.customer.dao.UserDao;
import com.tangmo.xizhu.customer.entity.Department;
import com.tangmo.xizhu.customer.entity.search.DeptSearch;
import com.tangmo.xizhu.customer.service.DeptService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        department.setUuid(EncryptUtil.get32Uuid());
        if(department == null || department.getDeptName() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        deptDao.insertDept(department);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeDept(Department department) {
        if(department == null || department.getDeptName() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        deptDao.updateDept(department);
        return HttpResult.success();
    }

    @Override
    public HttpResult delDeptById(String deptId) {
        deptDao.deleteById(deptId);
        return HttpResult.success();
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
    public HttpResult getPageDept(DeptSearch deptSearch) {
        Page page = deptSearch;
        page.startPage();
        List<Department> list = deptDao.selectAllDept();
        page.setResult(list);
        return HttpResult.success(page);
    }

    @Override
    public HttpResult getDeptUser(String deptId) {
        return HttpResult.success(userDao.selectByDeptId(deptId));
    }
}
