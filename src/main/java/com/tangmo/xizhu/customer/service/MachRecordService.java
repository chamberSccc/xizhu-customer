package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.MachRecord;

/**
 * @Author chen bo
 * @Date 2019/10/23
 * @Version V1.0
 * @Description: 机械安装工作记录
 **/
public interface MachRecordService {

    /**
     * @param machRecord
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 增加机械安装工作记录
     */
    HttpResult addRecord(MachRecord machRecord);

    /**
     * @param machRecord
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 修改机械安装工作记录
     */
    HttpResult changeRecord(MachRecord machRecord);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 查询任务的机械安装工作记录
     */
    HttpResult getByTaskId(String taskId);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/30
     * @description: 获取已上传记录时间列表
     */
    HttpResult getDailyDate(String taskId);

    /**
     * @param dailyId
     * @return
     * @author chen bo
     * @date 2019/10/30
     * @description: 根据dailyId获取安装工作记录
     */
    HttpResult getByDailyId(String dailyId);
}
