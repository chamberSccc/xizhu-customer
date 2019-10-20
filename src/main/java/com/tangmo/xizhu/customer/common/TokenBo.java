package com.tangmo.xizhu.customer.common;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.tangmo.xizhu.customer.constant.SessionConst;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author bob
 * @create 2018-07-19
 */
@Data
@NoArgsConstructor
public class TokenBo implements Serializable{

    private static final long serialVersionUID = 1L;

    private String userId;
    private String email;
    private Boolean pc;

    public TokenBo(DecodedJWT jwt) {
        this.email = jwt.getClaim(SessionConst.SESSION_EMAIL).asString();
        this.pc = jwt.getClaim(SessionConst.IS_PC).asBoolean();
        this.userId = jwt.getClaim(SessionConst.SESSION_USER_ID).asString();
    }
}
