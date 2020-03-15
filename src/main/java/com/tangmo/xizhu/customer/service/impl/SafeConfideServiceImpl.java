package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.constant.OptConst;
import com.tangmo.xizhu.customer.constant.TaskAttachConst;
import com.tangmo.xizhu.customer.dao.SafeConfideDao;
import com.tangmo.xizhu.customer.dao.TaskAttachDao;
import com.tangmo.xizhu.customer.entity.SafeConfide;
import com.tangmo.xizhu.customer.entity.TaskAttach;
import com.tangmo.xizhu.customer.entity.converter.TaskAttachConverter;
import com.tangmo.xizhu.customer.service.FormStateService;
import com.tangmo.xizhu.customer.service.OptRecordService;
import com.tangmo.xizhu.customer.service.SafeConfideService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private TaskAttachDao taskAttachDao;
    @Resource
    private OptRecordService optRecordService;
    @Resource
    private FormStateService formStateService;
    @Override
    public HttpResult addSafeConfide(SafeConfide safeConfide) {
        if(safeConfide == null || safeConfide.getTaskId() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        SafeConfide exists = safeConfideDao.selectByTaskId(safeConfide.getTaskId());
        if(exists != null){
            return HttpResult.fail(ResultCode.DOUBLE_SUBMIT);
        }
        String uuid = EncryptUtil.get32Uuid();
        safeConfide.setUuid(uuid);
        safeConfideDao.insertSafeConfide(safeConfide);
        dealPictureList(safeConfide.getPictureList(),uuid);
        //操作记录
        optRecordService.addOptRecord(safeConfide.getTaskId(),safeConfide.getCreatedBy(), OptConst.SAFE_CONFIDE);
        //任务流程
        formStateService.changeFormState(safeConfide.getTaskId(),"form08");
        return HttpResult.success();
    }

    @Override
    public HttpResult changeSafeConfide(SafeConfide safeConfide) {
        if(safeConfide == null || safeConfide.getUuid() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        //要删除之前的照片
        safeConfideDao.updateSafeConfide(safeConfide);
        if(safeConfide.getPictureList() != null){
            taskAttachDao.deleteByParentAndType(safeConfide.getUuid(),TaskAttachConst.SAFE_CONFIDE,TaskAttachConst.DETAIL);
            dealPictureList(safeConfide.getPictureList(),safeConfide.getUuid());
        }
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        SafeConfide safeConfide = safeConfideDao.selectByTaskId(taskId);
        if(safeConfide == null){
            safeConfide = new SafeConfide();
            safeConfide.setTaskId(taskId);
        }else{
            List<String> pictureList = taskAttachDao.selectByParentAndType(safeConfide.getUuid(),TaskAttachConst.SAFE_CONFIDE,
                    TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
            safeConfide.setPictureList(pictureList);
        }
        return HttpResult.success(safeConfide);
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
                TaskAttachConst.SAFE_CONFIDE, TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
        if(detailAttach != null){
            taskAttachDao.insertBatchAttach(detailAttach);
        }
        return ;
    }
}
