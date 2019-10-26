package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.ElecRecord;
import com.tangmo.xizhu.customer.entity.MaintainConfide;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chen bo
 * @Date 2019/10/22
 * @Version V1.0
 * @Description: 沥青混合料搅拌设备维护保养交底表接口
 **/
@Api(description="沥青混合料搅拌设备维护保养交底表接口")
@RestController
@RequestMapping("/maintainConfide")
public class MtainConfideController extends BaseController {

    /**
     * @param maintainConfide
     * @return
     * @author chen bo
     * @date 2019/10/22
     * @description: 新增保养交底表
     */
    @ApiOperation(value = "新增保养交底表(11种类型按1-11区分)",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult addMaintainConfide(@ApiParam(name="安装工作记录(电气)表对象",value="json格式",required=true) @RequestBody MaintainConfide maintainConfide){
        return mtainConfideService.addMtainConfide(maintainConfide);
    }
    /**
     * @param maintainConfide
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 修改保养交底表
     */
    @ApiOperation(value = "修改保养交底表(11种类型按1-11区分)",httpMethod = "PUT",notes = "")
    public HttpResult changeConfide(@ApiParam(name="安装工作记录(电气)表对象",value="json格式",required=true) @RequestBody MaintainConfide maintainConfide){
        return mtainConfideService.changeMtainConfide(maintainConfide);
    }
}
