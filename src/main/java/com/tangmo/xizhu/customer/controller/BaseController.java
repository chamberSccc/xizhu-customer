package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.service.TaskService;

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

    protected String getUserId(){
        return "1";
    }

    protected Byte getUserType(){
        return 0;
    }
}
