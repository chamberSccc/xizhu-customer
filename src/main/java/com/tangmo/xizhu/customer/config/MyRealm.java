package com.tangmo.xizhu.customer.config;

import com.tangmo.xizhu.customer.util.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


/**
 * @author Sensor
 * @date 2017/12/20
 */
public class MyRealm extends AuthorizingRealm {

    private String secret = "XIZHU-SERVICE";

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 登录信息和用户验证信息验证(non-Javadoc)
     * 从redis获取tokenBO信息为null,则需要重新登录，之前的token无效；
     * 从redis获取tokenBO信息不为null,则验证token的有效性
     * 验证
     *
     * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(AuthenticationToken)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        String token = (String) authToken.getCredentials();

        // 解密获得username，用于和数据库进行对比
        if (!JWTUtil.verify(token, secret)) {
            throw new AuthenticationException("token invalid");
        }

//        String oldToken = redisUtils.get(JWTUtil.getTokenBO(token).getEmail() + StringConst.UNDERLINE + SessionConst.TOKEN).toString();
        String oldToken = "";
//        if ( !oldToken.equals(token) ) {
//            throw new AuthenticationException("token replace");
//        }

        return new SimpleAuthenticationInfo(token, token, getName());
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
     *
     * @see AuthorizingRealm#doGetAuthorizationInfo(PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //查询当前用户拥有的所有menu url
        //TODO 实现权限赋值
        return info;
    }
}

