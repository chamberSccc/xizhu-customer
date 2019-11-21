package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.FieldSurvey;

/**
 * @Author chen bo
 * @Date 2019/11/21
 * @Version V1.0
 * @Description: 售后服务满意度调查表service
 **/
public interface FieldSurveyService {

    /**
     * @param fieldSurvey
     * @return
     * @author chen bo
     * @date 2019/11/21
     * @description: 新增售后服务满意度调查表
     */
    HttpResult addSurvey(FieldSurvey fieldSurvey);

    /**
     * @param fieldSurvey
     * @return
     * @author chen bo
     * @date 2019/11/21
     * @description: 修改售后服务满意度调查表
     */
    HttpResult changeSurvey(FieldSurvey fieldSurvey);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/11/21
     * @description: 查询任务的售后服务满意度调查表
     */
    HttpResult getByTaskId(String taskId);
}
