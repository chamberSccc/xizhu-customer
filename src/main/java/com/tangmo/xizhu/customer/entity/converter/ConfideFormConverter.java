package com.tangmo.xizhu.customer.entity.converter;

import com.tangmo.xizhu.customer.entity.MaintainConfide;

/**
 * @Author chen bo
 * @Date 2019/10/26
 * @Version V1.0
 * @Description: 交底表转换器
 **/
public class ConfideFormConverter {

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 表格公共信息转换
     */
    public static MaintainConfide formPublic2Other(MaintainConfide old){
        if(old == null){
            return null;
        }
        MaintainConfide other = new MaintainConfide();
        other.setDeviceName(old.getDeviceName());
        other.setDeviceType(old.getDeviceType());
        other.setCompanyName(old.getCompanyName());
        other.setFactoryNo(old.getFactoryNo());
        other.setContractNo(old.getContractNo());
        return other;
    }
}
