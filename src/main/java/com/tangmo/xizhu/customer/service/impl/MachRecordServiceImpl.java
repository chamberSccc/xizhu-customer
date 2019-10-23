package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.constant.InstallRecordConst;
import com.tangmo.xizhu.customer.dao.DailyRecordDao;
import com.tangmo.xizhu.customer.dao.MachRecordDao;
import com.tangmo.xizhu.customer.entity.DailyRecord;
import com.tangmo.xizhu.customer.entity.MachRecord;
import com.tangmo.xizhu.customer.service.MachRecordService;
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
    private DailyRecordDao dailyRecordDao;
    @Override
    public HttpResult addRecord(MachRecord machRecord) {
        machRecordDao.insertMachRecord(machRecord);
        List<DailyRecord> work = machRecord.getWorkList();
        List<DailyRecord> safe = machRecord.getSafeList();
        dailyRecordDao.insertBatchDaily(integrateDaily(work,safe));
        return HttpResult.success();
    }

    @Override
    public HttpResult changeRecord(MachRecord machRecord) {
        machRecordDao.updateMachRecord(machRecord);
        dailyRecordDao.deleteByParentAndBase(machRecord.getUuid(),InstallRecordConst.BASE_MACH);
        List<DailyRecord> work = machRecord.getWorkList();
        List<DailyRecord> safe = machRecord.getSafeList();
        dailyRecordDao.insertBatchDaily(integrateDaily(work,safe));
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        MachRecord machRecord = machRecordDao.selectByTaskId(taskId);
        List<DailyRecord> work = dailyRecordDao.selectByParentAndType(machRecord.getUuid(),InstallRecordConst.BASE_MACH,InstallRecordConst.WORK);
        List<DailyRecord> safe = dailyRecordDao.selectByParentAndType(machRecord.getUuid(),InstallRecordConst.BASE_MACH,InstallRecordConst.SAFE);
        machRecord.setWorkList(work);
        machRecord.setSafeList(safe);
        return HttpResult.success(machRecord);
    }

    /**
     * @param workList
     * @param safeList
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 整合工作记录
     */
    private List<DailyRecord> integrateDaily(List<DailyRecord> workList,List<DailyRecord> safeList){
        for (int i = 0; i < workList.size(); i++) {
            workList.get(i).setBaseType(InstallRecordConst.BASE_MACH);
            workList.get(i).setContentType(InstallRecordConst.WORK);
        }
        for (int i = 0; i < safeList.size(); i++) {
            safeList.get(i).setBaseType(InstallRecordConst.BASE_MACH);
            safeList.get(i).setContentType(InstallRecordConst.SAFE);
        }
        workList.addAll(safeList);
        return workList;
    }
}
