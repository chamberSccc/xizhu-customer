package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.FastFeedBack;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description: 快速服务反馈单controller
 **/
@Api(description="快速服务反馈单接口")
@RestController
@RequestMapping("/fastFeedback")
public class FastFeedbackController extends BaseController {

    /**
     * @param fastFeedBack
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 新增快速服务反馈单
     */
    @ApiOperation(value = "新增快速服务反馈单",httpMethod = "POST",notes = "完成任务时填写")
    @PostMapping("")
    public HttpResult addFeedBack(@ApiParam(name="快速服务反馈单对象",value="json格式",required=true) @RequestBody FastFeedBack fastFeedBack){
        return fastFeedbackService.addFastFeedback(fastFeedBack);
    }

    /**
     * @param fastFeedBack
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 修改快速服务反馈单
     */
    @ApiOperation(value = "修改快速服务反馈单",httpMethod = "PUT",notes = "完成任务时填写")
    @PutMapping("")
    public HttpResult changeFeedBack(@ApiParam(name="快速服务反馈单对象",value="json格式",required=true) @RequestBody FastFeedBack fastFeedBack){
        fastFeedBack.setUpdatedBy(getUserId());
        return fastFeedbackService.changeFastFeedback(fastFeedBack);
    }
}
