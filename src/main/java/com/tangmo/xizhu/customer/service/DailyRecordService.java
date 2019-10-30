package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.DailyRecord;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/30
 * @Version V1.0
 * @Description: 每日工作记录service
 **/
public interface DailyRecordService {

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

    /**
     * @param list 批量修改工作记录列表
     * @return
     * @author chen bo
     * @date 2019/10/30
     * @description: 修改每日工作记录
     */
    HttpResult changeBatchDaily(List<DailyRecord> list);

}
