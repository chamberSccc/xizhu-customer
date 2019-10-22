package com.tangmo.xizhu.customer.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tangmo.xizhu.customer.common.TokenBo;
import com.tangmo.xizhu.customer.constant.SessionConst;


import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author Sensor
 */
public class JWTUtil {
    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer("xizhu").build();
            verifier.verify(token);
            return true;
        } catch (TokenExpiredException e) {
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息,若解密不正确则返回null
     *
     * @return token中包含的用户名
     */
    public static TokenBo getTokenBO(String token) {
        try {
            DecodedJWT jwt = com.auth0.jwt.JWT.decode(token);
            TokenBo tokenBo = new TokenBo();
            tokenBo.setUserId(jwt.getClaim(SessionConst.SESSION_USER_ID).asString());
            tokenBo.setUserName(jwt.getClaim(SessionConst.SESSION_USER_NAME).asString());
            tokenBo.setUserType(Byte.valueOf(jwt.getClaim(SessionConst.SESSION_USER_TYPE).asString()));
            tokenBo.setDeptId(jwt.getClaim(SessionConst.SESSION_DEPT_ID).asString());
            tokenBo.setDeptName(jwt.getClaim(SessionConst.SESSION_USER_ID).asString());
            return tokenBo;
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名
     *
     * @param tokenBo 数据集
     * @return 加密的token
     */
    public static String sign(TokenBo tokenBo, Long second) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        try {
            Algorithm algorithm = Algorithm.HMAC256(EncryptUtil.MD5KEY);
            // 附带username信息
            JWTCreator.Builder builder = JWT.create();
            builder.withIssuer("xizhu");
            builder.withIssuedAt(now);
            if (second >= 0) {
                long expMillis = nowMillis + second * 1000;
                Date exp = new Date(expMillis);
                builder.withExpiresAt(exp);
            }
            builder.withClaim(SessionConst.SESSION_USER_NAME, tokenBo.getUserName());
            builder.withClaim(SessionConst.SESSION_USER_ID, tokenBo.getUserId());
            builder.withClaim(SessionConst.SESSION_USER_TYPE, tokenBo.getUserType().toString());
            builder.withClaim(SessionConst.SESSION_DEPT_ID, tokenBo.getDeptId());
            builder.withClaim(SessionConst.SESSION_DEPT_NAME, tokenBo.getDeptName());
            return builder.sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
