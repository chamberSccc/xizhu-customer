package com.tangmo.xizhu.customer.entity;

import lombok.Data;

import java.sql.Date;


/**
 * @Author chen bo
 * @Date 2019/11/1
 * @Version V1.0
 * @Description: 设备信息
 **/
@Data
public class DeviceInfo {
    private String uuid;
    private String deviceName;
    private String deviceType;
    private String companyName;
    private String contractNo;
    private String mobile;
    private String userId;
    private String devicePid; //设备出厂唯一标识码
    private String factoryNo;//出厂编号
    private Date factoryDate;//出厂日期

    public String getFactoryNo() {
        if(factoryNo == null){
            return "";
        }
        return factoryNo;
    }
}
