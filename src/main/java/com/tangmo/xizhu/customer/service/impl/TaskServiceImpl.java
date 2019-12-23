package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.Page;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.constant.*;
import com.tangmo.xizhu.customer.dao.*;
import com.tangmo.xizhu.customer.entity.*;
import com.tangmo.xizhu.customer.entity.converter.TaskAttachConverter;
import com.tangmo.xizhu.customer.entity.converter.TaskConverter;
import com.tangmo.xizhu.customer.entity.search.TaskSearch;
import com.tangmo.xizhu.customer.service.*;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/15
 * @Version V1.0
 * @Description: 任务服务实现类
 **/
@Service("taskService")
public class TaskServiceImpl implements TaskService {
    @Resource
    private TaskDao taskDao;
    @Resource
    private TaskRequireDao taskRequireDao;
    @Resource
    private TaskAttachDao taskAttachDao;
    @Resource
    private AuditTaskService auditTaskService;
    @Resource
    private OptRecordService optRecordService;
    @Resource
    private FieldAssignService fieldAssignService;
    @Resource
    private TaskPunchDao taskPunchDao;
    @Resource
    private FormStateService formStateService;

    @Override
    @Transactional
    public HttpResult createTask(Task task) {
        if(task == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        if(task.getTroubleType() == null || task.getTroubleType().equals("")){
            return HttpResult.fail(ResultCode.TROUBLE_MISS);
        }
        if(task.getTaskAssignType() == null || task.getTaskAssignType().equals("")){
            return HttpResult.fail(ResultCode.TROUBLE_MISS);
        }
        if(task.getAssemblyType() == null || task.getAssemblyType().equals("")){
            return HttpResult.fail(ResultCode.TROUBLE_MISS);
        }
        if(task.getDeviceType() == null || task.getDeviceType().equals("")){
            return HttpResult.fail(ResultCode.DEVICE_MISS);
        }
        if(task.getDeviceAddress() == null || task.getDeviceAddress().equals("")){
            return HttpResult.fail(ResultCode.DEVICE_MISS);
        }
        if(task.getDevicePid() == null || task.getDevicePid().equals("")){
            return HttpResult.fail(ResultCode.DEVICE_MISS);
        }

        //新增任务
        String uuid = EncryptUtil.get32Uuid();
        task.setUuid(uuid);
        task.setTaskStatus(TaskStatusConst.DEALING);
        task.setTaskType(TaskTypeConst.FAST_SERVICE);
        task.setExecutor(task.getCreatedBy());
//        if(!task.getTaskAssignType().equals(String.valueOf(TaskTypeConst.EQUIPMENT))){
//
//        }else{
//            task.setTaskType(TaskTypeConst.EQUIPMENT);
//            //如果是安调设备，直接生成现场服务指派单
//            //fieldAssignService.addFieldAssign(task);
//        }
        //新增任务
        taskDao.insertTask(task);
        //新增任务需求单，转换任务中相同信息
        TaskRequire require = TaskConverter.task2Require(task);
        String requireId = EncryptUtil.get32Uuid();
        require.setUuid(requireId);
        require.setTaskId(uuid);
        require.setTaskNo("001");
        require.setCreatedBy(task.getCreatedBy());
        taskRequireDao.insertTaskRequire(require);
        //添加任务需求单图片附件
        List<TaskAttach> attaches = TaskAttachConverter.String2Entity(require.getDetailPictureList(),requireId,
                TaskAttachConst.REQUIRE_ATTACH,TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
        if(attaches != null){
            taskAttachDao.insertBatchAttach(attaches);
        }
        //添加任务状态
        formStateService.addFormState(uuid);
        //添加任务流程
        optRecordService.addOptRecord(task,OptConst.CREATE_TASK);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeTask(Task task) {
        return null;
    }

    @Override
    public HttpResult getTaskDetail(String taskId) {
        return HttpResult.success(taskDao.selectById(taskId));
    }

    @Override
    public HttpResult changeTaskUser(String taskId, String userId, Byte taskStatus,Byte taskType) {
        taskDao.updateTaskUser(taskId, userId, taskStatus,taskType);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeTaskStatus(String taskId, Byte status) {
        taskDao.updateStatus(taskId,status);
        return HttpResult.success();
    }

    @Override
    public HttpResult getUndoTaskList(String userId, TaskSearch taskSearch) {
        Page page = taskSearch;
        page.startPage();
        List<Task> list = taskDao.selectByStatusAndUser(userId, TaskStatusConst.DEALING);
        page.setResult(list);
        return HttpResult.success(page);
    }

    @Override
    public HttpResult getDoneTaskList(String userId, TaskSearch taskSearch) {
        Page page = taskSearch;
        page.startPage();
        List<Task> list = taskDao.selectByStatusAndUser(userId, TaskStatusConst.COMPLETE);
        page.setResult(list);
        return HttpResult.success(page);
    }

    @Override
    public HttpResult getLaunchTaskList(String userId, TaskSearch taskSearch) {
        Page page = taskSearch;
        page.startPage();
        List<Task> list = taskDao.selectLaunchedTask(userId);
        page.setResult(list);
        return HttpResult.success(page);
    }

    @Override
    public HttpResult getUndoTaskCount(String userId) {
        return HttpResult.success(taskDao.selectUndoCountByUser(userId));
    }

    @Override
    public HttpResult getUnauditCount(String deptId) {
        return HttpResult.success(taskDao.selectUnauditCountByDept(deptId));
    }

    @Override
    public HttpResult getTaskListBySearch(TaskSearch taskSearch) {
        return null;
    }

    @Override
    public HttpResult getTaskListByPid(TaskSearch taskSearch, String pid) {
        return HttpResult.success(taskDao.selectByPid(pid,taskSearch));
    }

    @Override
    public HttpResult commitTask(String taskId,String userId) {
        Task task = taskDao.selectById(taskId);
        //判断是否打卡
        if(!task.getTaskType().equals(TaskTypeConst.FAST_SERVICE)){
            TaskPunch taskPunch = taskPunchDao.selectByUserAndType(taskId,userId,
                    PunchTypeConst.OffDuty,task.getTaskType());
            if(taskPunch == null){
                return HttpResult.fail(ResultCode.END_PUNCH_MISS);
            }
        }
        //修改任务状态为待审核
        taskDao.updateStatus(taskId,TaskStatusConst.INITIAL);
        //添加审批流程
        auditTaskService.addAuditTask(taskId,userId,
                task.getTaskType(), AuditOperateConst.TASK_COMPLETE);

        return HttpResult.success();
    }

    @Override
    public HttpResult getFormList(String taskId, Byte userType) {
        Task task = taskDao.selectById(taskId);
        String trouble = task.getTroubleType();
        if(trouble.substring(0,1).equals(",")){
            trouble = trouble.substring(1,trouble.length());
        }
        String [] strArr= trouble.split(",");
        FormState formState = (FormState) formStateService.getTaskState(taskId).getData();
        ArrayList<TaskForm> list = TaskFormConst.getTaskForm(task.getTaskType(),userType, Byte.valueOf(strArr[0]));
        TaskFormConst.changeState(list,formState);
        return HttpResult.success(list);
    }
}
