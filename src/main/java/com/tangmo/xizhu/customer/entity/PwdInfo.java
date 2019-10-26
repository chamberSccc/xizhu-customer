package com.tangmo.xizhu.customer.entity;

import lombok.Data;

/**
 * @Author chen bo
 * @Date 2019/10/26
 * @Version V1.0
 * @Description: 修改密码对象
 **/
@Data
public class PwdInfo {
    private String userId;
    private String password;
    private String newPwd;
}
