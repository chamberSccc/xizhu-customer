package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;

/**
 * @Author chen bo
 * @Date 2019/12/9
 * @Version V1.0
 * @Description: 版本service
 **/
public interface VersionService {

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/12/9
     * @description: 获取最新版本号
     */
    HttpResult getLatestVersion();
}
