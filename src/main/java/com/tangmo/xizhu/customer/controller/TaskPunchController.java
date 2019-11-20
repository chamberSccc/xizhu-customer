package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.constant.PunchTypeConst;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.TaskPunch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/11/16
 * @Version V1.0
 * @Description: 任务打卡
 **/
@Api(description="任务打卡接口")
@RestController
@RequestMapping("/punch")
public class TaskPunchController extends BaseController {
    /**
     * @param taskPunch
     * @return
     * @author chen bo
     * @date 2019/11/14
     * @description: 开始打卡
     */
    @ApiOperation(value = "开始打卡",httpMethod = "POST",notes = "")
    @PostMapping("/task/start")
    public HttpResult startPunch(@RequestBody TaskPunch taskPunch){
        taskPunch.setUserId(getUserId());
        return taskPunchService.startPunch(taskPunch);
    }

    /**
     * @param taskPunch
     * @return
     * @author chen bo
     * @date 2019/11/14
     * @description: 结束打卡
     */
    @ApiOperation(value = "结束打卡",httpMethod = "POST",notes = "")
    @PostMapping("/task/end")
    public HttpResult endPunch(@RequestBody TaskPunch taskPunch){
        taskPunch.setUserId(getUserId());
        return taskPunchService.endPunch(taskPunch);
    }

    /**
     * @param taskPunch
     * @return
     * @author chen bo
     * @date 2019/11/14
     * @description: 修改开始打卡记录
     */
    @ApiOperation(value = "修改开始打卡记录",httpMethod = "PUT",notes = "")
    @PutMapping("/task/start")
    public HttpResult changeStartPunch(@RequestBody TaskPunch taskPunch){
        return taskPunchService.changeStartPunch(taskPunch);
    }

    /**
     * @param taskPunch
     * @return
     * @author chen bo
     * @date 2019/11/14
     * @description: 修改结束打卡记录
     */
    @ApiOperation(value = "修改结束打卡记录",httpMethod = "PUT",notes = "")
    @PutMapping("/task/end")
    public HttpResult changeEndPunch(@RequestBody TaskPunch taskPunch){
        return taskPunchService.changeEndPunch(taskPunch);
    }


    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/11/14
     * @description: 开始打卡
     */
    @ApiOperation(value = "获取开始打卡记录",httpMethod = "GET",notes = "")
    @GetMapping("/task/{taskId}/start")
    public HttpResult getStartPunch(@PathVariable String taskId){
        return taskPunchService.getUserPunch(taskId,getUserId(), PunchTypeConst.OnDuty);
    }

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/11/14
     * @description: 结束打卡
     */
    @ApiOperation(value = "获取结束打卡记录",httpMethod = "GET",notes = "")
    @GetMapping("/task/{taskId}/end")
    public HttpResult getEndPunch(@PathVariable String taskId){
        return taskPunchService.getUserPunch(taskId,getUserId(), PunchTypeConst.OffDuty);
    }
}
