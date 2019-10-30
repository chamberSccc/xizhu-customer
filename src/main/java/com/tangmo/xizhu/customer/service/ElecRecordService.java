package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.ElecRecord;
import com.tangmo.xizhu.customer.entity.MachRecord;

/**
 * @Author chen bo
 * @Date 2019/10/23
 * @Version V1.0
 * @Description: 机械安装工作记录
 **/
public interface ElecRecordService {

    /**
     * @param elecRecord
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 增加安装工作记录
     */
    HttpResult addRecord(ElecRecord elecRecord);

    /**
     * @param elecRecord
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 修改安装工作记录
     */
    HttpResult changeRecord(ElecRecord elecRecord);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 查询任务的电气安装工作记录
     */
    HttpResult getByTaskId(String taskId);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/30
     * @description: 获取已上传记录列表
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
