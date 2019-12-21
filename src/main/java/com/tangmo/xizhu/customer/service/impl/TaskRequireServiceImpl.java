package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.constant.TaskAttachConst;
import com.tangmo.xizhu.customer.dao.TaskAttachDao;
import com.tangmo.xizhu.customer.dao.TaskRequireDao;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.TaskAttach;
import com.tangmo.xizhu.customer.entity.TaskRequire;
import com.tangmo.xizhu.customer.entity.converter.TaskAttachConverter;
import com.tangmo.xizhu.customer.entity.converter.TaskConverter;
import com.tangmo.xizhu.customer.service.TaskRequireService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description:
 **/
@Service("taskRequireService")
public class TaskRequireServiceImpl implements TaskRequireService {
    @Resource
    private TaskRequireDao taskRequireDao;
    @Resource
    private TaskAttachDao taskAttachDao;
    @Override
    public HttpResult addTaskRequire(TaskRequire taskRequire) {
        taskRequireDao.insertTaskRequire(taskRequire);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeTaskRequire(TaskRequire taskRequire) {
        taskRequireDao.updateTaskRequire(taskRequire);
        taskAttachDao.deleteByParentAndType(taskRequire.getUuid(),TaskAttachConst.REQUIRE_ATTACH,TaskAttachConst.DETAIL);
        //添加任务需求单图片附件
        List<TaskAttach> attaches = TaskAttachConverter.String2Entity(taskRequire.getDetailPictureList(),taskRequire.getUuid(),
                TaskAttachConst.REQUIRE_ATTACH,TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
        if(attaches != null){
            taskAttachDao.insertBatchAttach(attaches);
        }
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        TaskRequire taskRequire = taskRequireDao.selectByTaskId(taskId);
        if(taskRequire != null){
            String requireId = taskRequire.getUuid();
            List<String> attaches = taskAttachDao.selectByParentAndType(requireId, TaskAttachConst.REQUIRE_ATTACH,
                    TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
            taskRequire.setDetailPictureList(attaches);
        }else{
            return HttpResult.fail(ResultCode.TASK_ERROR);
        }
        return HttpResult.success(taskRequire);
    }
}
