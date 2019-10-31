package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.OutEquipApply;
import com.tangmo.xizhu.customer.service.EquipApplyService;
import org.springframework.stereotype.Service;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件安装审批申请单service实现类
 **/
@Service("equipApplyService")
public class EquipApplyServiceImpl implements EquipApplyService {
    @Override
    public HttpResult addOutApply(OutEquipApply outEquipApply) {
        return null;
    }

    @Override
    public HttpResult changeOutApply(OutEquipApply outEquipApply) {
        return null;
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        return null;
    }
}
