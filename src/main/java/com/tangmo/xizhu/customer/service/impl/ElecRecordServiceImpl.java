package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.constant.InstallRecordConst;
import com.tangmo.xizhu.customer.dao.DailyRecordDao;
import com.tangmo.xizhu.customer.dao.ElecRecordDao;
import com.tangmo.xizhu.customer.dao.MachRecordDao;
import com.tangmo.xizhu.customer.entity.DailyRecord;
import com.tangmo.xizhu.customer.entity.ElecRecord;
import com.tangmo.xizhu.customer.entity.MachRecord;
import com.tangmo.xizhu.customer.service.ElecRecordService;
import com.tangmo.xizhu.customer.service.MachRecordService;
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
    private DailyRecordDao dailyRecordDao;
    @Override
    public HttpResult addRecord(ElecRecord elecRecord) {
        elecRecordDao.insertElecRecord(elecRecord);
        List<DailyRecord> work = elecRecord.getWorkList();
        List<DailyRecord> safe = elecRecord.getSafeList();
        dailyRecordDao.insertBatchDaily(integrateDaily(work,safe));
        return HttpResult.success();
    }

    @Override
    public HttpResult changeRecord(ElecRecord elecRecord) {
        elecRecordDao.updateElecRecord(elecRecord);
        dailyRecordDao.deleteByParentAndBase(elecRecord.getUuid(),InstallRecordConst.BASE_ELEC);
        List<DailyRecord> work = elecRecord.getWorkList();
        List<DailyRecord> safe = elecRecord.getSafeList();
        dailyRecordDao.insertBatchDaily(integrateDaily(work,safe));
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        ElecRecord elecRecord = elecRecordDao.selectByTaskId(taskId);
        List<DailyRecord> work = dailyRecordDao.selectByParentAndType(elecRecord.getUuid(),InstallRecordConst.BASE_ELEC,InstallRecordConst.WORK);
        List<DailyRecord> safe = dailyRecordDao.selectByParentAndType(elecRecord.getUuid(),InstallRecordConst.BASE_ELEC,InstallRecordConst.SAFE);
        elecRecord.setWorkList(work);
        elecRecord.setSafeList(safe);
        return HttpResult.success(elecRecord);
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
            workList.get(i).setBaseType(InstallRecordConst.BASE_ELEC);
            workList.get(i).setContentType(InstallRecordConst.WORK);
        }
        for (int i = 0; i < safeList.size(); i++) {
            safeList.get(i).setBaseType(InstallRecordConst.BASE_ELEC);
            safeList.get(i).setContentType(InstallRecordConst.SAFE);
        }
        workList.addAll(safeList);
        return workList;
    }
}
