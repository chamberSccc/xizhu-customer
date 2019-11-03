package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.OutEquipAudit;
import com.tangmo.xizhu.customer.entity.OutEquipCheck;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/11/1
 * @Version V1.0
 * @Description: 外购件调试安装验收单接口
 **/
@Api(description="外购件调试安装验收单接口")
@RestController
@RequestMapping("/equipCheck")
public class EquipCheckController extends BaseController {

    /**
     * @param outEquipCheck
     * @return
     * @author chen bo
     * @date 2019/11/1
     * @description: 新增外购件安装调试验收单
     */
    @ApiOperation(value = "新增外购件调试安装验收单",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult addEquipAudit(@ApiParam(name="外购件调试安装验收单对象",value="json格式",required=true) @RequestBody OutEquipCheck outEquipCheck){
        outEquipCheck.setCreatedBy(getUserId());
        return equipCheckService.addOutCheck(outEquipCheck);
    }

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/1
     * @description: 修改外购件调试安装验收单
     */
    @ApiOperation(value = "修改外购件调试安装验收单",httpMethod = "PUT",notes = "")
    @PutMapping("")
    public HttpResult changeEquipCheck(@ApiParam(name="外购件调试安装验收单对象",value="json格式",required=true) @RequestBody OutEquipCheck outEquipCheck){
        return equipCheckService.changeOutCheck(outEquipCheck);
    }
}
