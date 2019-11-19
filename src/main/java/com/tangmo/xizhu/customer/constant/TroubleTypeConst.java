package com.tangmo.xizhu.customer.constant;

/**
 * @Author chen bo
 * @Date 2019/10/12
 * @Version V1.0
 * @Description: 问题类型
 **/
public class TroubleTypeConst {

    // 机械问题
    public static final byte MACHINE = 0;
    // 电气问题
    public static final byte ELECTRIC = 1;

    public static final String MACHINE_CODE = "机械问题";
    public static final String ELECTRIC_CODE = "电气问题";

    public static String getCode(Byte type){
        switch (type){
            case MACHINE: return MACHINE_CODE;
            case ELECTRIC: return ELECTRIC_CODE;
            default:return "";
        }
    }

    public static Byte getType(String code){
        switch (code){
            case MACHINE_CODE: return MACHINE;
            case ELECTRIC_CODE: return ELECTRIC;
            default: return null;
        }
    }
}
