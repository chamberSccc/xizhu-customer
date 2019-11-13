package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/22
 * @Version V1.0
 * @Description: 沥青混合料搅拌设备维护保养交底表
 **/
@Data
public class MaintainConfide {
    @ApiModelProperty(value="id",name="uuid",example="")
    private String uuid;
    @ApiModelProperty(value="任务Id",name="taskId",example="")
    private String taskId;
    @ApiModelProperty(value="表格类型 1:冷配交底表 2:烘干加热系统交底表...",name="formType",example="")
    private Byte formType;
    @ApiModelProperty(value="设备名称",name="deviceName",example="")
    private String deviceName;
    @ApiModelProperty(value="设备类型",name="deviceType",example="")
    private String deviceType;
    @ApiModelProperty(value="单位名称",name="companyName",example="")
    private String companyName;
    @ApiModelProperty(value="出厂编号",name="factoryNo",example="")
    private String factoryNo;
    @ApiModelProperty(value="合同编号",name="contractNo",example="")
    private String contractNo;
    @ApiModelProperty(value="施工地点",name="jobSite",example="")
    private String jobSite;
    @ApiModelProperty(value="填写人",name="createdBy",example="")
    private String createdBy;
    @ApiModelProperty(value="交底时间",name="createdTime",example="")
    private Date createdTime;
    @ApiModelProperty(value="用户签字",name="userSign",example="")
    private String userSign;
    @ApiModelProperty(value="服务人员签字",name="serviceSign",example="")
    private String serviceSign;
    @ApiModelProperty(value="图片列表",name="maintain",example="")
    private List<String> pictureList;

    private String updatedBy;
    private Date updatedTime;

}
