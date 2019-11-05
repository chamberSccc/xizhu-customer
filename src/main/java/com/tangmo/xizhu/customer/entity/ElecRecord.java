package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/22
 * @Version V1.0
 * @Description: 安装工作记录，电气
 **/
@Data
public class ElecRecord {
    @ApiModelProperty(value="id",name="uuid",example="")
    private String uuid;
    @ApiModelProperty(value="任务id",name="taskId",example="")
    private String taskId;
    @ApiModelProperty(value="设备名称",name="deviceName",example="")
    private String deviceName;//设备名称
    @ApiModelProperty(value="设备型号",name="deviceType",example="")
    private String deviceType;//设备型号
    @ApiModelProperty(value="带队工程师",name="createdBy",example="")
    private String createdBy;//带队工程师
    @ApiModelProperty(value="id",name="uuid",example="")
    private Date createdTime;//填写时间

    @ApiModelProperty(value="工作记录",name="workInfo",example="")
    private String workInfo;
    @ApiModelProperty(value="工作记录图片",name="workPicture",example="")
    private String workPicture;
    @ApiModelProperty(value="工作记录视频",name="workAudio",example="")
    private String workAudio;
    @ApiModelProperty(value="安全记录",name="safeInfo",example="")
    private String safeInfo;
    @ApiModelProperty(value="安全记录视频",name="safeAudio",example="")
    private String safeAudio;
    @ApiModelProperty(value="安全记录照片",name="safePicture",example="")
    private String safePicture;
}
