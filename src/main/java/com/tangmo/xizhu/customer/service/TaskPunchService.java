package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.TaskPunch;

/**
 * @Author chen bo
 * @Date 2019/11/16
 * @Version V1.0
 * @Description: 任务打卡服务类
 **/
public interface TaskPunchService {
    /**
     * @param taskPunch
     * @return
     * @author chen bo
     * @date 2019/11/14
     * @description: 开始任务打卡
     */
    HttpResult startPunch(TaskPunch taskPunch);

    /**
     * @param taskPunch
     * @return
     * @author chen bo
     * @date 2019/11/14
     * @description: 结束任务打卡
     */
    HttpResult endPunch(TaskPunch taskPunch);

    /**
     * @param taskPunch
     * @return
     * @author chen bo
     * @date 2019/11/16
     * @description: 修改开始打卡
     */
    HttpResult changeStartPunch(TaskPunch taskPunch);

    /**
     * @param taskPunch
     * @return
     * @author chen bo
     * @date 2019/11/16
     * @description: 修改结束打卡
     */
    HttpResult changeEndPunch(TaskPunch taskPunch);

    /**
     * @param taskId
     * @param userId
     * @param punchType
     * @return
     * @author chen bo
     * @date 2019/11/16
     * @description: 获取用户打卡记录
     */
    HttpResult getUserPunch(String taskId,String userId,Byte punchType);

}
