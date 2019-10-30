package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.DailyRecord;
import com.tangmo.xizhu.customer.service.DailyRecordService;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/30
 * @Version V1.0
 * @Description: 每日工作记录服务实现类
 **/
public class DailyRecordServiceImpl implements DailyRecordService {
    @Override
    public HttpResult getDailyDate(String taskId) {
        return null;
    }

    @Override
    public HttpResult getByDailyId(String dailyId) {
        return null;
    }

    @Override
    public HttpResult changeBatchDaily(List<DailyRecord> list) {
        return null;
    }
}
