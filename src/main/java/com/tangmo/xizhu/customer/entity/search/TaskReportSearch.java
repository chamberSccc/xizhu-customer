package com.tangmo.xizhu.customer.entity.search;

import lombok.Data;

/**
 * @author boge
 * @date 2019/12/25
 * @description 任务报表搜索对象
 */
@Data
public class TaskReportSearch {

    private String year;
    private Byte State;
    private String troubleType;
    private String assemblyType;
}
