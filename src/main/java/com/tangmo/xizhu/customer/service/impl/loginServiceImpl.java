package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.common.TokenBo;
import com.tangmo.xizhu.customer.constant.UserTypeConst;
import com.tangmo.xizhu.customer.dao.DeviceDao;
import com.tangmo.xizhu.customer.dao.UserDao;
import com.tangmo.xizhu.customer.entity.LogInfo;
import com.tangmo.xizhu.customer.entity.User;
import com.tangmo.xizhu.customer.service.LoginService;
import com.tangmo.xizhu.customer.util.JWTUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
    @Resource
    private DeviceDao deviceDao;
    @Override
    public HttpResult userLogin(LogInfo logInfo) {
        User user = userDao.selectPwdByMobile(logInfo.getMobile());
        if(user == null){
            return HttpResult.fail(ResultCode.USER_NOT_EXIST);
        }
        if(!user.getPassword().equals(logInfo.getPassword())){
            return HttpResult.fail(ResultCode.PASSWORD_ERROR);
        }
        TokenBo tokenBo = getTokenBo(user);
        String token = JWTUtil.sign(tokenBo,3000L);
        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        map.put("data",tokenBo);
        return HttpResult.success(map);
    }

    @Override
    public HttpResult adminLogin(LogInfo logInfo) {
        User user = userDao.selectPwdByMobile(logInfo.getMobile());
        if(user == null){
            return HttpResult.fail(ResultCode.USER_NOT_EXIST);
        }
        if(!user.getUserType().equals(UserTypeConst.AUDIT)){
            return HttpResult.fail(ResultCode.USER_NOT_EXIST);
        }
        if(!user.getPassword().equals(logInfo.getPassword())){
            return HttpResult.fail(ResultCode.PASSWORD_ERROR);
        }
        TokenBo tokenBo = getTokenBo(user);
        String token = JWTUtil.sign(tokenBo,3000L);
        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        map.put("data",tokenBo);
        return HttpResult.success(map);
    }

    @Override
    public HttpResult wechatLogin(LogInfo logInfo) {
        User user = userDao.selectUserByDevice(logInfo.getMobile());//这样对比密码有问题，以后改
        if(user == null){
            return HttpResult.fail(ResultCode.PID_ERROR);
        }
        TokenBo tokenBo = getTokenBo(user);
        String token = JWTUtil.sign(tokenBo,3000L);
        return HttpResult.success(token);
    }

    /**
     * @param user
     * @return
     * @author chen bo
     * @date 2019/11/1
     * @description: 获取用户token对象
     */
    private TokenBo getTokenBo(User user){
        TokenBo tokenBo = new TokenBo();
        tokenBo.setUserId(user.getUuid());
        tokenBo.setUserName(user.getUserName());
        tokenBo.setDeptId(user.getDeptId());
        tokenBo.setDeptName(user.getDeptName());
        tokenBo.setUserType(user.getUserType());
        return tokenBo;
    }
}
