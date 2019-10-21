package com.tangmo.xizhu.customer.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 2019/10/21
 * @description
 */
@Data
public class EquipUser {
    private String uuid;
    private String deviceFileId;//设备档案表id
    private String memberName;//成员人名
    private String memberType;//成员类型 0:带队工程师,1:组员
    private String content;//工作内容
    private String createdBy;
    private Date createdTime;


}
