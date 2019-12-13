package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.AppVersion;
import org.springframework.stereotype.Repository;

/**
 * @Author chen bo
 * @Date 2019/12/9
 * @Version V1.0
 * @Description:
 **/
@Repository
public interface VersionDao {

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/12/9
     * @description: 获取最新版本号
     */
    AppVersion selectLatestVersion();
}
