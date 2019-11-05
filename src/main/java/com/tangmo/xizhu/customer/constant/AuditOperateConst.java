package com.tangmo.xizhu.customer.constant;

/**
 * @Author chen bo
 * @Date 2019/10/21
 * @Version V1.0
 * @Description: 审核相关操作状态
 **/
public class AuditOperateConst {
    public static final byte REJECT = -1;// 拒绝任务
    public static final byte INITIAL = 0;// 发起任务
    public static final byte ASSIGN = 1;// 审核任务
    public static final byte TASK_COMPLETE = 2;// 提交任务
    public static final byte COMPLETE = 3;// 标记完成
}
