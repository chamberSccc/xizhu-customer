package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.constant.*;
import com.tangmo.xizhu.customer.dao.*;
import com.tangmo.xizhu.customer.entity.*;
import com.tangmo.xizhu.customer.entity.converter.TaskAttachConverter;
import com.tangmo.xizhu.customer.service.AuditTaskService;
import com.tangmo.xizhu.customer.service.EquipApplyService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件安装审批申请单service实现类
 **/
@Service("equipApplyService")
public class EquipApplyServiceImpl implements EquipApplyService {
    @Resource
    private OutEquipApplyDao outEquipApplyDao;
    @Resource
    private TaskDao taskDao;
    @Resource
    private AuditTaskDao auditTaskDao;
    @Resource
    private TaskRequireDao taskRequireDao;
    @Resource
    private TaskAttachDao taskAttachDao;
    @Resource
    private AuditTaskService auditTaskService;
    @Resource
    private TaskPunchDao taskPunchDao;
    @Override
    @Transactional
    public HttpResult addOutApply(OutEquipApply outEquipApply) {
        if(outEquipApply.getTaskId() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        Task task = taskDao.selectById(outEquipApply.getTaskId());
        //判断是否打卡
        TaskPunch taskPunch = taskPunchDao.selectByUserAndType(outEquipApply.getTaskId(),outEquipApply.getCreatedBy(),
                PunchTypeConst.OffDuty,task.getTaskType());
        if(taskPunch == null){
            return HttpResult.fail(ResultCode.END_PUNCH_MISS);
        }
        //新增外购件安装调试申请
        String uuid = EncryptUtil.get32Uuid();
        outEquipApply.setUuid(uuid);
        outEquipApplyDao.insertOutApply(outEquipApply);
        dealPictureList(outEquipApply.getDetailPictureList(),uuid);
        // 更改任务状态和类型
        taskDao.updateStatusAndType(outEquipApply.getTaskId(), TaskStatusConst.INITIAL, TaskTypeConst.OUT_EQUIPMENT);
        //增加审批流程
        auditTaskService.addAuditTask(outEquipApply.getTaskId(),outEquipApply.getCreatedBy(),
                TaskTypeConst.OUT_EQUIPMENT,AuditOperateConst.INITIAL);

        return HttpResult.success();
    }

    @Override
    public HttpResult changeOutApply(OutEquipApply outEquipApply) {
        return null;
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        OutEquipApply outEquipApply = outEquipApplyDao.selectByTaskId(taskId);
        if(outEquipApply == null){
            TaskRequire taskRequire = taskRequireDao.selectByTaskId(taskId);
            if(taskRequire == null){
                return HttpResult.fail(ResultCode.TASK_ERROR);
            }
            outEquipApply = new OutEquipApply();
            outEquipApply.setCompanyName(taskRequire.getCompanyName());
            outEquipApply.setTaskId(taskId);
            outEquipApply.setDeviceType(taskRequire.getDeviceType());
        }else{
            //查询附件信息
            List<String> list = taskAttachDao.selectByParentAndType(outEquipApply.getUuid(),TaskAttachConst.EQUIP_APPLY,
                    TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
            outEquipApply.setDetailPictureList(list);
        }
        return HttpResult.success(outEquipApply);
    }

    /**
     * @param detail
     * @param uuid
     * @return
     * @author chen bo
     * @date 2019/11/1
     * @description: 处理申请单中图片附件
     */
    private void dealPictureList(List<String> detail, String uuid){
        if(detail == null || detail.size() == 0){
            return;
        }
        List<TaskAttach> detailAttach = TaskAttachConverter.String2Entity(detail,uuid,
                TaskAttachConst.EQUIP_APPLY, TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
        if(detailAttach != null){
            taskAttachDao.insertBatchAttach(detailAttach);
        }
        return ;
    }
}
