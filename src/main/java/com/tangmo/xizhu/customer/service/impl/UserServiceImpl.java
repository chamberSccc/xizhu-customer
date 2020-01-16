package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.Page;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.constant.TaskStatusConst;
import com.tangmo.xizhu.customer.dao.TaskDao;
import com.tangmo.xizhu.customer.dao.UserDao;
import com.tangmo.xizhu.customer.entity.PwdInfo;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.User;
import com.tangmo.xizhu.customer.entity.search.UserSearch;
import com.tangmo.xizhu.customer.service.UserService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Resource
    private TaskDao taskDao;
    @Override
    public HttpResult addUser(User user) {
        if(user.getUserType() == null || user.getDeptId() == null || user.getPassword() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        user.setUuid(EncryptUtil.get32Uuid());
        user.setStatus((byte) 0);
        user.setPassword(EncryptUtil.md5("123456",false));
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
    public HttpResult getUserTask(String userId) {
        List<Task> list1 = taskDao.selectByStatusAndUser(userId, TaskStatusConst.DEALING);
        List<Task> list2 = taskDao.selectByStatusAndUser(userId, TaskStatusConst.COMPLETE);
        Map<String,Object> map = new HashMap<>();
        map.put("dealing",list1);
        map.put("complete",list2);
        return HttpResult.success(map);
    }

    @Override
    public HttpResult getCustomerList(UserSearch userSearch) {
        Page page = userSearch;
        page.startPage();
        List<User> list = userDao.selectCustomer(userSearch);
        page.setResult(list);
        return HttpResult.success(page);
    }

    @Override
    public HttpResult getAllContact() {
        return HttpResult.success(userDao.selectAllContact());
    }
}
