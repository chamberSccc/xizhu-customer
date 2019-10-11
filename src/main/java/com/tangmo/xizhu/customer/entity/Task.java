package com.tangmo.xizhu.customer.entity;

import lombok.Data;

@Data
public class Task {

    //单位信息
    private Integer companyId;

    private Integer deviceProblem;

    private String detail;
}
