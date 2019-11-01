package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.OutEquipApply;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chen bo
 * @Date 2019/11/1
 * @Version V1.0
 * @Description: 外购件调试安装申请接口
 **/
@Api(description="外购件调试安装申请接口")
@RestController
@RequestMapping("/equipApply")
public class EquipApplyController extends BaseController {

    /**
     * @param outEquipApply
     * @return
     * @author chen bo
     * @date 2019/11/1
     * @description: 新增外购件安装调试申请
     */
    @ApiOperation(value = "新增外购件调试安装申请",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult addEquipApply(@ApiParam(name="外购件调试安装申请表对象",value="json格式",required=true) @RequestBody OutEquipApply outEquipApply){
        outEquipApply.setCreatedBy(getUserId());
        return equipApplyService.addOutApply(outEquipApply);
    }
}
