package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.constant.CheckTypeConst;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.DailyCheck;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2020/1/15
 * @Version V1.0
 * @Description:
 **/
@Api(description="考勤接口")
@RestController
@RequestMapping("/check")
public class DailyCheckController extends BaseController {

    /**
     * @param dailyCheck
     * @return
     * @author chen bo
     * @date 2020/1/15
     * @description: 请假考勤
     */
    @ApiOperation(value = "请假考勤",httpMethod = "POST",notes = "")
    @PostMapping("/leave")
    public HttpResult leaveCheck(@RequestBody DailyCheck dailyCheck){
        dailyCheck.setCheckType(CheckTypeConst.leave);
        dailyCheck.setUserId(getUserId());
        return dailyCheckService.addDailyPunch(dailyCheck);
    }

    /**
     * @param dailyCheck
     * @return
     * @author chen bo
     * @date 2020/1/15
     * @description: 出差考勤
     */
    @ApiOperation(value = "出差考勤",httpMethod = "POST",notes = "")
    @PostMapping("/business")
    public HttpResult bizCheck(@RequestBody DailyCheck dailyCheck){
        dailyCheck.setCheckType(CheckTypeConst.business);
        dailyCheck.setUserId(getUserId());
        return dailyCheckService.addDailyPunch(dailyCheck);
    }

    /**
     * @param dailyCheck
     * @return
     * @author chen bo
     * @date 2020/1/15
     * @description: 待出差考勤
     */
    @ApiOperation(value = "待出差考勤",httpMethod = "POST",notes = "")
    @PostMapping("/waiting")
    public HttpResult waitCheck(@RequestBody DailyCheck dailyCheck){
        dailyCheck.setCheckType(CheckTypeConst.waiting);
        dailyCheck.setUserId(getUserId());
        return dailyCheckService.addDailyPunch(dailyCheck);
    }

    /**
     * @param dailyCheck
     * @return
     * @author chen bo
     * @date 2020/1/15
     * @description: 正常考勤
     */
    @ApiOperation(value = "正常考勤",httpMethod = "POST",notes = "")
    @PostMapping("/common")
    public HttpResult commonCheck(@RequestBody DailyCheck dailyCheck){
        dailyCheck.setCheckType(CheckTypeConst.common);
        dailyCheck.setUserId(getUserId());
        return dailyCheckService.addDailyPunch(dailyCheck);
    }

    /**
     * @param dailyCheck
     * @return
     * @author chen bo
     * @date 2020/1/15
     * @description: 出国考勤
     */
    @ApiOperation(value = "出国考勤",httpMethod = "POST",notes = "")
    @PostMapping("/abroad")
    public HttpResult abroadCheck(@RequestBody DailyCheck dailyCheck){
        dailyCheck.setCheckType(CheckTypeConst.abroad);
        dailyCheck.setUserId(getUserId());
        return dailyCheckService.addDailyPunch(dailyCheck);
    }

    @ApiOperation(value = "获取每种考勤数量",httpMethod = "GET",notes = "")
    @GetMapping("/user/monthCount")
    public HttpResult getMonthCount(){
        String userId = getUserId();
        return dailyCheckService.getMonthCount(userId);
    }

    @ApiOperation(value = "获取人员考勤历史记录",httpMethod = "GET",notes = "")
    @GetMapping("/user/{userId}/history")
    public HttpResult getUserCheckHistory(@PathVariable String userId){
        return null;
    }
}
