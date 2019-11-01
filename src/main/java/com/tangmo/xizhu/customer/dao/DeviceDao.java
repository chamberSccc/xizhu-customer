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
     * @description: 根据用户Id查询设备信息
     */
    List<DeviceInfo> selectByUserId(String deviceId);

    /**
     * @param deviceInfo
     * @return
     * @author chen bo
     * @date 2019/11/2
     * @description: 添加设备信息
     */
    Integer insertDevice(DeviceInfo deviceInfo);
}
