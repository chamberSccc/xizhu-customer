package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.FastSurvey;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description:
 **/
@RestController
@RequestMapping("/fastSurvey")
public class FastSurveyController extends BaseController{
    /**
     * @param fastSurvey
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 新增快速服务满意度调查表
     */
    @PostMapping("")
    public HttpResult addFastSurvey(@RequestBody FastSurvey fastSurvey){
        return fastSurveyService.addSurvey(fastSurvey);
    }

    /**
     * @param fastSurvey
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 修改快速服务满意度调查表
     */
    public HttpResult changeFastSurvey(@RequestBody FastSurvey fastSurvey){
        return fastSurveyService.changeSurvey(fastSurvey);
    }
}
