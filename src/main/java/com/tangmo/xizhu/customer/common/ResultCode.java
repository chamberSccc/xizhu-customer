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
    TASK_ERROR("1003","任务信息错误");

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
