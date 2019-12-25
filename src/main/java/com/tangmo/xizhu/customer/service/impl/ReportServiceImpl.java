package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.search.TaskReportSearch;
import com.tangmo.xizhu.customer.service.ReportService;
import org.springframework.stereotype.Service;

/**
 * @author boge
 * @date 2019/12/25
 * @description 任务报表实现类
 */
@Service("reportService")
public class ReportServiceImpl implements ReportService {
    @Override
    public HttpResult getTaskReport(TaskReportSearch taskReportSearch) {
        return null;
    }

    @Override
    public HttpResult getTaskMonthTime(TaskReportSearch taskReportSearch) {
        return null;
    }

    @Override
    public HttpResult getTaskMonthCount(TaskReportSearch taskReportSearch) {
        return null;
    }
}
