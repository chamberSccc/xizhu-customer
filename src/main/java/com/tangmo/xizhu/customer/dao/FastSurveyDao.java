package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.FastSurvey;
import org.springframework.stereotype.Repository;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description: 快速服务满意度调查表dao
 **/
@Repository
public interface FastSurveyDao {

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 查询任务的快速服务满意度调查表
     */
    FastSurvey selectByTaskId(String taskId);

    /**
     * @param fastSurvey
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 新增快速服务满意度调查表
     */
    void insertFastSurvey(FastSurvey fastSurvey);

    /**
     * @param fastSurvey
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 修改快速服务满意度调查表
     */
    void updateFastSurvey(FastSurvey fastSurvey);
}
