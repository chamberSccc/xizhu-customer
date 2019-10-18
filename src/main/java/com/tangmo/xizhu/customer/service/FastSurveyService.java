package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.FastSurvey;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description:
 **/
public interface FastSurveyService {

    /**
     * @param fastSurvey
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 增加快速服务满意度调查表
     */
    HttpResult addSurvey(FastSurvey fastSurvey);

    /**
     * @param fastSurvey
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 修改快速服务满意度调查表
     */
    HttpResult changeSurvey(FastSurvey fastSurvey);

    /**
     * @param taskId    任务id
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 查询任务的快速服务满意度调查表
     */
    HttpResult getByTaskId(String taskId);
}
