package com.tangmo.xizhu.customer.entity;

import lombok.Data;

/**
 * @author boge
 * @date 2019/10/21
 * @description 安装工作记录(机械)
 */
@Data
public class MachineRecord {
    private String uuid;
    private String deviceName;//设备名称
    private String deviceType;//设备型号
    private String createdBy;//带队工程师
    private String createdTime;//填写时间
}
