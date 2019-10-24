package com.tangmo.xizhu.customer.entity.converter;

import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.TaskRequire;

/**
 * @Author chen bo
 * @Date 2019/10/24
 * @Version V1.0
 * @Description:
 **/
public class TaskConverter {

    /**
     * @param task
     * @author chen bo
     * @date 2019/10/24
     * @description: 任务转换为任务需求单
     */
    public static TaskRequire task2Require(Task task){
        if(task == null){
            return null;
        }
        TaskRequire taskRequire = new TaskRequire();
        taskRequire.setApplyDate(task.getCreatedTime());
        taskRequire.setCompanyName(task.getCompanyName());
        taskRequire.setMobile(task.getMobile());
        taskRequire.setDeviceType(task.getDeviceType());
        taskRequire.setContactName(task.getContactName());
        taskRequire.setTaskAssignType(task.getTaskAssignType());
        taskRequire.setTroubleType(task.getTroubleType());
        taskRequire.setAssemblyType(task.getAssemblyType());
        taskRequire.setDetail(task.getDetail());
        taskRequire.setDetailAudioId(task.getDetailAudioId());
        taskRequire.setDetailSpeechId(task.getDetailSpeechId());
        taskRequire.setDetailPictureList(task.getDetailPictureList());
        return taskRequire;
    }
}
