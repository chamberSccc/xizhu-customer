package com.tangmo.xizhu.customer.common;

/**
 * @Author chen bo
 * @Date 2019/10/13
 * @Version V1.0
 * @Description: 错误请求返回失败信息
 **/
public enum ResultCode {
    /**1000-2000 定义公共模块错误*/
    PARAM_ERROR("1001","参数错误"),
    UPLOAD_ERROR("1002","文件上传失败"),
    TASK_ERROR("1003","任务信息错误"),
    DEVICE_FILE_MISS("1004","请先填写设备档案表"),
    FIELD_APPLY_MISS("1004","系统未收到现场服务申请"),
    EQUIP_APPLY_MISS("1005","系统未收到外购件调试申请"),
    USER_NOT_EXIST("1006","用户不存在"),
    PASSWORD_ERROR("1007","密码错误"),
    DOUBLE_SUBMIT("1008","表已存在，请勿重复提交");

    private String errCode;
    private String errMsg;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    private ResultCode(String errCode, String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
