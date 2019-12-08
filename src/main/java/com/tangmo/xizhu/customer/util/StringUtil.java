package com.tangmo.xizhu.customer.util;

/**
 * @Author chen bo
 * @Date 2019/11/27
 * @Version V1.0
 * @Description:
 **/
public class StringUtil {

    public static boolean isEmpty(String str){
        if(str == null){
            return true;
        }
        if(str.equals("")){
            return true;
        }
        return false;
    }
}
