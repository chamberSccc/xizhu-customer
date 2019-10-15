package com.tangmo.xizhu.customer.entity;

import lombok.Data;

@Data
public class Task {

    //单位信息
    private String taskId;
    private String companyId;
    private String taskNo;
    private String assemblyType;//总成类型
    private String troubleType;
    private String taskAssignType;//任务分配类型
    private String detail;//细节描述
    private Byte isOutService;
    private Byte taskStatus;
    private Byte taskType;
    private String createdBy;
    private String createdTime;
}
