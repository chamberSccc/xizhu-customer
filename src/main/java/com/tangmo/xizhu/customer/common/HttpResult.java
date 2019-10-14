package com.tangmo.xizhu.customer.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author chen bo
 * @Date 2019/10/13
 * @Version V1.0
 * @Description: http请求返回类
 **/
@Data
public class HttpResult <T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private T data;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msg;
    private Boolean status;


    public static HttpResult success(){
        return success(null);
    }

    public static HttpResult success(Object data){
        HttpResult httpResult = new HttpResult();
        httpResult.setStatus(true);
        httpResult.setData(data);
        return httpResult;
    }

    public static HttpResult fail(){
        return fail(null);
    }

    public static HttpResult fail(ResultCode code){
        HttpResult httpResult = new HttpResult();
        httpResult.setStatus(false);
        if(code != null){
            httpResult.setCode(code.getErrCode());
            httpResult.setMsg(code.getErrMsg());
        }
        return httpResult;
    }
}
