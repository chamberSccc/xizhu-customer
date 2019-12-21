package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.OptRecord;
import com.tangmo.xizhu.customer.entity.Task;

/**
 * @Author chen bo
 * @Date 2019/12/20
 * @Version V1.0
 * @Description: 操作记录service
 **/
public interface OptRecordService {

    /**
     * @param optRecord
     * @return
     * @author chen bo
     * @date 2019/12/20
     * @description: 添加操作记录
     */
    HttpResult addOptRecord(OptRecord optRecord);

    /**
     * @param task
     * @param operation
     * @return
     * @author chen bo
     * @date 2019/12/21
     * @description: 添加操作记录
     */
    HttpResult addOptRecord(Task task,String operation);

    /**
     * @param taskId
     * @param userId
     * @param operation
     * @return
     * @author chen bo
     * @date 2019/12/21
     * @description: 添加操作记录
     */
    HttpResult addOptRecord(String taskId,String userId,String operation);


    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/12/20
     * @description: 查找任务的操作记录
     */
    HttpResult getTaskRecord(String taskId);
}
