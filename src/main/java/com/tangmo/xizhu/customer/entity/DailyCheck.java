package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author chen bo
 * @Date 2020/1/15
 * @Version V1.0
 * @Description: 日常签到
 **/
@Data
public class DailyCheck {
    private String uuid;
    @ApiModelProperty(value="开始时间",name="startLongitude",example="")
    private Date startDate;
    @ApiModelProperty(value="结束时间",name="startLongitude",example="")
    private Date endDate;
    @ApiModelProperty(value="时长",name="startLongitude",example="")
    private String duration;
    private Byte checkType;
    @ApiModelProperty(value="选项",name="startLongitude",example="")
    private String checkOption;
    @ApiModelProperty(value="打卡经度",name="startLongitude",example="")
    private String longitude;
    @ApiModelProperty(value="打卡纬度",name="startLatitude",example="")
    private String latitude;
    @ApiModelProperty(value="地址",name="startLongitude",example="")
    private String address;
    @ApiModelProperty(value="事由",name="startLongitude",example="")
    private String remark;
    private String userId;
    private String createdTime;
}
