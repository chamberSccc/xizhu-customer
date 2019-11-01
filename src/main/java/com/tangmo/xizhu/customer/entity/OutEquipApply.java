package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件安装调试申请单
 **/
@Data
public class OutEquipApply {
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
    @ApiModelProperty(value="申请人",name="createdBy",example="")
    private String createdBy;
    @ApiModelProperty(value="申请时间",name="createdTime",example="")
    private Date createdTime;
    @ApiModelProperty(value="现场需求描述",name="detail",example="")
    private String require;
    @ApiModelProperty(value="现场条件描述",name="detail",example="")
    private String detail;
    @ApiModelProperty(value="现场条件描述视频",name="detailAudioId",example="")
    private String detailAudioId;
    @ApiModelProperty(value="现场条件描述音频",name="detailSpeechId",example="")
    private String detailSpeechId;
    @ApiModelProperty(value="现场条件描述图片",name="detailPictureId",example="")
    private List<String> detailPictureList;
}
