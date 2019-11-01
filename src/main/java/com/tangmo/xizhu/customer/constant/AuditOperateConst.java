package com.tangmo.xizhu.customer.constant;

/**
 * @Author chen bo
 * @Date 2019/10/21
 * @Version V1.0
 * @Description: 审核相关操作状态
 **/
public class AuditOperateConst {
    public static final byte REJECT = -1;// 拒绝
    public static final byte INITIAL = 0;// 发起
    public static final byte ASSIGN = 1;// 分配
    public static final byte COMPLETE = 2;// 标记完成
}
