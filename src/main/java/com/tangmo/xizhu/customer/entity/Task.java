package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class Task {

    //单位信息
    @ApiModelProperty(value="id",name="uuid",example="")
    private String uuid;
    @ApiModelProperty(value="用户单位",name="companyName",example="")
    private String companyName;//用户单位
    @ApiModelProperty(value="设备型号",name="deviceType",example="")
    private String deviceType;//设备型号
    @ApiModelProperty(value="联系人",name="contactName",example="")
    private String contactName;//联系人
    @ApiModelProperty(value="联系电话",name="mobile",example="")
    private String mobile;//联系电话
    private String taskNo;
    @ApiModelProperty(value="任务分配类型 安调设备，处理问题",name="taskAssignType",example="")
    private String taskAssignType;//任务分配类型 安调设备，处理问题
    @ApiModelProperty(value="总成类型，可多选，逗号分隔",name="assemblyType",example="")
    private String assemblyType;//总成类型 可多选，逗号分隔
    @ApiModelProperty(value="问题类型 机器问题或电气问题",name="troubleType",example="")
    private String troubleType;//问题类型 机器问题或电气问题
    @ApiModelProperty(value="现场细节描述",name="detail",example="")
    private String detail;//细节描述
    private Byte isOutservice;
    @ApiModelProperty(value="任务状态 -1:拒绝 0:审核中 1:审核完成 2:任务完成",name="taskStatus",example="")
    private Byte taskStatus;
    private Byte taskType;//任务类型
    @ApiModelProperty(value="开始打卡地点",name="startAddress",example="")
    private String startAddress;
    @ApiModelProperty(value="开始打卡经度",name="startLongitude",example="")
    private String startLongitude;
    @ApiModelProperty(value="开始打卡纬度",name="startLatitude",example="")
    private String startLatitude;
    @ApiModelProperty(value="开始打卡时间",name="startPunchDate",example="")
    private Date startPunchDate;
    @ApiModelProperty(value="结束打卡地点",name="endAddress",example="")
    private String endAddress;
    @ApiModelProperty(value="结束打卡经度",name="endLongitude",example="")
    private String endLongitude;
    @ApiModelProperty(value="结束打卡纬度",name="endLatitude",example="")
    private String endLatitude;
    @ApiModelProperty(value="结束打卡时间",name="endPunchDate",example="")
    private Date endPunchDate;

    private String createdBy;
    private String executor;
    private Date createdTime;

    //现场细节附件
    @ApiModelProperty(value="细节描述视频文件id，先上传后台返回id",name="detailAudioId",example="")
    private String detailAudioId;
    @ApiModelProperty(value="细节描述音频文件id，先上传后台返回id",name="detailSpeechId",example="")
    private String detailSpeechId;
    @ApiModelProperty(value="细节描述图片文件id列表，先上传后台返回id",name="detailPictureList",example="")
    private List<String> detailPictureList;

}
