package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.User;
import com.tangmo.xizhu.customer.entity.search.UserSearch;

/**
 * @Author chen bo
 * @Date 2019/11/5
 * @Version V1.0
 * @Description: 客户信息服务类
 **/
public interface CustomerService {

    /**
     * @param user
     * @return
     * @author chen bo
     * @date 2019/11/5
     * @description: 增加客户信息
     */
    HttpResult addCustomer(User user);

    /**
     * @param user
     * @return
     * @author chen bo
     * @date 2019/11/5
     * @description: 修改客户信息
     */
    HttpResult changeCustomer(User user);

    /**
     * @param userId
     * @return
     * @author chen bo
     * @date 2019/11/5
     * @description: 获取客户设备列表
     */
    HttpResult getUserDevice(String userId);

    /**
     * @param userSearch
     * @return
     * @author chen bo
     * @date 2019/11/5
     * @description: 获取客户列表
     */
    HttpResult getCustomerList(UserSearch userSearch);
}
