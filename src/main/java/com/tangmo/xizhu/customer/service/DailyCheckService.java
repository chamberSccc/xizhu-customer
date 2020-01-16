package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.DailyCheck;

/**
 * @Author chen bo
 * @Date 2020/1/15
 * @Version V1.0
 * @Description: 每日签到service
 **/
public interface DailyCheckService {

    HttpResult addDailyPunch(DailyCheck dailyCheck);

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2020/1/15
     * @description: 按月查询类型统计
     */
    HttpResult getMonthCount(String userId);

    /**
     * @param uuid
     * @return
     * @author chen bo
     * @date 2020/1/15
     * @description: 获取用户签到记录
     */
    HttpResult getUserPunch(String uuid);
}
