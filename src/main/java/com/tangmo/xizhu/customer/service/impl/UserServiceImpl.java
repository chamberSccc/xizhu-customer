package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.User;
import com.tangmo.xizhu.customer.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author chen bo
 * @Date 2019/10/24
 * @Version V1.0
 * @Description: 用户service服务类
 **/
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public HttpResult addUser(User user) {
        return null;
    }

    @Override
    public HttpResult changePwd(User user) {
        return null;
    }

    @Override
    public HttpResult changeAvatar(String userId, String avatar) {
        return null;
    }

    @Override
    public HttpResult delUser(String userId) {
        return null;
    }

    @Override
    public HttpResult getUserInfo(String userId) {
        return null;
    }
}
