package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.search.TaskReportSearch;
import com.tangmo.xizhu.customer.entity.search.UserSearch;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boge
 * @date 2019/12/25
 * @description
 */
@Api(description="任务报表接口")
@RestController
@RequestMapping("/report")
public class TaskReportController extends BaseController {

    //查询任务  已完成,未完成,   问题类型,   总成类型    设备型号

    //查询任务统计数量  设备型号  问题类型  总成类型  年份

    //查询任务平均处理时间
    /**
     * @param taskReportSearch
     * @return
     * @author chen bo
     * @date 2019/12/26
     * @description: 查询任务统计数量
     */
    @PostMapping("/task/month/count")
    public HttpResult getTaskMonthCount(TaskReportSearch taskReportSearch){
        return reportService.getTaskMonthCount(taskReportSearch);
    }

    /**
     * @param taskReportSearch
     * @return
     * @author chen bo
     * @date 2019/12/26
     * @description: 查询任务统计时间
     */
    @PostMapping("/task/month/time")
    public HttpResult getTaskMonthTime(TaskReportSearch taskReportSearch){
        return reportService.getTaskMonthTime(taskReportSearch);
    }

    /**
     * @param taskReportSearch
     * @return
     * @author chen bo
     * @date 2019/12/26
     * @description: 查询任务报表
     */
    @PostMapping("/task")
    public HttpResult getTaskReport(TaskReportSearch taskReportSearch){
        return reportService.getTaskReport(taskReportSearch);
    }
    /**
     * @param userSearch
     * @return
     * @author chen bo
     * @date 2019/12/26
     * @description: 查询人员任务报表
     */
    @PostMapping("/user/state")
    public HttpResult getUserState(UserSearch userSearch){
        return reportService.getUserState(userSearch);
    }

}
