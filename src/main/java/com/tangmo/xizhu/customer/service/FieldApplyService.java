package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.FieldApply;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description: 现场服务申请单service
 **/
public interface FieldApplyService {

    /**
     * @param fieldApply 新增现场服务申请单
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: TODO
     */
    HttpResult addApply(FieldApply fieldApply);

    /**
     * @param fieldApply
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 修改现场服务申请单
     */
    HttpResult changeApply(FieldApply fieldApply);

    /**
     * @param taskId	任务id
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 查询任务下的现场服务申请单
     */
    HttpResult getByTaskId(String taskId);
}
