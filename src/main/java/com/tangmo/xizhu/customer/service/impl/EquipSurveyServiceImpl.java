package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.constant.OptConst;
import com.tangmo.xizhu.customer.dao.EquipSurveyDao;
import com.tangmo.xizhu.customer.dao.OutEquipCheckDao;
import com.tangmo.xizhu.customer.dao.TaskDao;
import com.tangmo.xizhu.customer.entity.EquipSurvey;
import com.tangmo.xizhu.customer.entity.OutEquipCheck;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.TaskRequire;
import com.tangmo.xizhu.customer.service.EquipSurveyService;
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
 * @Description: 安调服务满意度调查表service实现类
 **/
@Service("equipSurveyService")
public class EquipSurveyServiceImpl implements EquipSurveyService {
    @Resource
    private EquipSurveyDao equipSurveyDao;
    @Resource
    private TaskRequireService taskRequireService;
    @Resource
    private TaskDao taskDao;
    @Resource
    private OutEquipCheckDao outEquipCheckDao;
    @Resource
    private OptRecordService optRecordService;
    @Resource
    private FormStateService formStateService;
    @Override
    public HttpResult addSurvey(EquipSurvey equipSurvey) {
        if(equipSurvey == null || equipSurvey.getTaskId() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        EquipSurvey exists = equipSurveyDao.selectByTaskId(equipSurvey.getTaskId());
        if(exists != null){
            return HttpResult.fail(ResultCode.SURVEY_EXIST);
        }
        equipSurvey.setUuid(EncryptUtil.get32Uuid());
        equipSurveyDao.insertSurvey(equipSurvey);
        //操作记录
        optRecordService.addOptRecord(equipSurvey.getTaskId(),equipSurvey.getCreatedBy(), OptConst.EQUIP_SURVEY);
        //任务流程
        formStateService.changeFormState(equipSurvey.getTaskId(),"form16");
        return HttpResult.success();
    }

    @Override
    public HttpResult changeSurvey(EquipSurvey equipSurvey) {
        if(equipSurvey == null || equipSurvey.getUuid() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        equipSurveyDao.updateSurvey(equipSurvey);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        EquipSurvey equipSurvey = equipSurveyDao.selectByTaskId(taskId);
        if(equipSurvey == null){
            TaskRequire taskRequire = (TaskRequire) taskRequireService.getByTaskId(taskId).getData();
            Task task = taskDao.selectById(taskId);
            OutEquipCheck outEquipCheck = outEquipCheckDao.selectByTaskId(taskId);
            if(outEquipCheck == null){
                return HttpResult.fail(ResultCode.NOT_CHECK);
            }
            equipSurvey = new EquipSurvey();
            equipSurvey.setTaskId(taskId);
            equipSurvey.setCompanyName(taskRequire.getCompanyName());
            equipSurvey.setMobile(taskRequire.getMobile());
            equipSurvey.setServiceUser(task.getExecutor());
            equipSurvey.setCheckDate(outEquipCheck.getCreatedTime());
            //调试日期
        }
        return HttpResult.success(equipSurvey);
    }
}
