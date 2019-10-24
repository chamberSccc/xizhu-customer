package com.tangmo.xizhu.customer.entity;

import lombok.Data;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description: 用户信息
 **/
@Data
public class User {
    private String uuid;
    private String mobile;
    private String userName;
    private String password;
    private Byte userType;// 0 用户 1服务人员 2 审核人员
    private String deptId;
    private String deptName;
    private String avatar;
    private String status; //0 正常  1:删除
    private String createdBy;
    private String createdTime;
}
