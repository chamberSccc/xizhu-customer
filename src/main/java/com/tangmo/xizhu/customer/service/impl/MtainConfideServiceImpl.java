package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.constant.FormTypeConst;
import com.tangmo.xizhu.customer.constant.OptConst;
import com.tangmo.xizhu.customer.constant.TaskAttachConst;
import com.tangmo.xizhu.customer.dao.DeviceFileDao;
import com.tangmo.xizhu.customer.dao.MtainConfideDao;
import com.tangmo.xizhu.customer.dao.TaskAttachDao;
import com.tangmo.xizhu.customer.entity.DeviceFile;
import com.tangmo.xizhu.customer.entity.MaintainConfide;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.TaskAttach;
import com.tangmo.xizhu.customer.entity.converter.ConfideFormConverter;
import com.tangmo.xizhu.customer.entity.converter.TaskAttachConverter;
import com.tangmo.xizhu.customer.service.FormStateService;
import com.tangmo.xizhu.customer.service.MtainConfideService;
import com.tangmo.xizhu.customer.service.OptRecordService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private TaskAttachDao taskAttachDao;
    @Resource
    private OptRecordService optRecordService;
    @Resource
    private FormStateService formStateService;
    @Override
    public HttpResult addMtainConfide(MaintainConfide maintainConfide) {
        if(maintainConfide == null || maintainConfide.getTaskId() == null || maintainConfide.getFormType() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        MaintainConfide exists = mtainConfideDao.selectByTaskIdAndType(maintainConfide.getTaskId(),maintainConfide.getFormType());
        if(exists != null){
            return HttpResult.fail(ResultCode.DOUBLE_SUBMIT);
        }
        String uuid = EncryptUtil.get32Uuid();
        maintainConfide.setUuid(uuid);
        mtainConfideDao.insertMtainConfide(maintainConfide);
        dealPictureList(maintainConfide.getPictureList(),uuid);
        //操作记录
        optRecordService.addOptRecord(maintainConfide.getTaskId(),maintainConfide.getCreatedBy(), OptConst.LIQING_CONFIDE);
        //任务流程
        formStateService.changeFormState(maintainConfide.getTaskId(),"form12");
        return HttpResult.success();
    }

    @Override
    public HttpResult changeMtainConfide(MaintainConfide maintainConfide) {
        if(maintainConfide == null || maintainConfide.getUuid() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        mtainConfideDao.updateMtainConfide(maintainConfide);
        if(maintainConfide.getPictureList() != null){
            taskAttachDao.deleteByParentAndType(maintainConfide.getUuid(),TaskAttachConst.MTAIN_CONFIDE,TaskAttachConst.DETAIL);
            dealPictureList(maintainConfide.getPictureList(),maintainConfide.getUuid());
        }
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskIdAndType(String taskId, Byte type) {
        MaintainConfide maintainConfide = mtainConfideDao.selectByTaskIdAndType(taskId, type);
        // 交底表基础数据来自于设备档案表. 如果已经填写第一张交底表,则基础数据来自于第一张交底表
        if (maintainConfide == null){
            MaintainConfide result = mtainConfideDao.selectByTaskIdAndType(taskId, FormTypeConst.FORM01);
            if(result == null){
                DeviceFile deviceFile = deviceFileDao.selectByTaskId(taskId);
                if(deviceFile == null){
                    return HttpResult.fail(ResultCode.DEVICE_FILE_MISS);
                }
                maintainConfide = new MaintainConfide();
                maintainConfide.setCompanyName(deviceFile.getCompanyName());
                maintainConfide.setDeviceName(deviceFile.getDeviceType());
                maintainConfide.setFactoryNo(deviceFile.getFactoryNo());
                maintainConfide.setContractNo(deviceFile.getContractNo());
                maintainConfide.setTaskId(deviceFile.getTaskId());
            }else{
                maintainConfide = ConfideFormConverter.formPublic2Other(result);

            }
            maintainConfide.setFormType(type);
        }else{
            //图片
            List<String> pictureList = taskAttachDao.selectByParentAndType(maintainConfide.getUuid(),TaskAttachConst.MTAIN_CONFIDE,
                    TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
            maintainConfide.setPictureList(pictureList);
        }
        return HttpResult.success(maintainConfide);
    }

    /**
     * @param detail
     * @param uuid
     * @return
     * @author chen bo
     * @date 2019/11/1
     * @description: 处理照片列表
     */
    private void dealPictureList(List<String> detail, String uuid){
        if(detail == null || detail.size() == 0){
            return;
        }
        List<TaskAttach> detailAttach = TaskAttachConverter.String2Entity(detail,uuid,
                TaskAttachConst.MTAIN_CONFIDE, TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
        if(detailAttach != null){
            taskAttachDao.insertBatchAttach(detailAttach);
        }
        return ;
    }
}
