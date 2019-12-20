package com.tangmo.xizhu.customer.entity;

import lombok.Data;

/**
 * @author boge
 * @date 2019/12/20
 * @description 表单状态(是否已填写)
 */
@Data
public class FormState {
    private String uuid;
    private String taskId;
    private Boolean form01;//服务任务需求单
    private Boolean form02;//快速服务反馈单
    private Boolean form03;//快速服务满意度调查表
    private Boolean form04;//现场服务申请单
    private Boolean form05;//现场服务指派单
    private Boolean form06;//现场服务反馈单
    private Boolean form07;//售后服务满意度调查表
    private Boolean form08;//安全交底表
    private Boolean form09;//设备档案表
    private Boolean form10;//安装工作记录表(机械)
    private Boolean form11;//安装工作记录表(电气)
    private Boolean form12;//外购件安装调试申请单
    private Boolean form13;//外购件授权审批单
    private Boolean form14;//外购件现场服务验收单
    private Boolean form15;//安调满意度调查表
}
