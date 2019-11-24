package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.EquipSurvey;
import com.tangmo.xizhu.customer.entity.FieldSurvey;
import org.springframework.stereotype.Repository;

/**
 * @Author chen bo
 * @Date 2019/11/21
 * @Version V1.0
 * @Description: 安调服务满意度调查dao
 **/
@Repository
public interface EquipSurveyDao {

    /**
     * @param equipSurvey
     * @return
     * @author chen bo
     * @date 2019/11/21
     * @description: 新增安调服务满意度调查
     */
    Integer insertSurvey(EquipSurvey equipSurvey);

    /**
     * @param equipSurvey
     * @return
     * @author chen bo
     * @date 2019/11/21
     * @description: 修改安调服务满意度调查
     */
    Integer updateSurvey(EquipSurvey equipSurvey);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/11/21
     * @description: 查询任务的安调服务满意度调查
     */
    EquipSurvey selectByTaskId(String taskId);
}
