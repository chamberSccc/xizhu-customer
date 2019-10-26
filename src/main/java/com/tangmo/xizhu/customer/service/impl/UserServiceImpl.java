package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.UserDao;
import com.tangmo.xizhu.customer.entity.PwdInfo;
import com.tangmo.xizhu.customer.entity.User;
import com.tangmo.xizhu.customer.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/10/24
 * @Version V1.0
 * @Description: 用户service服务类
 **/
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public HttpResult addUser(User user) {
        return null;
    }

    @Override
    public HttpResult changePwd(PwdInfo pwdInfo) {
        User user = userDao.selectPwdByUserId(pwdInfo.getUserId());
        //判断面
        userDao.updatePwd(pwdInfo.getUserId(),pwdInfo.getNewPwd());
        return HttpResult.success();
    }

    @Override
    public HttpResult changeAvatar(String userId, String avatar) {
        userDao.updateAvatar(userId,avatar);
        return HttpResult.success();
    }

    @Override
    public HttpResult delUser(String userId) {
        userDao.deleteById(userId);
        return HttpResult.success();
    }

    @Override
    public HttpResult getUserInfo(String userId) {
        return HttpResult.success(userDao.selectByUserId(userId));
    }
}
