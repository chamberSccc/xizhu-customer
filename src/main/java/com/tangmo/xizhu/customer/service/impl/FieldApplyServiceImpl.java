package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.FieldApplyDao;
import com.tangmo.xizhu.customer.entity.FieldApply;
import com.tangmo.xizhu.customer.service.FieldApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description: 现场服务申请单service实现类
 **/
@Service("fieldApplyService")
public class FieldApplyServiceImpl implements FieldApplyService {
    @Resource
    private FieldApplyDao fieldApplyDao;
    @Override
    public HttpResult addApply(FieldApply fieldApply) {
        fieldApplyDao.insertFieldApply(fieldApply);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeApply(FieldApply fieldApply) {
        fieldApplyDao.updateFieldApply(fieldApply);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        return HttpResult.success(fieldApplyDao.selectByTaskId(taskId));
    }
}
