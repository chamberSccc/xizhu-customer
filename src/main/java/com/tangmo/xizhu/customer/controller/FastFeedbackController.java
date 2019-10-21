package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.FastFeedBack;
import io.swagger.annotations.Api;
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
public class FastFeedbackController extends BaseController{

    /**
     * @param fastFeedBack
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 新增快速服务反馈单
     */
    @PostMapping("")
    public HttpResult addFeedBack(@RequestBody FastFeedBack fastFeedBack){
        return fastFeedbackService.addFastFeedback(fastFeedBack);
    }

    /**
     * @param fastFeedBack
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 修改快速服务反馈单
     */
    @PutMapping("")
    public HttpResult changeFeedBack(@RequestBody FastFeedBack fastFeedBack){
        return fastFeedbackService.changeFastFeedback(fastFeedBack);
    }
}
