package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.Page;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.constant.AuditOperateConst;
import com.tangmo.xizhu.customer.constant.TaskStatusConst;
import com.tangmo.xizhu.customer.constant.TaskTypeConst;
import com.tangmo.xizhu.customer.dao.AuditTaskDao;
import com.tangmo.xizhu.customer.dao.DeptDao;
import com.tangmo.xizhu.customer.dao.TaskDao;
import com.tangmo.xizhu.customer.entity.*;
import com.tangmo.xizhu.customer.entity.search.TaskSearch;
import com.tangmo.xizhu.customer.service.AuditTaskService;
import com.tangmo.xizhu.customer.service.EquipAuditService;
import com.tangmo.xizhu.customer.service.FieldAssignService;
import com.tangmo.xizhu.customer.service.TaskService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/21
 * @Version V1.0
 * @Description: 审核任务service实现类
 **/
@Service("auditTaskService")
public class AuditTaskServiceImpl implements AuditTaskService {
    @Resource
    @Lazy
    private TaskService taskService;
    @Resource
    private AuditTaskDao auditTaskDao;
    @Resource
    private TaskDao taskDao;
    @Resource
    private DeptDao deptDao;
    @Resource
    private FieldAssignService fieldAssignService;
    @Resource
    private EquipAuditService equipAuditService;
    @Override
    @Transactional
    public HttpResult assignTask(AuditTask auditTask) {
        //如果当前任务已完成，不能审核
        //修改任务执行人
        taskService.changeTaskUser(auditTask.getTaskId(),auditTask.getAssignUser(), TaskStatusConst.DEALING,auditTask.getTaskType());
        //新增审批流
        auditTask.setOperation(AuditOperateConst.ASSIGN);
        auditTask.setUuid(EncryptUtil.get32Uuid());
        auditTaskDao.insertAuditTask(auditTask);
        //增加指派单和审核单
        if(auditTask.getTaskType().equals(TaskTypeConst.FIELD_SERVICE) || auditTask.getTaskType().equals(TaskTypeConst.EQUIPMENT)){
            FieldAssign fieldAssign = (FieldAssign) fieldAssignService.getByTaskId(auditTask.getTaskId()).getData();
            fieldAssign.setCreatedBy(auditTask.getCreatedBy());
            fieldAssign.setLeader(auditTask.getCreatedBy());
            fieldAssign.setFieldTarget(auditTask.getComment());
            fieldAssignService.addFieldAssign(fieldAssign);
        }
        if(auditTask.getTaskType().equals(TaskTypeConst.OUT_EQUIPMENT)){
            OutEquipAudit outEquipAudit = (OutEquipAudit) equipAuditService.getByTaskId(auditTask.getTaskId()).getData();
            outEquipAudit.setCreatedBy(auditTask.getCreatedBy());
            outEquipAudit.setOpinion(auditTask.getComment());
            equipAuditService.addOutAudit(outEquipAudit);
        }
        return HttpResult.success();
    }

    @Override
    public HttpResult addAuditTask(String taskId,String userId, Byte taskType, Byte operation) {
        AuditTask auditTask = new AuditTask();
        auditTask.setCreatedBy(userId);
        auditTask.setUuid(EncryptUtil.get32Uuid());
        auditTask.setTaskType(taskType);
        auditTask.setOperation(operation);
        auditTask.setTaskId(taskId);
        auditTaskDao.insertAuditTask(auditTask);
        return HttpResult.success();
    }

    @Override
    public HttpResult rejectTask(AuditTask auditTask) {
        if(auditTask == null || auditTask.getTaskId() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        Task task = taskDao.selectById(auditTask.getTaskId());
        //如果当前任务已完成，不能审核
        taskService.changeTaskStatus(auditTask.getTaskId(), TaskStatusConst.REJECT);
        auditTask.setOperation(AuditOperateConst.REJECT);
        auditTask.setUuid(EncryptUtil.get32Uuid());
        auditTask.setTaskType(task.getTaskType());
        auditTaskDao.insertAuditTask(auditTask);
        return HttpResult.success();
    }

    @Override
    public HttpResult finishTask(AuditTask auditTask) {
        if(auditTask == null || auditTask.getTaskId() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        Task task = taskDao.selectById(auditTask.getTaskId());
        //标记任务完成
        taskService.changeTaskStatus(auditTask.getTaskId(), TaskStatusConst.COMPLETE);
        auditTask.setOperation(AuditOperateConst.COMPLETE);
        auditTask.setUuid(EncryptUtil.get32Uuid());
        auditTask.setTaskType(task.getTaskType());
        auditTaskDao.insertAuditTask(auditTask);
        return HttpResult.success();
    }

    @Override
    public Boolean checkTaskStatus(String taskId) {
        return null;
    }

    @Override
    public HttpResult getUndoAuditList(String userId,TaskSearch taskSearch) {
        Department department = deptDao.selectByUserId(userId);
        Page page = taskSearch;
        page.startPage();
        List<Task> list = taskDao.selectByStatusAndType(TaskStatusConst.INITIAL,department.getTaskType());
        page.setResult(list);
        return HttpResult.success(page);
    }

    @Override
    public HttpResult getDoneAuditList(String userId,TaskSearch taskSearch) {
        Page page = taskSearch;
        page.startPage();
        List<Task> list = taskDao.selectAuditedTask(userId);
        page.setResult(list);
        return HttpResult.success(page);
    }

    @Override
    public HttpResult getRejectAuditList(String userId,TaskSearch taskSearch) {
        Page page = taskSearch;
        page.startPage();
        List<Task> list = taskDao.selectByStatus(TaskStatusConst.REJECT);
        page.setResult(list);
        return HttpResult.success(page);
    }

    @Override
    public HttpResult getAuditFlowList(String taskId) {
        return HttpResult.success(auditTaskDao.selectByTaskId(taskId));
    }
}
