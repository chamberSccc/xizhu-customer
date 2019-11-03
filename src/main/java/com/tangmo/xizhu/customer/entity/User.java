package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description: 用户信息
 **/
@Data
public class User {
    private String uuid;
    @ApiModelProperty(value="手机号",name="mobile",example="")
    private String mobile;
    @ApiModelProperty(value="用户姓名",name="userName",example="")
    private String userName;
    @ApiModelProperty(value="密码",name="password",example="")
    private String password;
    @ApiModelProperty(value="用户类型 0 用户 1服务人员 2 审核人员",name="userType",example="")
    private Byte userType;// 0 用户 1服务人员 2 审核人员
    @ApiModelProperty(value="部门id",name="deptId",example="")
    private String deptId;
    @ApiModelProperty(value="部门名称",name="deptName",example="")
    private String deptName;
    @ApiModelProperty(value="头像",name="avatar",example="")
    private String avatar;
    private Byte status; //0 正常  1:删除
    private String createdBy;
    private Date createdTime;
}
