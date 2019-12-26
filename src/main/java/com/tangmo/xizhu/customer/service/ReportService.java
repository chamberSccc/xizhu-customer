package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.search.TaskReportSearch;
import com.tangmo.xizhu.customer.entity.search.UserSearch;

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

    /**
     * @param userSearch
     * @return
     * @author chen bo
     * @date 2019/12/26
     * @description: 人员状态
     */
    HttpResult getUserState(UserSearch userSearch);
}
