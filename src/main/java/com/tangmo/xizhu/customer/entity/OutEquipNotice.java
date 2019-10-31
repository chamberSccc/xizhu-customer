package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件现场安装调试通知单
 **/
@Data
public class OutEquipNotice {
    @ApiModelProperty(value="id",name="uuid",example="")
    private String uuid;
    @ApiModelProperty(value="任务id",name="taskId",example="")
    private String taskId;
    @ApiModelProperty(value="用户单位",name="companyName",example="")
    private String companyName;
    @ApiModelProperty(value="设备型号",name="deviceType",example="")
    private String deviceType;
    @ApiModelProperty(value="厂家联系人",name="factoryUser",example="")
    private String factoryUser;
    @ApiModelProperty(value="厂家联系方式",name="mobile",example="")
    private String mobile;
    private Date createdTime;
    @ApiModelProperty(value="通知",name="detail",example="")
    private String notice;
}
