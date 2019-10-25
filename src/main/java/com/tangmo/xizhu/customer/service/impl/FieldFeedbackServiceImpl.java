package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.FieldFeedbackDao;
import com.tangmo.xizhu.customer.entity.FieldFeedBack;
import com.tangmo.xizhu.customer.service.FieldFeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description: 现场服务反馈单service实现类
 **/
@Service("fieldFeedbackService")
public class FieldFeedbackServiceImpl implements FieldFeedbackService {
    @Resource
    private FieldFeedbackDao fieldFeedbackDao;
    @Override
    public HttpResult addFeedback(FieldFeedBack feedBack) {
        fieldFeedbackDao.insertFeedback(feedBack);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeFeedback(FieldFeedBack fieldFeedBack) {
        fieldFeedbackDao.updateFeedback(fieldFeedBack);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        FieldFeedBack fieldFeedBack = fieldFeedbackDao.selectByTaskId(taskId);
        if(fieldFeedBack == null){

        }else{

        }
        return HttpResult.success(fieldFeedbackDao.selectByTaskId(taskId));
    }
}
