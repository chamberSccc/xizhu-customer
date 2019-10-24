package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.User;

/**
 * @Author chen bo
 * @Date 2019/10/24
 * @Version V1.0
 * @Description: 用户信息service
 **/
public interface UserService {

    /**
     * @param user
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 新增用户
     */
    HttpResult addUser(User user);

    /**
     * @param user
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 修改密码
     */
    HttpResult changePwd(User user);

    /**
     * @param userId
     * @param avatar
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 修改头像
     */
    HttpResult changeAvatar(String userId,String avatar);

    /**
     * @param userId
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 删除用户
     */
    HttpResult delUser(String userId);

    /**
     * @param userId
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 获取用户信息
     */
    HttpResult getUserInfo(String userId);

}
