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
    private String createdBy;
    private String createdTime;
}
