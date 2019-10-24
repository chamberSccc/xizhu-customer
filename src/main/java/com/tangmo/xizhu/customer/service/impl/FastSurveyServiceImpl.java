package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.FastSurveyDao;
import com.tangmo.xizhu.customer.dao.TaskAttachDao;
import com.tangmo.xizhu.customer.entity.FastFeedBack;
import com.tangmo.xizhu.customer.entity.FastSurvey;
import com.tangmo.xizhu.customer.entity.converter.FastFbConverter;
import com.tangmo.xizhu.customer.service.FastFeedbackService;
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
    @Resource
    private FastFeedbackService fastFeedbackService;

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
        FastSurvey fastSurvey = fastSurveyDao.selectByTaskId(taskId);
        if(fastSurvey == null){
            FastFeedBack fastFeedBack = (FastFeedBack) fastFeedbackService.getByTaskId(taskId).getData();
            if(fastFeedBack != null){
                fastSurvey = FastFbConverter.FastFb2FastSurvey(fastFeedBack);
            }
        }
        return HttpResult.success(fastSurvey);
    }
}
