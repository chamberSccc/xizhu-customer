package com.tangmo.xizhu.customer.entity.converter;

import com.tangmo.xizhu.customer.entity.FastFeedBack;
import com.tangmo.xizhu.customer.entity.FastSurvey;

/**
 * @Author chen bo
 * @Date 2019/10/24
 * @Version V1.0
 * @Description: 快速服务反馈单转换器
 **/
public class FastFbConverter {

    public static FastSurvey FastFb2FastSurvey(FastFeedBack fastback){
        if(fastback == null){
            return null;
        }
        FastSurvey fastSurvey = new FastSurvey();
        fastSurvey.setTaskId(fastback.getTaskId());
        fastSurvey.setApplyDate(fastback.getApplyDate());
        fastSurvey.setCompanyName(fastback.getCompanyName());
        fastSurvey.setDeviceType(fastback.getDeviceType());
        fastSurvey.setContactName(fastback.getContactName());
        fastSurvey.setMobile(fastback.getMobile());
        fastSurvey.setEngineer(fastback.getEngineer());
        fastSurvey.setServiceDate(fastback.getServiceDate());
        fastSurvey.setTaskAssignType(fastback.getTaskAssignType());
        fastSurvey.setAssemblyType(fastback.getAssemblyType());
        fastSurvey.setTroubleType(fastback.getTroubleType());
        fastSurvey.setDetail(fastback.getDetail());
        fastSurvey.setSolution(fastback.getSolution());
        fastSurvey.setResult(fastback.getResult());
        fastSurvey.setDetailAudioId(fastback.getDetailAudioId());
        fastSurvey.setDetailSpeechId(fastback.getDetailSpeechId());
        fastSurvey.setDetailPictureList(fastback.getDetailPictureList());
        fastSurvey.setSolAudioId(fastback.getSolAudioId());
        fastSurvey.setSolSpeechId(fastback.getSolSpeechId());
        fastSurvey.setSolPictureList(fastback.getSolPictureList());
        return fastSurvey;
    }
}
