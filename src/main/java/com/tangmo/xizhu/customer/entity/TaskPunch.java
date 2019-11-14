package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author chen bo
 * @Date 2019/11/14
 * @Version V1.0
 * @Description:
 **/
@Data
public class TaskPunch {
    @ApiModelProperty(value="任务id",name="taskId",example="")
    private String taskId;
    @ApiModelProperty(value="开始打卡地点",name="startAddress",example="")
    private String startAddress;
    @ApiModelProperty(value="开始打卡经度",name="startLongitude",example="")
    private String startLongitude;
    @ApiModelProperty(value="开始打卡纬度",name="startLatitude",example="")
    private String startLatitude;
    @ApiModelProperty(value="结束打卡地点",name="endAddress",example="")
    private String endAddress;
    @ApiModelProperty(value="结束打卡经度",name="endLongitude",example="")
    private String endLongitude;
    @ApiModelProperty(value="结束打卡纬度",name="endLatitude",example="")
    private String endLatitude;
}
