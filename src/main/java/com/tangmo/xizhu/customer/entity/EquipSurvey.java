package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

/**
 * @Author chen bo
 * @Date 2019/11/21
 * @Version V1.0
 * @Description: 安调满意度调查表
 **/
@Data
public class EquipSurvey {

    private String uuid;
    @ApiModelProperty(value="任务id",name="taskId",example="")
    private String taskId;
    @ApiModelProperty(value="单位名称",name="companyName",example="")
    private String companyName;
    @ApiModelProperty(value="合同编号",name="contractNo",example="")
    private String contractNo;
    @ApiModelProperty(value="调查访问人",name="contactName",example="")
    private String contactName;
    @ApiModelProperty(value="联系电话",name="mobile",example="")
    private String mobile;
    @ApiModelProperty(value="服务人员",name="serviceUser",example="")
    private String serviceUser;
    @ApiModelProperty(value="设备名称",name="deviceName",example="")
    private String deviceName;
    @ApiModelProperty(value="安装时间",name="checkDate",example="")
    private Date installDate;
    @ApiModelProperty(value="调试时间",name="checkDate",example="")
    private Date equipDate;
    @ApiModelProperty(value="验收时间",name="checkDate",example="")
    private Date checkDate;
    @ApiModelProperty(value="发运日期",name="startDate",example="")
    private Date startDate;


    @ApiModelProperty(value="评估第一项",name="evaluate01",example="")
    private String evaluate01;
    @ApiModelProperty(value="评估第二项",name="evaluate02",example="")
    private String evaluate02;
    @ApiModelProperty(value="评估第三项",name="evaluate03",example="")
    private String evaluate03;
    @ApiModelProperty(value="评估第四项",name="evaluate04",example="")
    private String evaluate04;
    @ApiModelProperty(value="评估第五项",name="evaluate05",example="")
    private String evaluate05;
    @ApiModelProperty(value="评估第六项",name="evaluate06",example="")
    private String evaluate06;
    @ApiModelProperty(value="评估第七项",name="evaluate07",example="")
    private String evaluate07;
    @ApiModelProperty(value="评估第八项",name="evaluate08",example="")
    private String evaluate08;
    @ApiModelProperty(value="评估第九项",name="evaluate08",example="")
    private String evaluate09;
    @ApiModelProperty(value="评估第十项",name="evaluate08",example="")
    private String evaluate10;
    @ApiModelProperty(value="评估第十一项",name="evaluate08",example="")
    private String evaluate11;


    @ApiModelProperty(value="项目第一项",name="evaluate01",example="")
    private String project01;
    @ApiModelProperty(value="项目第二项",name="evaluate02",example="")
    private String project02;
    @ApiModelProperty(value="项目第三项",name="evaluate03",example="")
    private String project03;
    @ApiModelProperty(value="项目第四项",name="evaluate04",example="")
    private String project04;
    @ApiModelProperty(value="项目第五项",name="evaluate05",example="")
    private String project05;
    @ApiModelProperty(value="项目第六项",name="evaluate06",example="")
    private String project06;
    @ApiModelProperty(value="项目第七项",name="evaluate07",example="")
    private String project07;
    @ApiModelProperty(value="项目第八项",name="evaluate08",example="")
    private String project08;
    @ApiModelProperty(value="项目第九项",name="evaluate08",example="")
    private String project09;
    @ApiModelProperty(value="项目第十项",name="evaluate08",example="")
    private String project10;
    @ApiModelProperty(value="项目第十一项",name="evaluate08",example="")
    private String project11;

    @ApiModelProperty(value="不合理要求",name="unreasonable",example="")
    private String unreasonable;
    @ApiModelProperty(value="备注",name="remark",example="")
    private String remark;
    @ApiModelProperty(value="意见和建议",name="advice",example="")
    private String advice;
    @ApiModelProperty(value="遗留问题",name="advice",example="")
    private String problem;
    @ApiModelProperty(value="满意度",name="satisfaction",example="")
    private String satisfaction;
    @ApiModelProperty(value="负责人",name="leader",example="")
    private String leader;

    @ApiModelProperty(value="填表人",name="createdBy",example="")
    private String createdBy;
    @ApiModelProperty(value="调查日期",name="createdTime",example="")
    private Date createdTime;

}
