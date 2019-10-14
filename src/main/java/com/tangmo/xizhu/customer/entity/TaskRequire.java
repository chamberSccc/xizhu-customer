package com.tangmo.xizhu.customer.entity;

import lombok.Data;

import java.util.List;

@Data
public class TaskRequire {

    //单位信息
    private Integer taskRequireId;
    private Integer companyId;

    private Byte taskType;
    private Byte problemType;
    private Byte deviceProblem;

    private String detail;

    //是否三包期内
    private Byte outService;
    //音频，视频和照片
    private String audioId;
    private String videoId;
    private List<String> attachList;

}
