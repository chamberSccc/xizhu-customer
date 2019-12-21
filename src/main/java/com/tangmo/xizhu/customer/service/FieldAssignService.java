package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.FieldAssign;
import com.tangmo.xizhu.customer.entity.Task;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description: 现场服务指派单service
 **/
public interface FieldAssignService {

    /**
     * @param fieldAssign
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 新增现场服务指派单
     */
    HttpResult addFieldAssign(FieldAssign fieldAssign);

    /**
     * @param task
     * @return
     * @author chen bo
     * @date 2019/12/21
     * @description: 新增现场服务指派单
     */
    HttpResult addFieldAssign(Task task);

    /**
     * @param fieldAssign
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 修改现场服务指派单
     */
    HttpResult changeFieldAssign(FieldAssign fieldAssign);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 查询任务的 现场服务指派单
     */
    HttpResult getByTaskId(String taskId);
}
