package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.FieldFeedBack;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description: 现场服务反馈单controller
 **/
@Api(description="现场服务反馈单接口")
@RestController
@RequestMapping("/fieldFeedback")
public class FieldFeedbackController extends BaseController{

    /**
     * @param fieldFeedBack
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 增加现场服务反馈单
     */
    public HttpResult addFeedback(@ApiParam(name="现场服务反馈单对象",value="json格式",required=true) @RequestBody FieldFeedBack fieldFeedBack){
        return fieldFeedbackService.addFeedback(fieldFeedBack);
    }

    /**
     * @param fieldFeedBack
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 修改快速服务反馈单
     */
    public HttpResult changeFeedback(@ApiParam(name="现场服务反馈单对象",value="json格式",required=true) @RequestBody FieldFeedBack fieldFeedBack){
        return fieldFeedbackService.changeFeedback(fieldFeedBack);
    }
}
