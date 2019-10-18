package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.FastFeedbackDao;
import com.tangmo.xizhu.customer.entity.FastFeedBack;
import com.tangmo.xizhu.customer.service.FastFeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description: 快速服务反馈单实现类
 **/
@Service("fastFeedbackService")
public class FastFeedbackServiceImpl implements FastFeedbackService {

    @Resource
    private FastFeedbackDao fastFeedbackDao;
    @Override
    public HttpResult addFastFeedback(FastFeedBack fastFeedBack) {
        fastFeedbackDao.insertFastFeedback(fastFeedBack);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeFastFeedback(FastFeedBack fastFeedBack) {
        fastFeedbackDao.updateFastFeedback(fastFeedBack);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        return HttpResult.success(fastFeedbackDao.selectByTaskId(taskId));
    }
}
