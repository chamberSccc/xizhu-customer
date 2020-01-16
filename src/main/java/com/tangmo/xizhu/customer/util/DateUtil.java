package com.tangmo.xizhu.customer.util;

import java.util.Calendar;

/**
 * @Author chen bo
 * @Date 2019/10/24
 * @Version V1.0
 * @Description: 时间工具类
 **/
public class DateUtil {

    /**
     * 当前年
     * @return
     */
    public static int getYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get((Calendar.YEAR));
    }

    /**
     * 当前月
     * @return
     */
    public static int getMonth(){
        Calendar cal = Calendar.getInstance();
        return cal.get((Calendar.MONTH)) + 1;
    }

}
