package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.FieldApply;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description: 现场服务申请单controller
 **/
@RestController
@RequestMapping("/fieldApply")
public class FieldApplyController extends BaseController{

    /**
     * @param fieldApply
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 新增现场服务申请单
     */
    @PostMapping("")
    public HttpResult addFieldApply(@RequestBody FieldApply fieldApply){
        return fieldApplyService.addApply(fieldApply);
    }
    /**
     * @param fieldApply
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 修改现场服务申请单
     */
    @PutMapping("")
    public HttpResult changeFieldApply(@RequestBody FieldApply fieldApply){
        return fieldApplyService.changeApply(fieldApply);
    }
}
