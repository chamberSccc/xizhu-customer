package com.tangmo.xizhu.customer.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @Author chen bo
 * @Date 2019/12/20
 * @Version V1.0
 * @Description:
 **/
@Data
public class OptRecord {

    private String uuid;
    private String taskId;
    private Byte taskType;
    private String operation;
    private String userId;
    private String userName;
    private Date createdTime;
}
