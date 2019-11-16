package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.TaskPunch;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/11/16
 * @Version V1.0
 * @Description: 任务打卡记录dao
 **/
@Repository
public interface TaskPunchDao {

    /**
     * @param taskPunch
     * @return
     * @author chen bo
     * @date 2019/11/16
     * @description: 增加打卡记录
     */
    Integer insertPunch(TaskPunch taskPunch);

    /**
     * @param taskId
     * @param userId
     * @param punchType
     * @return
     * @author chen bo
     * @date 2019/11/16
     * @description: 根据任务和人员查询打卡记录
     */
    TaskPunch selectByUserAndType(@Param("taskId") String taskId, @Param("userId") String userId, @Param("punchType") Byte punchType);

    /**
     * @param taskPunch
     * @return
     * @author chen bo
     * @date 2019/11/16
     * @description: 修改打卡记录
     */
    Integer updatePunch(TaskPunch taskPunch);
}
