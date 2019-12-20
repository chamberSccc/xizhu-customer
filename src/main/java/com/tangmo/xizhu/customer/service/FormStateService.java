package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.FormState;

/**
 * @author boge
 * @date 2019/12/20
 * @description 表单状态service
 */

public interface FormStateService {

    /**
     * 增加表单状态
     * @param taskId
     * @return
     */
    HttpResult addFormState(String taskId);

    /**
     * 修改表单状态
     * @param taskId
     * @param column
     * @return
     */
    HttpResult changeFormState(String taskId,String column);

    /**
     * 查询任务的表单状态
     * @param taskId
     * @return
     */
    HttpResult getTaskState(String taskId);
}
