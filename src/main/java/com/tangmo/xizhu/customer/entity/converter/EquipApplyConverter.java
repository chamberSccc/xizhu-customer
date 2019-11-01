package com.tangmo.xizhu.customer.entity.converter;

import com.tangmo.xizhu.customer.entity.OutEquipApply;
import com.tangmo.xizhu.customer.entity.OutEquipAudit;
import com.tangmo.xizhu.customer.entity.OutEquipCheck;
import com.tangmo.xizhu.customer.entity.OutEquipNotice;

/**
 * @Author chen bo
 * @Date 2019/11/1
 * @Version V1.0
 * @Description: 外购件申请converter
 **/
public class EquipApplyConverter {

    //申请单转换为通知单
    public static OutEquipNotice apply2Notice(OutEquipApply outEquipApply){
        if(outEquipApply == null){
            return null;
        }
        OutEquipNotice outEquipNotice = new OutEquipNotice();
        outEquipNotice.setTaskId(outEquipApply.getTaskId());
        outEquipNotice.setCompanyName(outEquipApply.getCompanyName());
        outEquipNotice.setDeviceType(outEquipApply.getDeviceType());
        outEquipNotice.setEquipName(outEquipApply.getEquipName());
        return outEquipNotice;
    }

    //申请单转换为审批单
    public static OutEquipAudit apply2Audit(OutEquipApply outEquipApply){
        if(outEquipApply == null){
            return null;
        }
        OutEquipAudit outEquipAudit = new OutEquipAudit();
        outEquipAudit.setTaskId(outEquipApply.getTaskId());
        outEquipAudit.setCompanyName(outEquipApply.getCompanyName());
        outEquipAudit.setDeviceType(outEquipApply.getDeviceType());
        outEquipAudit.setEquipName(outEquipApply.getEquipName());
        return outEquipAudit;
    }

    //申请单转换为通知单
    public static OutEquipCheck apply2Check(OutEquipApply outEquipApply){
        if(outEquipApply == null){
            return null;
        }
        OutEquipCheck outEquipCheck = new OutEquipCheck();
        outEquipCheck.setTaskId(outEquipApply.getTaskId());
        outEquipCheck.setCompanyName(outEquipApply.getCompanyName());
        outEquipCheck.setDeviceType(outEquipApply.getDeviceType());
        outEquipCheck.setEquipName(outEquipApply.getEquipName());
        outEquipCheck.setApplyUser(outEquipApply.getCreatedBy());
        outEquipCheck.setMobile(outEquipApply.getMobile());
        return outEquipCheck;
    }
}
