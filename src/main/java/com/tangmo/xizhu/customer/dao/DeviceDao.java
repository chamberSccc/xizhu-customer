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
     * @param uuid
     * @return
     * @author chen bo
     * @date 2019/11/5
     * @description: 通过id查询信息
     */
    DeviceInfo selectById(String uuid);

    /**
     * @param deviceInfo
     * @return
     * @author chen bo
     * @date 2019/11/2
     * @description: 添加设备信息
     */
    Integer insertDevice(DeviceInfo deviceInfo);

    /**
     * @param deviceInfo
     * @return
     * @author chen bo
     * @date 2019/11/5
     * @description: 修改设备信息
     */
    Integer updateDevice(DeviceInfo deviceInfo);
}
