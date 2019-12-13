package com.tangmo.xizhu.customer.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author chen bo
 * @Date 2019/12/9
 * @Version V1.0
 * @Description: app版本对象
 **/
@Data
public class AppVersion {
    private String version;
    private String note;
    private Date createdTime;
    private String url;
}
