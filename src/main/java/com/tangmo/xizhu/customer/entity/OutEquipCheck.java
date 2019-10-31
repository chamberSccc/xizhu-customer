package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件安装调试现场服务验收单
 **/
@Data
public class OutEquipCheck {
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
    private String applyUser;
    @ApiModelProperty(value="现场调试结果",name="detail",example="")
    private String detail;
    @ApiModelProperty(value="现场条件描述视频",name="detailAudioId",example="")
    private String detailAudioId;
    @ApiModelProperty(value="现场条件描述图片",name="detailPictureId",example="")
    private List<String> detailPictureId;
    @ApiModelProperty(value="用户意见",name="userOpinion",example="")
    private String userOpinion;
    @ApiModelProperty(value="用户签字",name="userSign",example="")
    private String userSign;
    @ApiModelProperty(value="安调负责任签字",name="equipSign",example="")
    private String equipSign;
    @ApiModelProperty(value="现场负责任签字",name="leaderSign",example="")
    private String leaderSign;

    private String createdBy;
    @ApiModelProperty(value="验收时间",name="createdTime",example="")
    private Date createdTime;
}
