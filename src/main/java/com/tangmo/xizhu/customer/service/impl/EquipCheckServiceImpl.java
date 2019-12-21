package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.constant.OptConst;
import com.tangmo.xizhu.customer.constant.TaskAttachConst;
import com.tangmo.xizhu.customer.dao.OutEquipApplyDao;
import com.tangmo.xizhu.customer.dao.OutEquipCheckDao;
import com.tangmo.xizhu.customer.dao.TaskAttachDao;
import com.tangmo.xizhu.customer.entity.OutEquipApply;
import com.tangmo.xizhu.customer.entity.OutEquipCheck;
import com.tangmo.xizhu.customer.entity.TaskAttach;
import com.tangmo.xizhu.customer.entity.converter.EquipApplyConverter;
import com.tangmo.xizhu.customer.entity.converter.TaskAttachConverter;
import com.tangmo.xizhu.customer.service.EquipCheckService;
import com.tangmo.xizhu.customer.service.FormStateService;
import com.tangmo.xizhu.customer.service.OptRecordService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件安装调试现场服务验收单service实现类
 **/
@Service("equipCheckService")
public class EquipCheckServiceImpl implements EquipCheckService {
    @Resource
    private OutEquipCheckDao outEquipCheckDao;
    @Resource
    private OutEquipApplyDao outEquipApplyDao;
    @Resource
    private TaskAttachDao taskAttachDao;
    @Resource
    private OptRecordService optRecordService;
    @Resource
    private FormStateService formStateService;
    @Override
    public HttpResult addOutCheck(OutEquipCheck outEquipCheck) {
        String uuid = EncryptUtil.get32Uuid();
        outEquipCheck.setUuid(uuid);
        outEquipCheckDao.insertOutCheck(outEquipCheck);
        //处理附件
        dealPictureList(outEquipCheck.getDetailPictureList(),uuid);
        //操作记录
        optRecordService.addOptRecord(outEquipCheck.getTaskId(),outEquipCheck.getCreatedBy(), OptConst.EQUIP_CHECK);
        //任务流程
        formStateService.changeFormState(outEquipCheck.getTaskId(),"form15");
        return HttpResult.success();
    }

    @Override
    public HttpResult changeOutCheck(OutEquipCheck outEquipCheck) {
        if(outEquipCheck.getUuid() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        outEquipCheckDao.updateOutCheck(outEquipCheck);
        //处理附件
        if(outEquipCheck.getDetailPictureList() != null || outEquipCheck.getDetailPictureList().size() > 0){
            taskAttachDao.deleteByParentAndType(outEquipCheck.getUuid(),TaskAttachConst.EQUIP_CHECK, TaskAttachConst.PICTURE);
            dealPictureList(outEquipCheck.getDetailPictureList(),outEquipCheck.getUuid());
        }
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        OutEquipCheck outEquipCheck = outEquipCheckDao.selectByTaskId(taskId);
        if(outEquipCheck == null){
            OutEquipApply outEquipApply = outEquipApplyDao.selectByTaskId(taskId);
            if(outEquipApply == null){
                return HttpResult.fail(ResultCode.EQUIP_APPLY_MISS);
            }else{
                outEquipCheck = EquipApplyConverter.apply2Check(outEquipApply);
            }
        }else{
            //添加附件图片列表
            List<String> list = taskAttachDao.selectByParentAndType(outEquipCheck.getUuid(),TaskAttachConst.EQUIP_CHECK,
                    TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
            outEquipCheck.setDetailPictureList(list);
        }
        return HttpResult.success(outEquipCheck);
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
                TaskAttachConst.EQUIP_CHECK, TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
        if(detailAttach != null){
            taskAttachDao.insertBatchAttach(detailAttach);
        }
        return ;
    }
}
