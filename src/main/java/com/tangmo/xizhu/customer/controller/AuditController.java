package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.AuditInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chen bo
 * @Date 2019/10/21
 * @Version V1.0
 * @Description: 审核controller
 **/
@Api(description="审批相关接口")
@RestController
@RequestMapping("/audit")
public class AuditController {
    /**
     * @param auditInfo
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 审批通过
     */
    @ApiOperation(value = "审批通过",httpMethod = "POST",notes = "")
    @PostMapping("/approve")
    public HttpResult approveTask(@ApiParam(name="审批信息对象",value="json格式",required=true) @RequestBody AuditInfo auditInfo){
        return null;
    }

    /**
     * @param auditInfo
     * @return
     * @author chen bo
     * @date 2019/10/21
     * @description: 拒绝通过
     */
    @ApiOperation(value = "审批拒绝",httpMethod = "POST",notes = "")
    @PostMapping("/reject")
    public HttpResult rejectTask(@ApiParam(name="审批信息对象",value="json格式",required=true) @RequestBody AuditInfo auditInfo){
        return null;
    }
}
