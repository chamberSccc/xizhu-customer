package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.dao.EquipSurveyDao;
import com.tangmo.xizhu.customer.entity.EquipSurvey;
import com.tangmo.xizhu.customer.service.EquipSurveyService;
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
public class EquipServiceImpl implements EquipSurveyService {
    @Resource
    private EquipSurveyDao equipSurveyDao;
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
        return HttpResult.success(equipSurvey);
    }
}
