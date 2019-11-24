package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.EquipSurvey;

/**
 * @Author chen bo
 * @Date 2019/11/21
 * @Version V1.0
 * @Description: 安调服务满意度调查表service
 **/
public interface EquipSurveyService {

    /**
     * @param equipSurvey
     * @return
     * @author chen bo
     * @date 2019/11/21
     * @description: 新增安调服务满意度调查表
     */
    HttpResult addSurvey(EquipSurvey equipSurvey);

    /**
     * @param equipSurvey
     * @return
     * @author chen bo
     * @date 2019/11/21
     * @description: 修改安调服务满意度调查表
     */
    HttpResult changeSurvey(EquipSurvey equipSurvey);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/11/21
     * @description: 查询任务的安调服务满意度调查表
     */
    HttpResult getByTaskId(String taskId);
}
