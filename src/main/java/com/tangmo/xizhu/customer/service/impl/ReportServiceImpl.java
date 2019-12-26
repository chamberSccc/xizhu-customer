package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.Page;
import com.tangmo.xizhu.customer.constant.TaskStatusConst;
import com.tangmo.xizhu.customer.dao.ReportDao;
import com.tangmo.xizhu.customer.entity.Task;
import com.tangmo.xizhu.customer.entity.search.TaskReportSearch;
import com.tangmo.xizhu.customer.entity.search.UserSearch;
import com.tangmo.xizhu.customer.service.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author boge
 * @date 2019/12/25
 * @description 任务报表实现类
 */
@Service("reportService")
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportDao reportDao;
    @Override
    public HttpResult getTaskReport(TaskReportSearch taskReportSearch) {
        Page page = taskReportSearch;
        page.startPage();
        List<Map<String,Object>> result = reportDao.selectTaskReport(taskReportSearch);
        page.setResult(result);
        return HttpResult.success(page);
    }

    @Override
    public HttpResult getTaskMonthTime(TaskReportSearch taskReportSearch) {
        List<Map<String,Object>> report = reportDao.selectTaskMonthTime(taskReportSearch);
        List<Map<String,Object>> result = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            Map<String,Object> temp = new HashMap<>();
            temp.put("taskMonth",i);
            temp.put("meanTime",0);
            for (int j = 0; j < report.size(); j++) {
                Map<String,Object> map = report.get(j);
                if(map.get("taskMonth").toString().equals(String.valueOf(i))){
                    temp.put("meanTime",map.get("meanTime"));
                    continue;
                }
            }
            result.add(temp);
        }
        return HttpResult.success(result);
    }

    @Override
    public HttpResult getTaskMonthCount(TaskReportSearch taskReportSearch) {
        List<Map<String,Object>> report = reportDao.selectTaskMonthCount(taskReportSearch);
        List<Map<String,Object>> result = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            Map<String,Object> temp = new HashMap<>();
            temp.put("taskMonth",i);
            temp.put("taskCount",0);
            for (int j = 0; j < report.size(); j++) {
                Map<String,Object> map = report.get(j);
                if(map.get("taskMonth").toString().equals(String.valueOf(i))){
                    temp.put("taskCount",map.get("taskCount"));
                    continue;
                }
            }
            result.add(temp);
        }
        return HttpResult.success(result);
    }

    @Override
    public HttpResult getUserState(UserSearch userSearch) {
        Page page = userSearch;
        page.startPage();
        List<Map<String,Object>> result = reportDao.selectUserState(userSearch);
        page.setResult(result);
        return HttpResult.success(page);
    }
}
