package com.tangmo.xizhu.customer.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 2019/10/21
 * @description 安全交底表
 */
@Data
public class SafeConfide {
    private String uuid;
    private String taskId;
    private String safe01;//现场起重吊物
    private String safe02;//工作人员高空安调作业
    private String safe03;//工地现场运输摆放物品
    private String safe04;//皮带运转,检修
    private String safe05;//搅拌锅检修作业
    private String safe06;//外部机械维修作业
    private String safe07;//电器维修作业
    private String safe08;//导热油管道监管运行
    private String safe09;//燃烧器操作运行
    private String safe10;//导热油过滤运行
    private String safe11;//沥青系统运行
    private String safe12;//燃烧油使用
    private String safe13;//烟道布袋使用
    private String safe14;//密闭空间检查作业
    private String createdBy;
    private Date createdTime;

}
