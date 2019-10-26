package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.*;
import com.tangmo.xizhu.customer.entity.search.TaskSearch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chen bo
 * @Date 2019/10/17
 * @Version V1.0
 * @Description: 任务controller
 **/
@Api(description="任务相关接口")
@RestController
@RequestMapping("/task")
public class TaskController extends BaseController {

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
        task.setCreatedBy(getUserId());
        return taskService.createTask(task);
    }
    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 查询任务详情
     */
    @ApiOperation(value = "获取任务详情",httpMethod = "GET",notes = "")
    @GetMapping("/{taskId}")
    public HttpResult getTaskDetail(@PathVariable String taskId){
        List<AuditTask> auditFlowList = (List<AuditTask>) auditTaskService.getAuditFlowList(taskId).getData();
        Task taskDetail = (Task) taskService.getTaskDetail(taskId).getData();
        Map<String,Object> map = new HashMap<>();
        map.put("task",taskDetail);
        map.put("audit",auditFlowList);
        return HttpResult.success(map);
    }

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 提交任务
     */
    @ApiOperation(value = "提交任务",httpMethod = "POST",notes = "")
    @PutMapping("/commit/{taskId}")
    public HttpResult commitTask(@PathVariable String taskId){
        return null;
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
    public HttpResult<FieldFeedBack> getFieldFeedback(@PathVariable String taskId){
        return fieldFeedbackService.getByTaskId(taskId);
    }

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/22
     * @description: 获取任务的安全交底表
     */
    @ApiOperation(value = "获取任务的安全交底表",httpMethod = "GET",notes = "")
    @GetMapping("/{taskId}/safeConfide")
    public HttpResult<SafeConfide>  getSafeConfide(@PathVariable String taskId){
        return safeConfideService.getByTaskId(taskId);
    }
    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/22
     * @description: 获取任务的设备档案
     */
    @ApiOperation(value = "获取任务的设备档案",httpMethod = "GET",notes = "")
    @GetMapping("/{taskId}/deviceFile")
    public HttpResult<DeviceFile> getDeviceFile(@PathVariable String taskId){
        return deviceFileService.getByTaskId(taskId);
    }

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/22
     * @description: 获取安装工作记录(机械)
     */
    @ApiOperation(value = "获取安装工作记录(机械)",httpMethod = "GET",notes = "")
    @GetMapping("/{taskId}/machineRecord")
    public HttpResult<MachRecord> getMachineRecord(@PathVariable String taskId){
        return machRecordService.getByTaskId(taskId);
    }
    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/22
     * @description: 获取安装工作记录(电气)
     */
    @ApiOperation(value = "获取安装工作记录(电气)",httpMethod = "GET",notes = "")
    @GetMapping("/{taskId}/elecRecord")
    public HttpResult<ElecRecord> getElecRecord(@PathVariable String taskId){
        return elecRecordService.getByTaskId(taskId);
    }

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/22
     * @description: 获取沥青混合料搅拌设备维护保养交底表(1-11)
     */
    @ApiOperation(value = "获取沥青混合料搅拌设备维护保养交底表(1-11)",httpMethod = "GET",notes = "")
    @GetMapping("/{taskId}/maintainConfide/{formType}")
    public HttpResult<MaintainConfide> getMaintainConfide(@PathVariable String taskId,@PathVariable Byte formType){
        return getMaintainConfide(taskId,formType);
    }
}
