package com.tangmo.xizhu.customer.constant;

/**
 * @Author chen bo
 * @Date 2019/10/12
 * @Version V1.0
 * @Description:
 **/
public class AssemblyType {
    private static final byte LENG_PEI = 0;
    private static final byte HONG_GAN = 1;
    private static final byte RE_TI = 2;
    private static final byte ZHEN_DONG_SHAI = 3;
    private static final byte RE_LIAO_CANG = 4;
    private static final byte BAN_GUO = 5;
    private static final byte CHENG_PIN_CANG = 6;

    private static final String LENG_PEI_CODE = "冷配总成";
    private static final String HONG_GAN_CODE = "烘干总成";
    private static final String RE_TI_CODE = "热提总成";
    private static final String ZHEN_DONG_SHAI_CODE = "振动筛总成";
    private static final String RE_LIAO_CANG_CODE = "热料仓总成";
    private static final String BAN_GUO_CODE = "拌锅总成";
    private static final String CHENG_PIN_CANG_CODE = "成品仓总成";

    public static String getCode(Byte type){
        switch (type){
            case LENG_PEI: return LENG_PEI_CODE;
            case HONG_GAN: return HONG_GAN_CODE;
            case RE_TI: return RE_TI_CODE;
            case ZHEN_DONG_SHAI: return ZHEN_DONG_SHAI_CODE;
            case RE_LIAO_CANG: return RE_LIAO_CANG_CODE;
            case BAN_GUO: return BAN_GUO_CODE;
            case CHENG_PIN_CANG: return CHENG_PIN_CANG_CODE;
            default:return "";
        }
    }

    public static Byte getType(String code){
        switch (code){
            case LENG_PEI_CODE: return LENG_PEI;
            case HONG_GAN_CODE: return HONG_GAN;
            case RE_TI_CODE: return RE_TI;
            case ZHEN_DONG_SHAI_CODE: return ZHEN_DONG_SHAI;
            case RE_LIAO_CANG_CODE: return RE_LIAO_CANG;
            case BAN_GUO_CODE: return BAN_GUO;
            case CHENG_PIN_CANG_CODE: return CHENG_PIN_CANG;
            default: return null;
        }
    }


}
