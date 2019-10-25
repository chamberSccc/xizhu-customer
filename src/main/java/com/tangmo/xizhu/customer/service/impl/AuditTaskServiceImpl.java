package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.Page;
import com.tangmo.xizhu.customer.constant.AuditOperateConst;
import com.tangmo.xizhu.customer.constant.TaskStatusConst;
import com.tangmo.xizhu.customer.dao.AuditTaskDao;
import com.tangmo.xizhu.customer.dao.TaskDao;
import com.tangmo.xizhu.customer.entity.AuditTask;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.search.TaskSearch;
import com.tangmo.xizhu.customer.service.AuditTaskService;
import com.tangmo.xizhu.customer.service.TaskService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
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
@Service("auditService")
public class AuditTaskServiceImpl implements AuditTaskService {
    @Resource
    private TaskService taskService;
    @Resource
    private AuditTaskDao auditTaskDao;
    @Resource
    private TaskDao taskDao;
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
        return HttpResult.success();
    }

    @Override
    public HttpResult rejectTask(AuditTask auditTask) {
        //如果当前任务已完成，不能审核
        auditTask.setOperation(AuditOperateConst.REJECT);
        return null;
    }

    @Override
    public HttpResult finishTask(AuditTask auditTask) {
        //标记任务完成
        taskService.changeTaskStatus(auditTask.getTaskId(), TaskStatusConst.COMPLETE);
        auditTask.setOperation(AuditOperateConst.COMPLETE);
        auditTaskDao.insertAuditTask(auditTask);
        return HttpResult.success();
    }

    @Override
    public Boolean checkTaskStatus(String taskId) {
        return null;
    }

    @Override
    public HttpResult getUndoAuditList(String userId,TaskSearch taskSearch) {
        Page page = taskSearch;
        page.startPage();
        List<Task> list = taskDao.selectByStatus(TaskStatusConst.INITIAL);
        page.setResult(list);
        return HttpResult.success(page);
    }

    @Override
    public HttpResult getDoneAuditList(String userId,TaskSearch taskSearch) {
        Page page = taskSearch;
        page.startPage();
        List<Task> list = taskDao.selectByStatus(TaskStatusConst.DEALING);
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
