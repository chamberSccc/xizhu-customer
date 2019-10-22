package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * @author boge
 * @date 2019/10/21
 * @description 设备档案
 */
@Data
public class DeviceFile {
    @ApiModelProperty(value="id",name="uuid",example="")
    private String uuid;
    @ApiModelProperty(value="任务id",name="taskId",example="")
    private String taskId;
    @ApiModelProperty(value="建档时间",name="fileDate",example="")
    private String fileDate;//建档时间
    @ApiModelProperty(value="用户单位",name="companyName",example="")
    private String companyName;//用户单位
    @ApiModelProperty(value="产品型号",name="deviceType",example="")
    private String deviceType;//产品型号
    @ApiModelProperty(value="设备使用地",name="deviceAddress",example="")
    private String deviceAddress;//设备使用地
    @ApiModelProperty(value="合同编号",name="contractNo",example="")
    private String contractNo;//合同编号
    @ApiModelProperty(value="出厂日期",name="factoryDate",example="")
    private Date factoryDate;//出厂日期
    @ApiModelProperty(value="出厂编号",name="factoryNo",example="")
    private String factoryNo;//出厂编号
    @ApiModelProperty(value="验收时间",name="checkDate",example="")
    private String checkDate;//验收时间
    @ApiModelProperty(value="设备配置",name="deviceConfig",example="")
    private String deviceConfig;//设备配置
    @ApiModelProperty(value="备注",name="comment",example="")
    private String comment;//备注
    @ApiModelProperty(value="填写人",name="createdBy",example="")
    private String createdBy;//填写人
    @ApiModelProperty(value="填写时间",name="createdTime",example="")
    private Date createdTime;
    @ApiModelProperty(value="安调人员列表",name="userList",example="")
    private List<EquipUser> userList;//安调人员列表

}
