package com.tangmo.xizhu.customer.entity;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class ServiceRequire {

    private String uuid;
    private Date applyDate;//申请时间
    private String companyName;//用户单位
    private String deviceType;//设备型号
    private String contactName;//联系人
    private String mobile;//联系电话
    private Date serviceDate;//服务时间
    private String taskAssignType;//任务分配类型 安调设备，处理问题
    private String assemblyType;//总成类型 可多选，逗号分隔
    private String troubleType;//问题类型 机器问题或电气问题
    private String detail;//现场细节文字


    //现场细节附件
    private String detailAudioId;
    private String detailSpeechId;
    private List<String> detailPictureList;

}
