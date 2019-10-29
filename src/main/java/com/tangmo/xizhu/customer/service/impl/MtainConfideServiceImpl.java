package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.constant.FormTypeConst;
import com.tangmo.xizhu.customer.dao.DeviceFileDao;
import com.tangmo.xizhu.customer.dao.MtainConfideDao;
import com.tangmo.xizhu.customer.entity.DeviceFile;
import com.tangmo.xizhu.customer.entity.MaintainConfide;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.converter.ConfideFormConverter;
import com.tangmo.xizhu.customer.service.MtainConfideService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/10/26
 * @Version V1.0
 * @Description: 沥青混合料搅拌设备维护保养交底表service实现类
 **/
@Service("mtainConfideService")
public class MtainConfideServiceImpl implements MtainConfideService {
    @Resource
    private MtainConfideDao mtainConfideDao;
    @Resource
    private DeviceFileDao deviceFileDao;
    @Override
    public HttpResult addMtainConfide(MaintainConfide maintainConfide) {
        mtainConfideDao.insertMtainConfide(maintainConfide);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeMtainConfide(MaintainConfide maintainConfide) {
        mtainConfideDao.updateMtainConfide(maintainConfide);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskIdAndType(String taskId, Byte type) {
        MaintainConfide maintainConfide = mtainConfideDao.selectByTaskIdAndType(taskId, type);
        if (maintainConfide == null){
            if(type == 1){
                //如果是第一种表，从设备档案选择信息
                DeviceFile deviceFile = deviceFileDao.selectByTaskId(taskId);
                maintainConfide = new MaintainConfide();
                maintainConfide.setCompanyName(deviceFile.getCompanyName());
                maintainConfide.setDeviceName(deviceFile.getDeviceType());
                maintainConfide.setFactoryNo(deviceFile.getFactoryNo());
                maintainConfide.setContractNo(deviceFile.getContractNo());
            }else{
                //如果是其他表，从第一张表带信息
                MaintainConfide result = mtainConfideDao.selectByTaskIdAndType(taskId, FormTypeConst.FORM01);
                maintainConfide = ConfideFormConverter.formPublic2Other(result);
            }
        }
        return HttpResult.success(maintainConfide);
    }
}
