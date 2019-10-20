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
    protected TaskService taskService;
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

    protected String getUserId(){
        return "1";
    }

    protected Byte getUserType(){
        return 0;
    }
}
