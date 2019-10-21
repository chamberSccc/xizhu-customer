package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.*;
import com.tangmo.xizhu.customer.entity.search.TaskSearch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/17
 * @Version V1.0
 * @Description: 任务controller
 **/
@Api(description="任务相关接口")
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
    @ApiOperation(value = "发布任务",httpMethod = "POST",notes = "")
    @PostMapping
    public HttpResult addTask(@ApiParam(name="任务对象",value="json格式",required=true) @RequestBody Task task){
        return taskService.createTask(task);
    }
    /**
     * @param taskSearch
     * @return
     * @author chen bo
     * @date 2019/10/17
     * @description: 获取未完成任务列表，分页
     */
    @ApiOperation(value = "获取未完成任务列表,分页",httpMethod = "POST",notes = "带分页")
    @PostMapping("/list/undo")
    public HttpResult<List<Task>> getUndoList(TaskSearch taskSearch){
        return taskService.getUndoTaskList(getUserId(),taskSearch);
    }

    /**
     * @param taskSearch
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 获取已完成任务列表，分页
     */
    @ApiOperation(value = "获取已完成任务列表,分页",httpMethod = "POST",notes = "带分页")
    @PostMapping("/list/done")
    public HttpResult<List<Task>> getDoneList(TaskSearch taskSearch){
        return taskService.getDoneTaskList(getUserId(),taskSearch);
    }


    /**
     * @param taskSearch
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 获取我发起的任务列表，分页
     */
    @ApiOperation(value = "获取我发起的任务列表,分页",httpMethod = "POST",notes = "带分页")
    @PostMapping("/list/launch")
    public HttpResult<List<Task>> getLaunchList(TaskSearch taskSearch){
        return taskService.getLaunchTaskList(getUserId(),taskSearch);
    }


    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 获取任务的服务任务需求单
     */
    @ApiOperation(value = "获取任务的服务任务需求单",httpMethod = "GET",notes = "")
    @GetMapping("/{taskId}/require")
    public HttpResult<TaskRequire> getTaskRequire(@PathVariable String taskId){
        return taskRequireService.getByTaskId(taskId);
    }

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 获取任务的快速任务反馈单
     */
    @ApiOperation(value = "获取任务的快速任务反馈单",httpMethod = "GET",notes = "")
    @GetMapping("/{taskId}/fastFeedback")
    public HttpResult<FastFeedBack> getFastFeedback(@PathVariable String taskId){
        return fastFeedbackService.getByTaskId(taskId);
    }

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 获取任务的现场服务满意度调查表
     */
    @ApiOperation(value = "获取任务的现场服务满意度调查表",httpMethod = "GET",notes = "")
    @GetMapping("/{taskId}/fastSurvey")
    public HttpResult<FastSurvey> getFastSurvey(@PathVariable String taskId){
        return fastSurveyService.getByTaskId(taskId);
    }

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 获取任务的现场服务申请单
     */
    @ApiOperation(value = "获取任务的现场服务申请单",httpMethod = "GET",notes = "")
    @GetMapping("/{taskId}/fieldApply")
    public HttpResult<FieldApply> getFieldApply(@PathVariable String taskId){return fieldApplyService.getByTaskId(taskId);}

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 获取任务的现场服务指派单
     */
    @ApiOperation(value = "获取任务的现场服务指派单",httpMethod = "GET",notes = "")
    @GetMapping("/{taskId}/fieldAssign")
    public HttpResult<FieldAssign> getFieldAssign(@PathVariable String taskId){return fieldAssignService.getByTaskId(taskId);}

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 获取任务的现场服务反馈单
     */
    @ApiOperation(value = "获取任务的现场服务反馈单",httpMethod = "GET",notes = "")
    @GetMapping("/{taskId}/fieldFeedback")
    public HttpResult<FieldFeedBack> getFieldFeedback(@ApiParam(name="任务id",value="字符串",required=true) @PathVariable String taskId){
        return fieldFeedbackService.getByTaskId(taskId);
    }
}
