package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 2019/10/21
 * @description 安全交底表
 */
@Data
public class SafeConfide {
    @ApiModelProperty(value="id",name="uuid",example="")
    private String uuid;
    @ApiModelProperty(value="任务id",name="taskId",example="")
    private String taskId;
    @ApiModelProperty(value="现场起重吊物",name="safe01",example="")
    private String safe01;//现场起重吊物
    @ApiModelProperty(value="工作人员高空安调作业",name="safe02",example="")
    private String safe02;//工作人员高空安调作业
    @ApiModelProperty(value="工地现场运输摆放物品",name="safe03",example="")
    private String safe03;//工地现场运输摆放物品
    @ApiModelProperty(value="螺旋体运转，检修",name="safe04",example="")
    private String safe04;//螺旋体运转，检修
    @ApiModelProperty(value="皮带运转,检修",name="safe04",example="")
    private String safe05;//皮带运转,检修
    @ApiModelProperty(value="搅拌锅检修作业",name="safe05",example="")
    private String safe06;//搅拌锅检修作业
    @ApiModelProperty(value="外部机械维修作业",name="safe06",example="")
    private String safe07;//外部机械维修作业
    @ApiModelProperty(value="电器维修作业",name="safe07",example="")
    private String safe08;//电器维修作业
    @ApiModelProperty(value="导热油管道监管运行",name="safe08",example="")
    private String safe09;//导热油管道监管运行
    @ApiModelProperty(value="燃烧器操作运行",name="safe09",example="")
    private String safe10;//燃烧器操作运行
    @ApiModelProperty(value="导热油过滤运行",name="safe10",example="")
    private String safe11;//导热油过滤运行
    @ApiModelProperty(value="沥青系统运行",name="safe11",example="")
    private String safe12;//沥青系统运行
    @ApiModelProperty(value="燃烧油使用",name="safe12",example="")
    private String safe13;//燃烧油使用
    @ApiModelProperty(value="烟道布袋使用",name="safe13",example="")
    private String safe14;//烟道布袋使用
    @ApiModelProperty(value="密闭空间检查作业",name="safe14",example="")
    private String safe15;//密闭空间检查作业
    @ApiModelProperty(value="登录人",name="createdBy",example="")
    private String createdBy;
    @ApiModelProperty(value="登录时间",name="createdTime",example="")
    private Date createdTime;

}
