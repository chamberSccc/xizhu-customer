package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.constant.OptConst;
import com.tangmo.xizhu.customer.dao.FieldSurveyDao;
import com.tangmo.xizhu.customer.dao.TaskDao;
import com.tangmo.xizhu.customer.entity.FieldSurvey;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.TaskRequire;
import com.tangmo.xizhu.customer.service.FieldSurveyService;
import com.tangmo.xizhu.customer.service.FormStateService;
import com.tangmo.xizhu.customer.service.OptRecordService;
import com.tangmo.xizhu.customer.service.TaskRequireService;
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
public class FieldSurveyServiceImpl implements FieldSurveyService {

    @Resource
    private FieldSurveyDao fieldSurveyDao;
    @Resource
    private TaskRequireService taskRequireService;
    @Resource
    private TaskDao taskDao;
    @Resource
    private OptRecordService optRecordService;
    @Resource
    private FormStateService formStateService;
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
        //操作记录
        optRecordService.addOptRecord(fieldSurvey.getTaskId(),fieldSurvey.getCreatedBy(), OptConst.FIELD_SURVEY);
        //任务流程
        formStateService.changeFormState(fieldSurvey.getTaskId(),"form07");
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
            TaskRequire taskRequire = (TaskRequire) taskRequireService.getByTaskId(taskId).getData();
            Task task = taskDao.selectById(taskId);
            fieldSurvey = new FieldSurvey();
            fieldSurvey.setTaskId(taskId);
            fieldSurvey.setCompanyName(taskRequire.getCompanyName());
            fieldSurvey.setContactName(taskRequire.getContactName());
            fieldSurvey.setMobile(taskRequire.getMobile());
            fieldSurvey.setDeviceName(taskRequire.getDeviceType());
            fieldSurvey.setServiceUser(task.getExecutor());
            fieldSurvey.setStartDate(taskRequire.getCreatedTime());
        }
        return HttpResult.success(fieldSurvey);
    }
}
