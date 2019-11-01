package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.OutEquipApply;
import com.tangmo.xizhu.customer.entity.OutEquipAudit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/11/1
 * @Version V1.0
 * @Description: 外购件调试安装审批接口
 **/
@Api(description="外购件调试安装审批接口")
@RestController
@RequestMapping("/equipAudit")
public class EquipAuditController extends BaseController {

    /**
     * @param outEquipAudit
     * @return
     * @author chen bo
     * @date 2019/11/1
     * @description: 新增外购件安装调试审批
     */
    @ApiOperation(value = "新增外购件调试安装审批",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult addEquipAudit(@ApiParam(name="外购件调试安装审批表对象",value="json格式",required=true) @RequestBody OutEquipAudit outEquipAudit){
        outEquipAudit.setCreatedBy(getUserId());
        return equipAuditService.addOutAudit(outEquipAudit);
    }

    /**
     * @param outEquipAudit
     * @return
     * @author chen bo
     * @date 2019/11/1
     * @description: 修改外购件安装调试审批
     */
    @ApiOperation(value = "修改外购件调试安装审批",httpMethod = "PUT",notes = "")
    @PutMapping("")
    public HttpResult changeEquipAudit(@ApiParam(name="外购件调试安装申请表对象",value="json格式",required=true) @RequestBody OutEquipAudit outEquipAudit){
        outEquipAudit.setCreatedBy(getUserId());
        return equipAuditService.changeOutAudit(outEquipAudit);
    }
}
