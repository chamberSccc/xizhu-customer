package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.FieldAssign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description: 现场服务指派单controller
 **/
@Api(description="现场任务指派单接口")
@RestController
@RequestMapping("/fieldAssign")
public class FieldAssignController extends BaseController {

    /**
     * @param fieldAssign
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 新增现场服务指派单
     */
    @ApiOperation(value = "新增现场服务指派单",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult addFieldAssign(@ApiParam(name="现场服务申请表对象",value="json格式",required=true) @RequestBody FieldAssign fieldAssign){
        return fieldAssignService.addFieldAssign(fieldAssign);
    }

    /**
     * @param fieldAssign
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 修改现场服务指派单
     */
    @ApiOperation(value = "修改现场服务指派单",httpMethod = "PUT",notes = "")
    @PutMapping("")
    public HttpResult changeAssign(@ApiParam(name="现场服务申请表对象",value="json格式",required=true) @RequestBody FieldAssign fieldAssign){
        return fieldAssignService.changeFieldAssign(fieldAssign);
    }

}
