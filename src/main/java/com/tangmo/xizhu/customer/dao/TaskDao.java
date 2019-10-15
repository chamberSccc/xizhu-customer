package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/13
 * @Version V1.0
 * @Description: 任务dao
 **/
@Repository
public interface TaskDao {

    /**
     * @param task
     * @return void
     * @author chen bo
     * @date 2019/10/15
     * @description: 新增任务
     */
    void insertTask(Task task);

    /**
     * @param task
     * @return void
     * @author chen bo
     * @date 2019/10/15
     * @description: TODO
     */
    void updateTask(Task task);

    /**
     * @param
     * @return list
     * @author chen bo
     * @date 2019/10/15
     * @description: 根据任务状态查询任务
     */
    List<Task> selectByStatus(Byte status);

    /**
     * @param userId
     * @return 整数
     * @author chen bo
     * @date 2019/10/15
     * @description: 查询未完成任务数量
     */
    Integer selectUndoTaskCount(String userId);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/15
     * @description: 查询任务详情
     */
    Task selectById(String taskId);

}
