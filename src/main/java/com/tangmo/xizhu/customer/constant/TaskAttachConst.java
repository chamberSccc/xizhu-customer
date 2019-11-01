package com.tangmo.xizhu.customer.constant;

/**
 * @Author chen bo
 * @Date 2019/10/24
 * @Version V1.0
 * @Description: 任务附件常量
 **/
public class TaskAttachConst {

    //parentType
    public static final byte REQUIRE_ATTACH = 0;//任务需求单
    public static final byte FAST_FB_ATTACH = 1;//快速服务反馈单
    public static final byte FAST_SURVEY = 2;//快速服务满意度调查表
    public static final byte FIELD_APPLY = 3;//现场申请单
    public static final byte FIELD_ASSIGN = 4;//现场指派单
    public static final byte FIELD_FB = 5;//现场反馈单
    public static final byte EQUIP_APPLY = 6;
    public static final byte EQUIP_CHECK = 6;
    //attachType
    public static final byte PICTURE = 0;

    //areaType
    public static final byte DETAIL = 0;//细节描述
    public static final byte SOLUTION = 1;//快速服务处理方案
    public static final byte RESULT = 2;//现场处理结果
}
