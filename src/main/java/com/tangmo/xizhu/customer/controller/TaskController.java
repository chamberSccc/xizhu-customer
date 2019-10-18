package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
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

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 获取任务的服务任务需求单
     */
    @GetMapping("/{taskId}/require")
    public HttpResult getTaskRequire(@PathVariable String taskId){
        return taskRequireService.getByTaskId(taskId);
    }

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 获取任务的快速任务反馈单
     */
    @GetMapping("/{taskId}/fastFeedback")
    public HttpResult getFastFeedback(@PathVariable String taskId){
        return fastFeedbackService.getByTaskId(taskId);
    }

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 查询任务的现场服务满意度调查表
     */
    @GetMapping("/{taskId}/fastSurvey")
    public HttpResult getFastSurvey(@PathVariable String taskId){
        return fastSurveyService.getByTaskId(taskId);
    }

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 获取任务的现场服务申请单
     */
    @GetMapping("/{taskId}/fieldApply")
    public HttpResult getFieldApply(@PathVariable String taskId){return fieldApplyService.getByTaskId(taskId);}
}
