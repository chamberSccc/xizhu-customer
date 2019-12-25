package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boge
 * @date 2019/12/25
 * @description
 */
@Api(description="任务报表接口")
@RestController
@RequestMapping("/task/report")
public class TaskReportController {

    //查询任务  已完成,未完成,   问题类型,   总成类型  划分  设备型号

    //查询任务统计数量  设备型号  问题类型  总成类型  年份

    //查询任务平均处理时间

    public HttpResult getTaskReport(){
        return null;
    }

    public HttpResult getTaskMonthTime(){
        return null;
    }

    public HttpResult getTaskMonthCount(){
        return null;
    }

}
