package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.DeviceFile;

/**
 * @Author chen bo
 * @Date 2019/10/23
 * @Version V1.0
 * @Description: 设备档案service
 **/
public interface DeviceFileService {

    /**
     * @param deviceFile
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 新增设备档案
     */
    HttpResult addDeviceFile(DeviceFile deviceFile);

    /**
     * @param deviceFile
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 修改设备档案表
     */
    HttpResult changeDeviceFile(DeviceFile deviceFile);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 查询任务的设备档案表
     */
    HttpResult getByTaskId(String taskId);
}
