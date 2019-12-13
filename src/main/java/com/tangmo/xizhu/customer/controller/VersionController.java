package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.service.VersionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/12/9
 * @Version V1.0
 * @Description: 版本控制器
 **/
@RestController
@RequestMapping("/version")
public class VersionController {
    @Resource
    private VersionService versionService;
    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/12/9
     * @description: 获取最新版本号
     */
    @GetMapping("/latest")
    public HttpResult getVersion(){
        return versionService.getLatestVersion();
    }
}
