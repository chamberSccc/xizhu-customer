package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.FieldSurvey;
import org.springframework.stereotype.Repository;

/**
 * @Author chen bo
 * @Date 2019/11/21
 * @Version V1.0
 * @Description: 售后服务满意度调查
 **/
@Repository
public interface FieldSurveyDao {

    /**
     * @param fieldSurvey
     * @return
     * @author chen bo
     * @date 2019/11/21
     * @description: 新增售后服务满意度调查
     */
    Integer insertSurvey(FieldSurvey fieldSurvey);

    /**
     * @param fieldSurvey
     * @return
     * @author chen bo
     * @date 2019/11/21
     * @description: 修改售后服务满意度调查
     */
    Integer updateSurvey(FieldSurvey fieldSurvey);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/11/21
     * @description: 查询任务的售后服务满意度调查
     */
    FieldSurvey selectByTaskId(String taskId);
}
