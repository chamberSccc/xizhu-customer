package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.TaskPunch;
import com.tangmo.xizhu.customer.entity.search.TaskSearch;
import org.apache.ibatis.annotations.Param;
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
     * 修改任务是否满意度调查
     * @param taskId
     * @param status
     */
    void updateSurveyStatus(@Param("taskId") String taskId,@Param("status") Byte status);

    /**
     * @param taskId 任务id
     * @param userId 执行人
     * @param status 要修改的任务状态
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 修改任务执行人
     */
    void updateTaskUser(@Param("taskId") String taskId,@Param("userId") String userId,
                        @Param("status") Byte status,@Param("taskType") Byte taskType);

    /**
     * @param taskId
     * @param status
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 修改任务状态
     */
    void updateStatus(@Param("taskId") String taskId,@Param("status") Byte status);

    /**
     * @param taskId
     * @param status
     * @param taskType
     * @return
     * @author chen bo
     * @date 2019/11/1
     * @description: 修改任务类型和状态
     */
    Integer updateStatusAndType(@Param("taskId") String taskId,@Param("status") Byte status,@Param("taskType") Byte taskType);

    /**
     * @param
     * @return list
     * @author chen bo
     * @date 2019/10/15
     * @description: 根据任务状态和执行人查询任务
     */
    List<Task> selectByStatusAndUser(@Param("userId") String userId, @Param("status") Byte status);

    /**
     * 查询已完成任务列表
     * @param userId
     * @param status
     * @return
     */
    List<Task> selectDoneTask(@Param("userId") String userId, @Param("status") Byte status);

    /**
     * @param userId
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 查询已审核任务
     */
    List<Task> selectAuditedTask(@Param("userId") String userId);

    /**
     * @param status
     * @return
     * @author chen bo
     * @date 2019/10/17
     * @description: 根据任务状态查询
     */
    List<Task> selectByStatus(@Param("status") Byte status);

    /**
     * @param userId
     * @return 整数
     * @author chen bo
     * @date 2019/10/15
     * @description: 查询未完成任务数量
     */
    Integer selectUndoCountByUser(String userId);

    /**
     * 查询未完成满意度调查数量
     * @param userId
     * @return
     */
    Integer selectUnSurveyByUser(String userId);

    /**
     * 查询等待审核的满意度调查数量
     * @return
     */
    Integer selectUnauditSurveyCount();

    /**
     * @param deptId
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 查询未审核任务
     */
    Integer selectUnauditCountByDept(String deptId);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/15
     * @description: 查询任务详情
     */
    Task selectById(String taskId);

    /**
     * 查询我发起的任务
     * @param userId
     * @return
     */
    List<Task> selectLaunchedTask(@Param("userId") String userId);

    /**
     * @param devicePid
     * @param taskSearch 任务搜索对象
     * @return
     * @author chen bo
     * @date 2019/11/12
     * @description: 通过设备pid查询设备任务列表
     */
    List<Task> selectByPid(@Param("devicePid") String devicePid, @Param("search") TaskSearch taskSearch);


    /**
     * @param status
     * @param taskType
     * @return
     * @author chen bo
     * @date 2019/12/22
     * @description: 通过任务状态和类型查找任务
     */
    List<Task> selectByStatusAndType(@Param("status") Byte status,@Param("taskType") Byte taskType);

    /**
     * 查询满意度调查相关任务
     * @param userId
     * @param status
     * @return
     */
    List<Task> selectSurveyTask(@Param("userId") String userId,@Param("status") Byte status);

    /**
     * 查询系统需要的taskNo
     * @return
     */
    Integer selectTaskNo();

    /**
     * 会写TaskNo
     * @param taskNo
     * @return
     */
    Integer updateTaskNo(Integer taskNo);
}
