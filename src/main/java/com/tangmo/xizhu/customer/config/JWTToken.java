package com.tangmo.xizhu.customer.config;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @return
 * @author chen bo
 * @date 2019/10/20
 * @description: JTWtoken 取值操作
 */
public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(String token) {
        if (token != null) {
            this.token = token.split("\\s")[1];
        }
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    public String getToken(){
        return this.token;
    }
}
