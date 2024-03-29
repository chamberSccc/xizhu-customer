package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.constant.UserTypeConst;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.AuditTask;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.search.TaskSearch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/21
 * @Version V1.0
 * @Description: 审核controller
 **/
@Api(description="审批操作接口")
@RestController
@RequestMapping("/audit")
public class AuditTaskController extends BaseController {
    /**
     * @param auditTask
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 分派任务
     */
    @ApiOperation(value = "分派任务",httpMethod = "POST",notes = "")
    @PostMapping("/assign")
    public HttpResult assignTask(@ApiParam(name="审批信息对象",value="json格式",required=true) @RequestBody AuditTask auditTask){
        auditTask.setCreatedBy(getUserId());
        return auditTaskService.assignTask(auditTask);
    }

    /**
     * @param auditTask
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 审批拒绝
     */
    @ApiOperation(value = "审批拒绝",httpMethod = "POST",notes = "")
    @PostMapping("/reject")
    public HttpResult rejectTask(@ApiParam(name="审批信息对象",value="json格式",required=true) @RequestBody AuditTask auditTask){
        auditTask.setCreatedBy(getUserId());
        return auditTaskService.rejectTask(auditTask);
    }

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 标记完成
     */
    @ApiOperation(value = "标记完成",httpMethod = "PUT",notes = "")
    @PutMapping("/{taskId}/finish")
    public HttpResult finishTask(@ApiParam(name="审批信息对象",value="json格式",required=true)@PathVariable String taskId){
        AuditTask auditTask = new AuditTask();
        auditTask.setTaskId(taskId);
        auditTask.setCreatedBy(getUserId());
        return auditTaskService.finishTask(auditTask);
    }

    /**
     * @param taskSearch
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 获取已审核列表
     */
    @ApiOperation(value = "获取已审批列表,分页",httpMethod = "POST",notes = "带分页")
    @PostMapping("/list/done")
    public HttpResult<List<Task>> getDoneAudit(TaskSearch taskSearch){
        if(getUserType() != UserTypeConst.AUDIT){
            return HttpResult.success();
        }
        return auditTaskService.getDoneAuditList(getUserId(),taskSearch);
    }

    /**
     * @param taskSearch
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 获取待审批列表
     */
    @ApiOperation(value = "获取待审批列表,分页",httpMethod = "POST",notes = "带分页")
    @PostMapping("/list/undo")
    public HttpResult<List<Task>> getUndoAudit(TaskSearch taskSearch){
        if(getUserType() != UserTypeConst.AUDIT){
            return HttpResult.success();
        }
        return auditTaskService.getUndoAuditList(getUserId(),taskSearch);
    }

    /**
     * @param taskSearch
     * @return
     * @author chen bo
     * @date 2019/10/25
     * @description: 获取已拒绝列表
     */
    @ApiOperation(value = "获取已拒绝列表,分页",httpMethod = "POST",notes = "带分页")
    @PostMapping("/list/reject")
    public HttpResult<List<Task>> getRejectAudit(TaskSearch taskSearch){
        if(getUserType() != UserTypeConst.AUDIT){
            return HttpResult.success();
        }
        return auditTaskService.getRejectAuditList(getUserId(),taskSearch);
    }
}
