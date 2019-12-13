package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.VersionDao;
import com.tangmo.xizhu.customer.service.VersionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/12/9
 * @Version V1.0
 * @Description: 版本service
 **/
@Service("versionService")
public class VersionServiceImpl implements VersionService {
    @Resource
    private VersionDao versionDao;
    @Override
    public HttpResult getLatestVersion() {
        return HttpResult.success(versionDao.selectLatestVersion());
    }
}
