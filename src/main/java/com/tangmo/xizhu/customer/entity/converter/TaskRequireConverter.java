package com.tangmo.xizhu.customer.entity.converter;


import com.tangmo.xizhu.customer.entity.FastFeedBack;
import com.tangmo.xizhu.customer.entity.TaskRequire;

/**
 * @Author chen bo
 * @Date 2019/10/24
 * @Version V1.0
 * @Description: 服务需求单转换
 **/
public class TaskRequireConverter {

    /**
     * @param taskRequire
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 服务需求单转换快速服务反馈单
     */
    public static FastFeedBack require2FastFb(TaskRequire taskRequire){
        if(taskRequire == null){
            return null;
        }
        FastFeedBack fastFeedBack = new FastFeedBack();
        fastFeedBack.setTaskId(taskRequire.getTaskId());
        fastFeedBack.setApplyDate(taskRequire.getApplyDate());
        fastFeedBack.setCompanyName(taskRequire.getCompanyName());
        fastFeedBack.setDeviceType(taskRequire.getDeviceType());
        fastFeedBack.setContactName(taskRequire.getContactName());
        fastFeedBack.setMobile(taskRequire.getMobile());
        fastFeedBack.setTaskAssignType(taskRequire.getTaskAssignType());
        fastFeedBack.setAssemblyType(taskRequire.getAssemblyType());
        fastFeedBack.setTroubleType(taskRequire.getTroubleType());
        fastFeedBack.setDetail(taskRequire.getDetail());
        fastFeedBack.setDetailAudioId(taskRequire.getDetailAudioId());
        fastFeedBack.setDetailSpeechId(taskRequire.getDetailSpeechId());
        fastFeedBack.setDetailPictureList(taskRequire.getDetailPictureList());
        return fastFeedBack;
    }
}
