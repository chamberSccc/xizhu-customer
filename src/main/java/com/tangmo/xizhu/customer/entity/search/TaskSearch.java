package com.tangmo.xizhu.customer.entity.search;

import com.tangmo.xizhu.customer.common.Page;
import lombok.Data;

import java.sql.Date;

/**
 * @Author chen bo
 * @Date 2019/10/15
 * @Version V1.0
 * @Description: 任务搜索条件
 **/
@Data
public class TaskSearch extends Page {

    private Date startDate;
    private Date endDate;
    private String companyName;
    private String contractNo;
}
