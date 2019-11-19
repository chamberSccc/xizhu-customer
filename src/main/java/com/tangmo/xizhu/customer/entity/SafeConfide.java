package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.util.List;

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
    @ApiModelProperty(value="图片列表",name="pictureList",example="")
    private List<String> pictureList;
    @ApiModelProperty(value="用户签字",name="userSign",example="")
    private String userSign;
    @ApiModelProperty(value="服务人员签字",name="serviceSign",example="")
    private String serviceSign;
    @ApiModelProperty(value="登录人",name="createdBy",example="")
    private String createdBy;
    @ApiModelProperty(value="登录时间",name="createdTime",example="")
    private Date createdTime;

}
