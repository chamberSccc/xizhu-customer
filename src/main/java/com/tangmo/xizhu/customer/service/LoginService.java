package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.LogInfo;

/**
 * @Author chen bo
 * @Date 2019/10/15
 * @Version V1.0
 * @Description:
 **/
public interface LoginService {

    /**
     * @param logInfo
     * @return
     * @author chen bo
     * @date 2019/10/15
     * @description: 电脑登录
     */
    HttpResult userLogin(LogInfo logInfo);

    /**
     * @param logInfo
     * @return
     * @author chen bo
     * @date 2019/12/18
     * @description: 管理员登录
     */
    HttpResult adminLogin(LogInfo logInfo);

    /**
     * @param logInfo
     * @return
     * @author chen bo
     * @date 2019/11/1
     * @description: 微信登录
     */
    HttpResult wechatLogin(LogInfo logInfo);
}
