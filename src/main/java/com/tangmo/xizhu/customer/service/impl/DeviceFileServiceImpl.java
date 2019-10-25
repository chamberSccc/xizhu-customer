package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.DeviceFileDao;
import com.tangmo.xizhu.customer.dao.EquipUserDao;
import com.tangmo.xizhu.customer.entity.DeviceFile;
import com.tangmo.xizhu.customer.entity.EquipUser;
import com.tangmo.xizhu.customer.service.DeviceFileService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/23
 * @Version V1.0
 * @Description: 设备档案表service实现类
 **/
@Service("deviceFileService")
public class DeviceFileServiceImpl implements DeviceFileService {
    @Resource
    private DeviceFileDao deviceFileDao;
    @Resource
    private EquipUserDao equipUserDao;
    @Override
    @Transactional
    public HttpResult addDeviceFile(DeviceFile deviceFile) {
        String uuid = EncryptUtil.get32Uuid();
        deviceFile.setUuid(uuid);
        deviceFileDao.insertDeviceFile(deviceFile);
        for (int i = 0; i < deviceFile.getUserList().size(); i++) {
            deviceFile.getUserList().get(i).setUuid(EncryptUtil.get32Uuid());
            deviceFile.getUserList().get(i).setDeviceFileId(uuid);
        }
        equipUserDao.insertBatchUser(deviceFile.getUserList());
        return HttpResult.success();
    }

    @Override
    public HttpResult changeDeviceFile(DeviceFile deviceFile) {
        deviceFileDao.updateDeviceFile(deviceFile);
        String uuid = deviceFile.getUuid();
        for (int i = 0; i < deviceFile.getUserList().size(); i++) {
            deviceFile.getUserList().get(i).setDeviceFileId(uuid);
        }
        equipUserDao.deleteByDeviceFileId(deviceFile.getUuid());
        equipUserDao.insertBatchUser(deviceFile.getUserList());
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        DeviceFile deviceFile = deviceFileDao.selectByTaskId(taskId);
        List<EquipUser> list = equipUserDao.selectByDeviceFileId(deviceFile.getUuid());
        deviceFile.setUserList(list);
        return HttpResult.success(deviceFile);
    }
}
