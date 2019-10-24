package com.tangmo.xizhu.customer.constant;

/**
 * @Author chen bo
 * @Date 2019/10/17
 * @Version V1.0
 * @Description: 任务状态
 **/
public class TaskStatusConst {

    public static final byte REJECT = -1;// 已拒绝
    public static final byte INITIAL = 0;//已发布，审核中
    public static final byte DEALING = 1;//已审核，进行中
    public static final byte COMPLETE = 2;//已完成
}
