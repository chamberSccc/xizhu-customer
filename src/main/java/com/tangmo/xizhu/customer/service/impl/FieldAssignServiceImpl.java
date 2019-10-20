package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.FieldAssignDao;
import com.tangmo.xizhu.customer.entity.FieldAssign;
import com.tangmo.xizhu.customer.service.FieldAssignService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description: 现场服务指派单service实现类
 **/
@Service("fieldAssignService")
public class FieldAssignServiceImpl implements FieldAssignService {

    @Resource
    private FieldAssignDao fieldAssignDao;
    @Override
    public HttpResult addFieldAssign(FieldAssign fieldAssign) {
        fieldAssignDao.insertAssign(fieldAssign);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeFieldAssign(FieldAssign fieldAssign) {
        fieldAssignDao.updateAssign(fieldAssign);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        return HttpResult.success(fieldAssignDao.selectByTaskId(taskId));
    }
}
