package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.constant.UserTypeConst;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description="主页相关接口")
@RestController
@RequestMapping("/home")
public class HomeController extends BaseController {

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 查询未完成任务数量
     */
    @ApiOperation(value = "查询未完成任务数量",httpMethod = "GET",notes = "")
    @GetMapping("/task/undo/count")
    public HttpResult<Integer> getUndoCount(){
        return taskService.getUndoTaskCount(getUserId());
    }

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 查询未审批任务数量
     */
    @ApiOperation(value = "查询未审批任务数量",httpMethod = "GET",notes = "")
    @GetMapping("/audit/undo/count")
    public HttpResult<Integer> getUndoAudit(){
        if(getUserType() != UserTypeConst.AUDIT){
            return HttpResult.success(0);
        }
        return taskService.getUnauditCount(getDeptId());
    }
}
