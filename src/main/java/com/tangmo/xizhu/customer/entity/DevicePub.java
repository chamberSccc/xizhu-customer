package com.tangmo.xizhu.customer.entity;

import lombok.Data;

/**
 * @author boge
 * @date 2019/10/25
 * @description //设备信息公共类,用于表格之间信息交换
 */

@Data
public class DevicePub {

    private String deviceName;
    private String deviceType;
}
