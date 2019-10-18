package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.TaskRequire;
import org.springframework.stereotype.Repository;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description: 服务任务需求单dao
 **/
@Repository
public interface TaskRequireDao {

    /**
     * @param taskRequire
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 新增服务任务需求单
     */
    void insertTaskRequire(TaskRequire taskRequire);

    /**
     * @param taskRequire
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 修改服务任务需求单
     */
    void updateTaskRequire(TaskRequire taskRequire);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 通过任务id查询服务任务需求单
     */
    TaskRequire selectByTaskId(String taskId);
}
