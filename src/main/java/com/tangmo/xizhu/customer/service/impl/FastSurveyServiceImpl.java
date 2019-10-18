package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.FastSurveyDao;
import com.tangmo.xizhu.customer.entity.FastSurvey;
import com.tangmo.xizhu.customer.service.FastSurveyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description:
 **/
@Service("fastSurveyService")
public class FastSurveyServiceImpl implements FastSurveyService {
    @Resource
    private FastSurveyDao fastSurveyDao;
    @Override
    public HttpResult addSurvey(FastSurvey fastSurvey) {
        fastSurveyDao.insertFastSurvey(fastSurvey);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeSurvey(FastSurvey fastSurvey) {
        fastSurveyDao.updateFastSurvey(fastSurvey);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        return HttpResult.success(fastSurveyDao.selectByTaskId(taskId));
    }
}
