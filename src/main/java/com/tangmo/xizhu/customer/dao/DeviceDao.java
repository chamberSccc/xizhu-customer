package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.DeviceInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/11/1
 * @Version V1.0
 * @Description:
 **/
@Repository
public interface DeviceDao {
    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/1
     * @description: TODO
     */
    List<DeviceInfo> selectByUserId();
}
