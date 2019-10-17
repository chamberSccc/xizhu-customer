package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.Page;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.search.TaskSearch;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/10/17
 * @Version V1.0
 * @Description: 任务controller
 **/
@RestController
@RequestMapping("/task")
public class TaskController extends BaseController{

    /**
     * @param task	任务实体类
     * @return
     * @author chen bo
     * @date 2019/10/17
     * @description: 发布任务
     */
    @PostMapping
    public HttpResult addTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    /**
     * @param taskSearch
     * @return
     * @author chen bo
     * @date 2019/10/17
     * @description: 获取未完成任务列表，分页
     */
    @GetMapping("/list/undo")
    public HttpResult getUndoList(TaskSearch taskSearch){
        return taskService.getUndoTaskList(getUserId(),taskSearch);
    }
}
