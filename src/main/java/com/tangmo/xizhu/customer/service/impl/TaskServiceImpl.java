package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.constant.TaskAttachConst;
import com.tangmo.xizhu.customer.constant.TaskStatusConst;
import com.tangmo.xizhu.customer.dao.TaskAttachDao;
import com.tangmo.xizhu.customer.dao.TaskDao;
import com.tangmo.xizhu.customer.dao.TaskRequireDao;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.TaskAttach;
import com.tangmo.xizhu.customer.entity.TaskRequire;
import com.tangmo.xizhu.customer.entity.converter.TaskAttachConverter;
import com.tangmo.xizhu.customer.entity.converter.TaskConverter;
import com.tangmo.xizhu.customer.entity.search.TaskSearch;
import com.tangmo.xizhu.customer.service.TaskService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    @Override
    @Transactional
    public HttpResult createTask(Task task) {
        //新增任务
        String uuid = EncryptUtil.get32Uuid();
        task.setUuid(uuid);
        task.setTaskStatus(TaskStatusConst.INITIAL);
        taskDao.insertTask(task);
        //新增任务需求单
        TaskRequire require = TaskConverter.task2Require(task);
        String requireId = EncryptUtil.get32Uuid();
        require.setUuid(requireId);
        require.setTaskNo("001");
        taskRequireDao.insertTaskRequire(require);
        //添加任务需求单图片附件
        List<TaskAttach> attaches = TaskAttachConverter.String2Entity(require.getDetailPictureList(),requireId,
                TaskAttachConst.REQUIRE_ATTACH,TaskAttachConst.PICTURE);
        if(attaches != null){
            taskAttachDao.insertBatchAttach(attaches);
        }
        return HttpResult.success();
    }

    @Override
    public HttpResult changeTask(Task task) {
        return null;
    }

    @Override
    public HttpResult changeTaskUser(String taskId, String userId, Byte taskStatus) {
        taskDao.updateTaskUser(taskId, userId, taskStatus);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeTaskStatus(String taskId, Byte status) {
        taskDao.updateStatus(taskId,status);
        return HttpResult.success();
    }

    @Override
    public HttpResult getUndoTaskList(String userId, TaskSearch taskSearch) {
        return HttpResult.success(taskDao.selectByStatusAndUser(userId, TaskStatusConst.DEALING));
    }

    @Override
    public HttpResult getDoneTaskList(String userId, TaskSearch taskSearch) {
        return HttpResult.success(taskDao.selectByStatusAndUser(userId, TaskStatusConst.COMPLETE));
    }

    @Override
    public HttpResult getLaunchTaskList(String userId, TaskSearch taskSearch) {
        return null;
    }

    @Override
    public HttpResult getUndoTaskCount(String userId) {
        return HttpResult.success(taskDao.selectUndoCountByUser(userId));
    }

    @Override
    public HttpResult getUnauditCount(String userId) {
        return HttpResult.success(taskDao.selectUnauditCountByUser(userId));
    }

    @Override
    public HttpResult getTaskListBySearch(TaskSearch taskSearch) {
        return null;
    }

    @Override
    public HttpResult commitTask(Task task) {
        return null;
    }
}
