package com.tangmo.xizhu.customer.entity.search;

import com.tangmo.xizhu.customer.common.Page;
import lombok.Data;

/**
 * @Author chen bo
 * @Date 2019/11/2
 * @Version V1.0
 * @Description: 部门搜索对象
 **/
@Data
public class DeptSearch extends Page {
    private String deptName;
}
