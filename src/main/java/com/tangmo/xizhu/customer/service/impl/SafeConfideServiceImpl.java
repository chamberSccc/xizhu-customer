package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.SafeConfideDao;
import com.tangmo.xizhu.customer.entity.SafeConfide;
import com.tangmo.xizhu.customer.service.SafeConfideService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/10/23
 * @Version V1.0
 * @Description: 安全交底表service实现类
 **/
@Service("safeConfideService")
public class SafeConfideServiceImpl implements SafeConfideService {
    @Resource
    private SafeConfideDao safeConfideDao;
    @Override
    public HttpResult addSafeConfide(SafeConfide safeConfide) {
        safeConfide.setUuid(EncryptUtil.get32Uuid());
        safeConfideDao.insertSafeConfide(safeConfide);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeSafeConfide(SafeConfide safeConfide) {
        safeConfideDao.updateSafeConfide(safeConfide);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        return HttpResult.success(safeConfideDao.selectByTaskId(taskId));
    }
}
