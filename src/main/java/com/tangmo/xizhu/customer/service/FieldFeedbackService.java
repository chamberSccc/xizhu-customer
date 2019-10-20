package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.FieldFeedBack;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description: 现场服务反馈单service
 **/
public interface FieldFeedbackService {

    /**
     * @param feedBack
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 增加现场服务反馈单
     */
    HttpResult addFeedback(FieldFeedBack feedBack);

    /**
     * @param fieldFeedBack
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 修改现场服务反馈单
     */
    HttpResult changeFeedback(FieldFeedBack fieldFeedBack);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 查询任务下的现场服务反馈单
     */
    HttpResult getByTaskId(String taskId);
}
