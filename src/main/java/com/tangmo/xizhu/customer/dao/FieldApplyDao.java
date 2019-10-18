package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.FieldApply;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description: 现场服务申请单dao
 **/
public interface FieldApplyDao {

    /**
     * @param fieldApply
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 新增现场服务申请单
     */
    void insertFieldApply(FieldApply fieldApply);

    /**
     * @param fieldApply
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 修改现场服务申请单
     */
    void updateFieldApply(FieldApply fieldApply);

    /**
     * @param taskId	任务id
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 查询任务下的现场服务申请单
     */
    FieldApply selectByTaskId(String taskId);
}
