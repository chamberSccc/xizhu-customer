package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件调试授权审批单
 **/
@Data
public class OutEquipAudit {
    @ApiModelProperty(value="id",name="uuid",example="")
    private String uuid;
    @ApiModelProperty(value="任务id",name="taskId",example="")
    private String taskId;
    @ApiModelProperty(value="用户单位",name="companyName",example="")
    private String companyName;
    @ApiModelProperty(value="设备型号",name="deviceType",example="")
    private String deviceType;
    @ApiModelProperty(value="外购设备名称",name="equipName",example="")
    private String equipName;
    @ApiModelProperty(value="申请人联系方式",name="mobile",example="")
    private String mobile;
    @ApiModelProperty(value="审批人",name="createdBy",example="")
    private String createdBy;
    @ApiModelProperty(value="审批时间",name="createdTime",example="")
    private Date createdTime;
    @ApiModelProperty(value="领导意见",name="detail",example="")
    private String opinion;
}
