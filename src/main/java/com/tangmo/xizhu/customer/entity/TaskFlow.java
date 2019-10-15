package com.tangmo.xizhu.customer.entity;

import lombok.Data;

/**
 * @Author chen bo
 * @Date 2019/10/15
 * @Version V1.0
 * @Description: 任务审核流程记录
 **/
@Data
public class TaskFlow {

    private String flowId;
    private String taskId;
    private String createdBy;
    private String createdTime;
    private Byte operation;
    private String remark;
}
