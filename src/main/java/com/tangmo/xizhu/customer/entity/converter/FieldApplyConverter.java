package com.tangmo.xizhu.customer.entity.converter;

import com.tangmo.xizhu.customer.entity.FieldApply;
import com.tangmo.xizhu.customer.entity.FieldAssign;
import com.tangmo.xizhu.customer.entity.FieldFeedBack;

/**
 * @Author chen bo
 * @Date 2019/10/24
 * @Version V1.0
 * @Description: 现场服务申请转换器
 **/
public class FieldApplyConverter {

    /**
     * @param fieldApply
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 现场服务申请单转为现场服务指派单 没有转换领导和派单时间
     */
    public static FieldAssign apply2assign(FieldApply fieldApply){
        if (fieldApply == null){
            return null;
        }
        FieldAssign fieldAssign = new FieldAssign();
        fieldAssign.setTaskId(fieldApply.getTaskId());
        fieldAssign.setApplyDate(fieldApply.getApplyDate());
        fieldAssign.setCompanyName(fieldApply.getCompanyName());
        fieldAssign.setDeviceType(fieldApply.getDeviceType());
        fieldAssign.setContactName(fieldApply.getCompanyName());
        fieldAssign.setMobile(fieldApply.getMobile());
        fieldAssign.setAssemblyType(fieldApply.getAssemblyType());
        fieldAssign.setTaskAssignType(fieldApply.getTaskAssignType());
        fieldAssign.setTroubleType(fieldApply.getTroubleType());
        fieldAssign.setDetail(fieldApply.getDetail());
        fieldAssign.setSolution(fieldApply.getSolution());
        fieldAssign.setDetailAudioId(fieldApply.getDetailAudioId());
        fieldAssign.setDetailSpeechId(fieldApply.getDetailSpeechId());
        fieldAssign.setDetailPictureList(fieldApply.getDetailPictureList());
        fieldAssign.setFieldTarget(fieldApply.getFieldTarget());
        return fieldAssign;
    }
    /**
     * @param fieldApply
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 现场服务申请单转换为现场反馈单
     */
    public static FieldFeedBack apply2FieldFb(FieldApply fieldApply){
        if(fieldApply == null){
            return null;
        }
        FieldFeedBack fieldFeedBack = new FieldFeedBack();
        fieldFeedBack.setTaskId(fieldApply.getTaskId());
        fieldFeedBack.setApplyDate(fieldApply.getApplyDate());
        fieldFeedBack.setCompanyName(fieldApply.getCompanyName());
        fieldFeedBack.setDeviceType(fieldApply.getDeviceType());
        fieldFeedBack.setContactName(fieldApply.getContactName());
        fieldFeedBack.setMobile(fieldApply.getMobile());
        fieldFeedBack.setEngineer(fieldApply.getApplyUser());//todo 现场服务申请的现场申请时间在其他里面的应用
        //fieldFeedBack.setReceiveDate(null);  //todo
        fieldFeedBack.setTaskAssignType(fieldApply.getTaskAssignType());
        fieldFeedBack.setTroubleType(fieldApply.getTroubleType());
        fieldFeedBack.setAssemblyType(fieldApply.getAssemblyType());
        fieldFeedBack.setDetail(fieldApply.getDetail());
        fieldFeedBack.setDetailAudioId(fieldApply.getDetailAudioId());
        fieldFeedBack.setDetailSpeechId(fieldApply.getDetailSpeechId());
        fieldFeedBack.setDetailPictureList(fieldApply.getDetailPictureList());
        fieldFeedBack.setSolution(fieldApply.getSolution());
        return fieldFeedBack;
    }
}
