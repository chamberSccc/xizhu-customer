package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.UserDao;
import com.tangmo.xizhu.customer.entity.LogInfo;
import com.tangmo.xizhu.customer.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/10/15
 * @Version V1.0
 * @Description: 登录服务实现类
 **/
@Service("longinService")
public class loginServiceImpl implements LoginService {
    @Resource
    private UserDao userDao;
    @Override
    public HttpResult pcLogin(LogInfo logInfo) {
        return null;
    }

    @Override
    public HttpResult mobileLogin(LogInfo logInfo) {
        return null;
    }
}
