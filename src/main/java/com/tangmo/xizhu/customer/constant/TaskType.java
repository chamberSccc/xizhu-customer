package com.tangmo.xizhu.customer.constant;

/**
 * @Author chen bo
 * @Date 2019/10/12
 * @Version V1.0
 * @Description: 任务类型
 **/
public class TaskType {

    // 安装设备
    private static final byte INSTALL_DEVICE = 0;
    // 处理问题
    private static final byte DEAL_DEVICE = 1;

    private static final String INSTALL_CODE = "安装问题";

    private static final String DEAL_CODE = "处理问题";

    /**
     * @param type
     * @return java.lang.String
     * @author chen bo
     * @date 2019/10/12
     * @description: 获取参数code
     */
    public static String getCode(Byte type){
        switch (type){
            case INSTALL_DEVICE: return INSTALL_CODE;
            case DEAL_DEVICE: return DEAL_CODE;
            default:return "";
        }
    }

    /**
     * @param code
     * @return byte
     * @author chen bo
     * @date 2019/10/12
     * @description: TODO
     */
    public static Byte getType(String code){
        switch (code){
            case INSTALL_CODE: return INSTALL_DEVICE;
            case DEAL_CODE: return DEAL_DEVICE;
            default: return null;
        }
    }

}
