package com.tangmo.xizhu.customer.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 2019/10/21
 * @description 设备档案
 */
@Data
public class DeviceFile {
    private String uuid;
    private String fileDate;//建档时间
    private String companyName;//用户单位
    private String deviceType;//产品型号
    private String deviceAddress;//设备使用地
    private String contractNo;//合同编号
    private Date factoryDate;//出厂日期
    private String factoryNo;//出厂编号
    private String checkDate;//验收时间
    private String deviceConfig;//设备配置
    private String comment;//备注
    private String createdBy;//填写人
    private Date createdTime;

}
