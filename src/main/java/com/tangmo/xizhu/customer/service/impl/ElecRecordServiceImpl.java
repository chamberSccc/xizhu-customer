package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.dao.*;
import com.tangmo.xizhu.customer.entity.*;
import com.tangmo.xizhu.customer.service.ElecRecordService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/23
 * @Version V1.0
 * @Description: 电气安装工作记录service实现类
 **/
@Service("elecRecordService")
public class ElecRecordServiceImpl implements ElecRecordService {
    @Resource
    private ElecRecordDao elecRecordDao;
    @Resource
    private TaskDao taskDao;
    @Resource
    private DeviceFileDao deviceFileDao;
    @Override
    public HttpResult addRecord(ElecRecord elecRecord) {
        if(elecRecord == null || elecRecord.getTaskId() == null ){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        String uuid = EncryptUtil.get32Uuid();
        elecRecord.setUuid(uuid);
        elecRecordDao.insertElecRecord(elecRecord);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeRecord(ElecRecord elecRecord) {
        if(elecRecord.getUuid() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        elecRecordDao.updateElecRecord(elecRecord);
        return HttpResult.success();
    }

    @Override
    public HttpResult getDeviceByTaskId(String taskId) {
        List<ElecRecord> list = elecRecordDao.selectByTaskId(taskId);
        ElecRecord elecRecord = new ElecRecord();
        if(list.size() == 0){
            DeviceFile deviceFile = deviceFileDao.selectByTaskId(taskId);
            elecRecord.setTaskId(taskId);
            elecRecord.setDeviceType(deviceFile.getDeviceType());
        }else{
            ElecRecord temp = list.get(0);
            elecRecord.setTaskId(taskId);
            elecRecord.setDeviceType(temp.getDeviceType());
            elecRecord.setDeviceName(temp.getDeviceName());
        }
        return HttpResult.success(elecRecord);
    }

    @Override
    public HttpResult getDailyDate(String taskId) {
        DeviceFile deviceFile = deviceFileDao.selectByTaskId(taskId);
        if(deviceFile == null){
            return HttpResult.fail(ResultCode.DEVICE_FILE_MISS);
        }
        List<ElecRecord> elecRecords = elecRecordDao.selectDateByTaskId(taskId);
        return HttpResult.success(elecRecords);
    }

    @Override
    public HttpResult getByRecordId(String recordId) {
        ElecRecord elecRecord = elecRecordDao.selectById(recordId);
        return HttpResult.success(elecRecord);
    }
}
