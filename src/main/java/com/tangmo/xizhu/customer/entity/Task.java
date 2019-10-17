package com.tangmo.xizhu.customer.entity;

import lombok.Data;

@Data
public class Task {

    //单位信息
    private String uuid;
    private String companyId;
    private String taskNo;
    private String taskCode;
    private String assemblyType;//总成类型
    private String troubleType;
    private String taskAssignType;//任务分配类型
    private String detail;//细节描述
    private Byte isOutservice;
    private Byte taskStatus;
    private Byte taskType;
    private String createdBy;
    private String executor;
    private String createdTime;

}
