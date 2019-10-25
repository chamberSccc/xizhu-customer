package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.LogInfo;
import com.tangmo.xizhu.customer.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/15
 * @Version V1.0
 * @Description: 用户信息dao
 **/
@Repository
public interface UserDao {

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 增加用户
     */
    void insertUser();

    /**
     * @param userId
     * @param newPwd
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 修改密码
     */
    void updatePwd(@Param("userId") String userId, @Param("newPwd") String newPwd);

    /**
     * @param logInfo
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 通过账号密码查询用户信息
     */
    User selectByLogInfo(LogInfo logInfo);

    /**
     * @param mobile
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 通过手机号查询用户信息
     */
    User selectByMobile(String mobile);

    /**
     * @param userId
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 通过用户id查询用户信息
     */
    User selectByUserId(String userId);

    /**
     * @param userId
     * @param avatar
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 修改头像
     */
    void updateAvatar(@Param("userId") String userId, @Param("avatar") String avatar);

    /**
     * @param deptId
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 通过部门id查询人员
     */
    List<User> selectByDeptId(String deptId);

}
