package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.LogInfo;
import com.tangmo.xizhu.customer.entity.User;
import com.tangmo.xizhu.customer.entity.search.UserSearch;
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
    void insertUser(User user);

    /**
     * @param user
     * @return
     * @author chen bo
     * @date 2019/11/2
     * @description: 修改用户信息
     */
    Integer updateUser(User user);

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
     * @param mobile
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 通过手机号查询用户密码信息
     */
    User selectPwdByMobile(String mobile);

    /**
     * @param userId
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 删除用户信息
     */
    Integer deleteById(String userId);

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
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 查询带有密码的用户信息
     */
    User selectPwdByUserId(String userId);

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

    /**
     * @param userSearch 用户查询对象
     * @return
     * @author chen bo
     * @date 2019/11/2
     * @description: 查询公司用户
     */
    List<User> selectUser(UserSearch userSearch);

    /**
     * @param userSearch 用户查询对象
     * @return
     * @author chen bo
     * @date 2019/11/2
     * @description: 查询客户
     */
    List<User> selectCustomer(UserSearch userSearch);

}
