package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.FastSurvey;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description:
 **/
@Api(description="快速服务满意度调查表接口")
@RestController
@RequestMapping("/fastSurvey")
public class FastSurveyController extends BaseController {
    /**
     * @param fastSurvey
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 新增快速服务满意度调查表
     */
    @ApiOperation(value = "新增快速服务满意度调查表",httpMethod = "POST",notes = "完成任务时填写")
    @PostMapping("")
    public HttpResult addFastSurvey(@ApiParam(name="满意度调查表对象",value="json格式",required=true) @RequestBody FastSurvey fastSurvey){
        return fastSurveyService.addSurvey(fastSurvey);
    }

    /**
     * @param fastSurvey
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 修改快速服务满意度调查表
     */
    @ApiOperation(value = "修改快速服务满意度调查表",httpMethod = "PUT",notes = "完成任务时填写")
    @PutMapping("")
    public HttpResult changeFastSurvey(@ApiParam(name="满意度调查表对象",value="json格式",required=true) @RequestBody FastSurvey fastSurvey){
        fastSurvey.setUpdatedBy(getUserId());
        return fastSurveyService.changeSurvey(fastSurvey);
    }
}
