package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author chen bo
 * @Date 2019/10/24
 * @Version V1.0
 * @Description: 部门信息
 **/
@Data
public class Department {

    private String uuid;
    @ApiModelProperty(value="部门名称",name="deptName",example="")
    private String deptName;
    private String createdBy;
    private String createdTime;
    @ApiModelProperty(value="部门关联的任务类型",name="deptName",example="")
    private String taskType;//快速服务是0 现场服务2  安调设备1  外购件3
}
