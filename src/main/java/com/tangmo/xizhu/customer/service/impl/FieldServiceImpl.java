package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.dao.FieldSurveyDao;
import com.tangmo.xizhu.customer.entity.FieldSurvey;
import com.tangmo.xizhu.customer.service.FieldSurveyService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/11/21
 * @Version V1.0
 * @Description: 售后服务满意度调查表service实现类
 **/
@Service("fieldSurveyService")
public class FieldServiceImpl implements FieldSurveyService {

    @Resource
    private FieldSurveyDao fieldSurveyDao;
    @Override
    public HttpResult addSurvey(FieldSurvey fieldSurvey) {
        if(fieldSurvey == null || fieldSurvey.getTaskId() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        FieldSurvey exists = fieldSurveyDao.selectByTaskId(fieldSurvey.getTaskId());
        if(exists != null){
            return HttpResult.fail(ResultCode.SURVEY_EXIST);
        }
        fieldSurvey.setUuid(EncryptUtil.get32Uuid());
        fieldSurveyDao.insertSurvey(fieldSurvey);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeSurvey(FieldSurvey fieldSurvey) {
        if(fieldSurvey == null || fieldSurvey.getUuid() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        fieldSurveyDao.updateSurvey(fieldSurvey);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        FieldSurvey fieldSurvey = fieldSurveyDao.selectByTaskId(taskId);
        if(fieldSurvey == null){
            fieldSurvey = new FieldSurvey();
            fieldSurvey.setTaskId(taskId);
        }
        return HttpResult.success(fieldSurvey);
    }
}
