package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.DeviceFile;
import org.springframework.stereotype.Repository;

/**
 * @Author chen bo
 * @Date 2019/10/23
 * @Version V1.0
 * @Description: 设备档案dao
 **/
@Repository
public interface DeviceFileDao {

    /**
     * @param deviceFile
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 新增设备档案
     */
    void insertDeviceFile(DeviceFile deviceFile);

    /**
     * @param deviceFile
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 修改设备档案
     */
    void updateDeviceFile(DeviceFile deviceFile);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 查询任务的设备档案
     */
    DeviceFile selectByTaskId(String taskId);
}
