package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.service.*;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/10/17
 * @Version V1.0
 * @Description: controller基准类
 **/
public class BaseController {
    @Resource
    protected LoginService loginService;
    @Resource
    protected TaskService taskService;
    @Resource
    protected AuditTaskService auditTaskService;
    @Resource
    protected TaskRequireService taskRequireService;
    @Resource
    protected FastFeedbackService fastFeedbackService;
    @Resource
    protected FastSurveyService fastSurveyService;
    @Resource
    protected FieldApplyService fieldApplyService;
    @Resource
    protected FieldAssignService fieldAssignService;
    @Resource
    protected FieldFeedbackService fieldFeedbackService;
    //安全交底表service
    @Resource
    protected SafeConfideService safeConfideService;
    //设备档案表service
    @Resource
    protected DeviceFileService deviceFileService;
    //机械安装工作记录service
    @Resource
    protected MachRecordService machRecordService;
    //电气安装工作记录service
    @Resource
    protected ElecRecordService elecRecordService;

    protected String getUserId(){
        return "1";
    }

    protected Byte getUserType(){
        return 0;
    }
}
