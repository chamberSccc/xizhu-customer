package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.constant.OptConst;
import com.tangmo.xizhu.customer.dao.DeviceFileDao;
import com.tangmo.xizhu.customer.dao.MachRecordDao;
import com.tangmo.xizhu.customer.entity.*;
import com.tangmo.xizhu.customer.service.FormStateService;
import com.tangmo.xizhu.customer.service.MachRecordService;
import com.tangmo.xizhu.customer.service.OptRecordService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/23
 * @Version V1.0
 * @Description: 机械安装工作记录service实现类
 **/
@Service("machRecordService")
public class MachRecordServiceImpl implements MachRecordService {
    @Resource
    private MachRecordDao machRecordDao;
    @Resource
    private DeviceFileDao deviceFileDao;
    @Resource
    private OptRecordService optRecordService;
    @Resource
    private FormStateService formStateService;
    @Override
    public HttpResult addRecord(MachRecord machRecord) {
        if(machRecord == null|| machRecord.getTaskId() == null ){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        String uuid = EncryptUtil.get32Uuid();
        machRecord.setUuid(uuid);
        machRecordDao.insertMachRecord(machRecord);
        //操作记录
        optRecordService.addOptRecord(machRecord.getTaskId(),machRecord.getCreatedBy(), OptConst.INSTALL_RECORD);
        //任务流程
        formStateService.changeFormState(machRecord.getTaskId(),"form10");
        return HttpResult.success();
    }

    @Override
    public HttpResult changeRecord(MachRecord machRecord) {
        if(machRecord.getUuid() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        machRecordDao.updateMachRecord(machRecord);
        return HttpResult.success();
    }

    @Override
    public HttpResult getDeviceByTaskId(String taskId) {
        List<MachRecord> list = machRecordDao.selectByTaskId(taskId);
        MachRecord machRecord = new MachRecord();
        if(list.size() == 0){
            DeviceFile deviceFile = deviceFileDao.selectByTaskId(taskId);
            machRecord.setTaskId(taskId);
            machRecord.setDeviceType(deviceFile.getDeviceType());
        }else{
            MachRecord temp = list.get(0);
            machRecord.setTaskId(taskId);
            machRecord.setDeviceType(temp.getDeviceType());
            machRecord.setDeviceName(temp.getDeviceName());
        }
        return HttpResult.success(machRecord);
    }

    @Override
    public HttpResult getDailyDate(String taskId) {
        DeviceFile deviceFile = deviceFileDao.selectByTaskId(taskId);
        if(deviceFile == null){
            return HttpResult.fail(ResultCode.DEVICE_FILE_MISS);
        }
        List<MachRecord> machRecords = machRecordDao.selectDateByTaskId(taskId);
        return HttpResult.success(machRecords);
    }

    @Override
    public HttpResult getByRecordId(String recordId) {
        MachRecord machRecord = machRecordDao.selectById(recordId);
        return HttpResult.success(machRecord);
    }
}
