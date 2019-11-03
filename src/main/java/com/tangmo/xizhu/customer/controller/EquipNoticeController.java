package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.OutEquipCheck;
import com.tangmo.xizhu.customer.entity.OutEquipNotice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chen bo
 * @Date 2019/11/3
 * @Version V1.0
 * @Description: 外购件通知单接口
 **/
@Api(description="外购件调试安装通知单接口")
@RestController
@RequestMapping("/equipNotice")
public class EquipNoticeController extends BaseController {

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/1
     * @description: 修改外购件调试安装通知单
     */
    @ApiOperation(value = "修改外购件调试安装通知单",httpMethod = "PUT",notes = "")
    @PutMapping("")
    public HttpResult changeEquipNotice(@ApiParam(name="外购件调试安装通知单对象",value="json格式",required=true) @RequestBody OutEquipNotice outEquipNotice){
        return equipNoticeService.changeOutNotice(outEquipNotice);
    }
}
