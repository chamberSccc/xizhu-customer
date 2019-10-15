package com.tangmo.xizhu.customer.entity.search;

import lombok.Data;

import java.sql.Date;

/**
 * @Author chen bo
 * @Date 2019/10/15
 * @Version V1.0
 * @Description: 任务搜索条件
 **/
@Data
public class TaskSearch {
    private Date startDate;
    private String companyName;
    private String contractNo;
}
