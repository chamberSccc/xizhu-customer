package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.FastFeedBack;
import org.springframework.stereotype.Repository;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description: 快速服务反馈单dao
 **/
@Repository
public interface FastFeedbackDao {
    /**
     * @param fastFeedBack
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 新增快速服务反馈单
     */
    void insertFastFeedback(FastFeedBack fastFeedBack);

    /**
     * @param fastFeedBack
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 修改快速服务反馈单
     */
    void updateFastFeedback(FastFeedBack fastFeedBack);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 通过任务id查询快速服务反馈单
     */
    FastFeedBack selectByTaskId(String taskId);
}
