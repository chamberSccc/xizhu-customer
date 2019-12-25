package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.search.TaskReportSearch;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author boge
 * @date 2019/12/25
 * @description
 */
@Repository
public interface ReportDao {
    /**
     * 查询任务月份统计报表
     * @param taskReportSearch
     * @return
     */
    List<Map<String,Object>> selectTaskMonthCount(TaskReportSearch taskReportSearch);

    /**
     * 查询任务报表
     * @param taskReportSearch
     * @return
     */
    List<Map<String,Object>> selectTaskReport(TaskReportSearch taskReportSearch);

    /**
     * 查询任务月份平均完成时间
     * @param taskReportSearch
     * @return
     */
    List<Map<String,Object>> selectTaskMonthTime(TaskReportSearch taskReportSearch);

    /**
     * 查询人员状态
     * @param taskReportSearch
     * @return
     */
    List<Map<String,Object>> selectUserState(TaskReportSearch taskReportSearch);
}
