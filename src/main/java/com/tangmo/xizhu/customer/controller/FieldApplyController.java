package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.FieldApply;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description: 现场服务申请单controller
 **/
@Api(description="现场任务申请人接口")
@RestController
@RequestMapping("/fieldApply")
public class FieldApplyController extends BaseController {

    /**
     * @param fieldApply
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 新增现场服务申请单
     */
    @ApiOperation(value = "新增现场服务申请",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult addFieldApply(@ApiParam(name="现场服务申请表对象",value="json格式",required=true) @RequestBody FieldApply fieldApply){
        fieldApply.setCreatedBy(getUserId());
        return fieldApplyService.addApply(fieldApply);
    }
    /**
     * @param fieldApply
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 修改现场服务申请单
     */
    @ApiOperation(value = "修改现场服务申请",httpMethod = "PUT",notes = "")
    @PutMapping("")
    public HttpResult changeFieldApply(@ApiParam(name="现场服务申请表对象",value="json格式",required=true) @RequestBody FieldApply fieldApply){
        return fieldApplyService.changeApply(fieldApply);
    }
}
