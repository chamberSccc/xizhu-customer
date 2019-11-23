package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.EquipSurvey;
import com.tangmo.xizhu.customer.entity.FieldSurvey;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/11/21
 * @Version V1.0
 * @Description: 售后服务满意度调查表controller
 **/
@Api(description="安调服务满意度调查表")
@RestController
@RequestMapping("/fieldSurvey")
public class FieldSurveyController extends BaseController {
    /**
     * @param fieldSurvey
     * @return
     * @author chen bo
     * @date 2019/11/21
     * @description: 新增售后服务满意度调查表
     */
    @ApiOperation(value = "新增售后服务满意度调查表",httpMethod = "POST",notes = "")
    @PostMapping("")
    public HttpResult addFieldSurvey(@RequestBody FieldSurvey fieldSurvey){
        return fieldSurveyService.addSurvey(fieldSurvey);
    }
    /**
     * @param fieldSurvey
     * @return
     * @author chen bo
     * @date 2019/11/21
     * @description: 修改售后服务满意度调查表
     */
    @ApiOperation(value = "修改售后服务满意度调查表",httpMethod = "PUT",notes = "")
    @PutMapping("")
    public HttpResult changeFieldSurvey(@RequestBody FieldSurvey fieldSurvey){
        return fieldSurveyService.changeSurvey(fieldSurvey);
    }
}
