package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.constant.AuditOperation;
import com.tangmo.xizhu.customer.constant.TaskStatus;
import com.tangmo.xizhu.customer.dao.AuditTaskDao;
import com.tangmo.xizhu.customer.entity.AuditTask;
import com.tangmo.xizhu.customer.service.AuditTaskService;
import com.tangmo.xizhu.customer.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/10/21
 * @Version V1.0
 * @Description: 审核任务service实现类
 **/
@Service("auditService")
public class AuditTaskServiceImpl implements AuditTaskService {
    @Resource
    private TaskService taskService;
    @Resource
    private AuditTaskDao auditTaskDao;
    @Override
    public HttpResult assignTask(AuditTask auditTask) {
        //如果当前任务已完成，不能审核
        //修改任务执行人
        taskService.changeTaskUser(auditTask.getTaskId(),auditTask.getAssignUser(), TaskStatus.DEALING);
        //新增审批流
        auditTask.setOperation(AuditOperation.ASSIGN);
        auditTaskDao.insertAuditTask(auditTask);
        return HttpResult.success();
    }

    @Override
    public HttpResult rejectTask(AuditTask auditTask) {
        //如果当前任务已完成，不能审核
        auditTask.setOperation(AuditOperation.REJECT);
        return null;
    }

    @Override
    public HttpResult finishTask(AuditTask auditTask) {
        //标记任务完成
        taskService.changeTaskStatus(auditTask.getTaskId(),TaskStatus.COMPLETE);
        auditTask.setOperation(AuditOperation.COMPLETE);
        auditTaskDao.insertAuditTask(auditTask);
        return HttpResult.success();
    }

    @Override
    public Boolean checkTaskStatus(String taskId) {
        return null;
    }
}
