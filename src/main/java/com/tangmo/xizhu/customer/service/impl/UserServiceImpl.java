package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.Page;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.dao.UserDao;
import com.tangmo.xizhu.customer.entity.PwdInfo;
import com.tangmo.xizhu.customer.entity.User;
import com.tangmo.xizhu.customer.entity.search.UserSearch;
import com.tangmo.xizhu.customer.service.UserService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        if(user.getUserType() == null || user.getDeptId() == null || user.getPassword() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        user.setUuid(EncryptUtil.get32Uuid());
        user.setStatus((byte) 0);
        userDao.insertUser(user);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeUser(User user) {
        if(user == null || user.getUuid() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        userDao.updateUser(user);
        return HttpResult.success();
    }

    @Override
    public HttpResult changePwd(PwdInfo pwdInfo) {
        User user = userDao.selectPwdByUserId(pwdInfo.getUserId());
        if(user.getPassword() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        if(user.getPassword().equals(pwdInfo.getPassword())){
            userDao.updatePwd(pwdInfo.getUserId(),pwdInfo.getNewPwd());
        }else{
            return HttpResult.fail(ResultCode.PASSWORD_ERROR);
        }
        //判断
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

    @Override
    public HttpResult getUserList(UserSearch userSearch) {
        Page page = userSearch;
        page.startPage();
        List<User> list = userDao.selectUser(userSearch);
        page.setResult(list);
        return HttpResult.success(page);
    }

    @Override
    public HttpResult getCustomerList(UserSearch userSearch) {
        Page page = userSearch;
        page.startPage();
        List<User> list = userDao.selectCustomer(userSearch);
        page.setResult(list);
        return HttpResult.success(page);
    }
}
