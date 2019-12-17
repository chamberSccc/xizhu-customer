package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author chen bo
 * @Date 2019/11/14
 * @Version V1.0
 * @Description: 任务打卡地址对象
 **/
@Data
public class TaskPunch {
    private String uuid;
    @ApiModelProperty(value="任务id",name="taskId",example="")
    private String taskId;
    @ApiModelProperty(value="打卡地点",name="startAddress",example="")
    private String address;
    @ApiModelProperty(value="开始打卡经度",name="startLongitude",example="")
    private String longitude;
    @ApiModelProperty(value="开始打卡纬度",name="startLatitude",example="")
    private String latitude;
    @ApiModelProperty(value="打卡类型，0开始打卡，1结束打卡",name="punchType",example="")
    private Byte punchType;
    private Byte taskType;//任务类型
    private String userId;
    private Date createdTime;
}
