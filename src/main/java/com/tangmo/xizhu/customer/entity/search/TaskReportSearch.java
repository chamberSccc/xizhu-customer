package com.tangmo.xizhu.customer.entity.search;

import com.tangmo.xizhu.customer.common.Page;
import lombok.Data;

/**
 * @author boge
 * @date 2019/12/25
 * @description 任务报表搜索对象
 */
@Data
public class TaskReportSearch extends Page {

    private String year;
    private String troubleType;
    private String assemblyType;
    private Byte status; //任务状态
    private String deviceType;

}
