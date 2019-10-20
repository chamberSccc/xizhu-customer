package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author chen bo
 * @Date 2019/10/15
 * @Version V1.0
 * @Description: d用户登录对象
 **/
@Data
public class LogInfo {
    @ApiModelProperty(value="用户名",name="account",example="123456789")
    private String account;
    @ApiModelProperty(value="密码",name="password",example="123456789")
    private String password;
}
