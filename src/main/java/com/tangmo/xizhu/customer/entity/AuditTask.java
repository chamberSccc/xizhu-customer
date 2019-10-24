package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author chen bo
 * @Date 2019/10/21
 * @Version V1.0
 * @Description: 审核信息
 **/
@Data
public class AuditTask {
    private String uuid;
    @ApiModelProperty(value="任务id",name="taskId",example="")
    private String taskId;
    @ApiModelProperty(value="指定人员Id",name="assignUser",example="")
    private String assignUser;
    @ApiModelProperty(value="备注",name="comment",example="")
    private String comment;
    private Byte operation;
    @ApiModelProperty(value="任务类型0:快速服务 1:现场服务 2:安调设备",name="taskType",example="")
    private Byte taskType;
    private String createdBy;
    private String createdTime;
}
