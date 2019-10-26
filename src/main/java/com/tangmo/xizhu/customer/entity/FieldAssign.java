package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description: 现场服务指派单
 **/
@Data
public class FieldAssign {
    @ApiModelProperty(value="id",name="uuid",example="")
    private String uuid;
    @ApiModelProperty(value="所属任务id",name="taskId",example="")
    private String taskId;
    private String taskNo;
    @ApiModelProperty(value="用戶申请时间",name="applyDate",example="2019-08-03")
    private Date applyDate;//用戶申请时间
    @ApiModelProperty(value="用户单位",name="companyName",example="")
    private String companyName;//用户单位
    @ApiModelProperty(value="设备型号",name="deviceType",example="")
    private String deviceType;//设备型号
    @ApiModelProperty(value="联系人",name="contactName",example="")
    private String contactName;//联系人
    @ApiModelProperty(value="联系电话",name="mobile",example="")
    private String mobile;//联系电话
    @ApiModelProperty(value="领导",name="leader",example="张三")
    private String leader;//领导
    @ApiModelProperty(value="派单时间",name="assignDate",example="2019-08-03")
    private Date assignDate;//派单时间
    @ApiModelProperty(value="任务分配类型 安调设备，处理问题",name="taskAssignType",example="")
    private String taskAssignType;//任务分配类型 安调设备，处理问题
    @ApiModelProperty(value="总成类型，可多选，逗号分隔",name="assemblyType",example="")
    private String assemblyType;//总成类型 可多选，逗号分隔
    @ApiModelProperty(value="问题类型 机器问题或电气问题",name="troubleType",example="")
    private String troubleType;//问题类型 机器问题或电气问题
    @ApiModelProperty(value="现场细节描述",name="detail",example="")
    private String detail;//现场细节文字
    @ApiModelProperty(value="处理方案",name="solution",example="")
    private String solution;//处理方案
    @ApiModelProperty(value="现场服务目的",name="fieldTarget",example="")
    private String fieldTarget;//现场服务目的

    //现场细节附件
    @ApiModelProperty(value="细节描述视频文件id，先上传后台返回id",name="detailAudioId",example="")
    private String detailAudioId;
    @ApiModelProperty(value="细节描述音频文件id，先上传后台返回id",name="detailSpeechId",example="")
    private String detailSpeechId;
    @ApiModelProperty(value="细节描述图片文件id列表，先上传后台返回id",name="detailPictureList",example="")
    private List<String> detailPictureList;

    private String createdBy;
    private String updatedBy;
    private Date createdTime;
    private Date updatedTime;
}
