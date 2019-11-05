package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.constant.UserTypeConst;
import com.tangmo.xizhu.customer.dao.UserDao;
import com.tangmo.xizhu.customer.entity.User;
import com.tangmo.xizhu.customer.entity.search.UserSearch;
import com.tangmo.xizhu.customer.service.CustomerService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/11/5
 * @Version V1.0
 * @Description: 客户信息service实现类
 **/
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private UserDao userDao;
    @Override
    public HttpResult addCustomer(User user) {
        user.setUuid(EncryptUtil.get32Uuid());
        user.setUserType(UserTypeConst.CUSTOMER);
        userDao.insertUser(user);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeCustomer(User user) {
        if(user == null || user.getUuid() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        user.setPassword(null);
        userDao.updateUser(user);
        return HttpResult.success();
    }

    @Override
    public HttpResult getUserDevice(String userId) {
        return null;
    }

    @Override
    public HttpResult getCustomerList(UserSearch userSearch) {
        return null;
    }
}
