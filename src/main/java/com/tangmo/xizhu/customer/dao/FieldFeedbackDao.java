package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.FieldFeedBack;
import org.springframework.stereotype.Repository;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description: 现场服务反馈单dao
 **/
@Repository
public interface FieldFeedbackDao {

    /**
     * @param fieldFeedBack
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 新增现场服务反馈单
     */
    void insertFeedback(FieldFeedBack fieldFeedBack);

    /**
     * @param fieldFeedBack
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 修改现场服务反馈单
     */
    void updateFeedback(FieldFeedBack fieldFeedBack);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 通过任务id查询现场服务反馈单
     */
    FieldFeedBack selectByTaskId(String taskId);
}
