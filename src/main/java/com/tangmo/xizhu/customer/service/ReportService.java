package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.search.TaskReportSearch;

/**
 * @author boge
 * @date 2019/12/25
 * @description 报表service
 */

public interface ReportService {

    /**
     * 任务查询
     * @param taskReportSearch
     * @return
     */
    HttpResult getTaskReport(TaskReportSearch taskReportSearch);

    /**
     * 月份完成时间报表
     * @param taskReportSearch
     * @return
     */
    HttpResult getTaskMonthTime(TaskReportSearch taskReportSearch);

    /**
     * 月份报表
     * @param taskReportSearch
     * @return
     */
    HttpResult getTaskMonthCount(TaskReportSearch taskReportSearch);
}
