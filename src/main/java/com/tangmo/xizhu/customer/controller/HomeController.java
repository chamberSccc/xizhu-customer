package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.TaskDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Resource
    private TaskDao taskDao;
    @GetMapping
    public HttpResult test(String a, String b){
        return HttpResult.success(taskDao.selectTest());
    }
}
