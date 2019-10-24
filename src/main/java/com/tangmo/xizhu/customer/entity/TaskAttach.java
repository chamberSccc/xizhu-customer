package com.tangmo.xizhu.customer.entity;

import lombok.Data;

/**
 * @Author chen bo
 * @Date 2019/10/24
 * @Version V1.0
 * @Description: 任务附件
 **/
@Data
public class TaskAttach {
    private String parentId;
    private String attachId;
    //0：任务需求单
    private Byte parentType;
    //0: 图片
    private Byte attachType;
    //0:细节 1:快速服务处理方案
    private Byte areaType;
}
