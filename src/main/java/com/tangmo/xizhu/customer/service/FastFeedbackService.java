package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.FastFeedBack;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description: 快速服务反馈单service
 **/
public interface FastFeedbackService {

    /**
     * @param fastFeedBack
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 新增快速服务反馈单
     */
    HttpResult addFastFeedback(FastFeedBack fastFeedBack);

    /**
     * @param fastFeedBack
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 修改快速服务反馈单
     */
    HttpResult changeFastFeedback(FastFeedBack fastFeedBack);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 查询任务 快速任务反馈单
     */
    HttpResult getByTaskId(String taskId);
}
