package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.FormState;
import org.apache.ibatis.annotations.Param;

/**
 * @author boge
 * @date 2019/12/20
 * @description 表单状态dao
 */

public interface FormStateDao {

    /**
     * 增加表单状态
     *
     * @param formState
     */
    void insertFormState(FormState formState);

    /**
     * 修改表单状态
     *
     * @param taskId
     * @param column
     */
    void updateFormState(@Param("taskId") String taskId, @Param("column") String column);

    /**
     * 查询任务表单状态
     * @param taskId
     * @return
     */
    FormState selectByTaskId(String taskId);
}
