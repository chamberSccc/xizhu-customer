package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.FormStateDao;
import com.tangmo.xizhu.customer.entity.FormState;
import com.tangmo.xizhu.customer.service.FormStateService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 2019/12/20
 * @description 表单状态service实现类
 */
@Service("formStateService")
public class FormStateServiceImpl implements FormStateService{
    @Resource
    private FormStateDao formStateDao;
    @Override
    public HttpResult addFormState(String taskId) {
        FormState formState = new FormState();
        formState.setTaskId(taskId);
        formState.setUuid(EncryptUtil.get32Uuid());
        formState.setForm01(true);
        formStateDao.insertFormState(formState);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeFormState(String taskId, String column) {
        formStateDao.updateFormState(taskId, column);
        return HttpResult.success();
    }

    @Override
    public HttpResult getTaskState(String taskId) {
        FormState formState = formStateDao.selectByTaskId(taskId);
        return HttpResult.success(formState);
    }
}
