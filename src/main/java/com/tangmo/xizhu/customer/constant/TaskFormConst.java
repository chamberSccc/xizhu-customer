package com.tangmo.xizhu.customer.constant;

import com.tangmo.xizhu.customer.entity.TaskForm;

import java.util.ArrayList;

/**
 * @Author chen bo
 * @Date 2019/11/4
 * @Version V1.0
 * @Description: 获取任务所需表单列表
 **/
public class TaskFormConst {

    /**
     * @param taskType
     * @param userType
     * @param troubleType 问题类型
     * @return
     * @author chen bo
     * @date 2019/11/17
     * @description: TODO
     */
    public static ArrayList<TaskForm> getTaskForm(Byte taskType,Byte userType,Byte troubleType){
        ArrayList<TaskForm> list;
        if(taskType == null){
            list = new ArrayList<TaskForm>() {{
                add(new TaskForm(FormNameConst.REQUIRE,false));
            }};
            return list;
        }
        //审核人员
        if(userType.equals(UserTypeConst.AUDIT)){
            //快速服务单子
            if(taskType.equals(TaskTypeConst.FAST_SERVICE)){
                return adminFastForm();
            }
            //现场服务单子
            if(taskType.equals(TaskTypeConst.FIELD_SERVICE)){
                ArrayList<TaskForm> fastList = adminFastForm();
                ArrayList<TaskForm> fieldList = adminFieldForm();
                fastList.addAll(fieldList);
                return fastList;
            }
            //安装调试单子
            if(taskType.equals(TaskTypeConst.EQUIPMENT)){
                return adminEquipForm(troubleType);
            }
            //外购件安装单子
            if(taskType.equals(TaskTypeConst.OUT_EQUIPMENT)){
                ArrayList<TaskForm> equipList = adminEquipForm(troubleType);
                ArrayList<TaskForm> outList = adminOutEquipForm();
                equipList.addAll(outList);
                return equipList;
            }
        }
        if(userType.equals(UserTypeConst.SERVICE)){

        }
        if(userType.equals(UserTypeConst.CUSTOMER)){

        }


        return null;
    }
    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 审核人员可看快速服务单子列表
     */
    public static ArrayList<TaskForm> adminFastForm(){
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.REQUIRE,false));
            add(new TaskForm(FormNameConst.FAST_FB,false));
            add(new TaskForm(FormNameConst.FAST_SURVEY,true));
            add(new TaskForm(FormNameConst.FIELD_APPLY,true));
        }};
        return list;
    }
    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 审核人员可看现场服务单子列表
     */
    public static ArrayList<TaskForm> adminFieldForm(){
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.FIELD_APPLY,true));
            add(new TaskForm(FormNameConst.FIELD_ASSIGN,true));
            add(new TaskForm(FormNameConst.FIELD_FB,true));
        }};
        return list;
    }

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 审核人员可看安装单子列表
     */
    public static ArrayList<TaskForm> adminEquipForm(Byte troubleType){
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.REQUIRE,true));
            add(new TaskForm(FormNameConst.FIELD_ASSIGN,true));
            add(new TaskForm(FormNameConst.SAFE_CONFIDE,true));
            add(new TaskForm(FormNameConst.DEVICE_FILE,true));
        }};
        //区分机械问题和电气问题
        if(troubleType.equals(TroubleTypeConst.ELECTRIC)){
            list.add(new TaskForm(FormNameConst.ELEC_RECORD,true));
        }
        if(troubleType.equals(TroubleTypeConst.MACHINE)){
            list.add(new TaskForm(FormNameConst.MACH_RECORD,true));
        }
        list.add(new TaskForm(FormNameConst.MTAIN_CONFIDE,true));
        list.add(new TaskForm(FormNameConst.EQUIP_APPLY,true));
        return list;
    }

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 审核人员可看外购件单子列表
     */
    public static ArrayList<TaskForm> adminOutEquipForm(){
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.EQUIP_AUDIT,true));
            add(new TaskForm(FormNameConst.EQUIP_CHECK,true));
        }};
        return list;
    }

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 服务人员可看现场服务单子列表
     */
    public static ArrayList<TaskForm> userFastForm(){
        return null;
    }
    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 服务人员可看现场服务单子列表
     */
    public static ArrayList<TaskForm> userFieldForm(){
        return null;
    }

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 服务人员可看安装单子列表
     */
    public static ArrayList<TaskForm> userEquipForm(){
        return null;
    }
    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 服务人员可看外购件单子列表
     */
    public static ArrayList<TaskForm> userOutEquipForm(){
        return null;
    }

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 用户可看快速服务单子列表
     */
    public static ArrayList<TaskForm> cusFastForm(){
        return null;
    }

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 客户可看现场服务单子列表
     */
    public static ArrayList<TaskForm> cusFieldForm(){
        return null;
    }
    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 客户可看安装单子列表
     */
    public static ArrayList<TaskForm> cusEquipForm(){
        return null;
    }

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 客户可看外购件单子列表
     */
    public static ArrayList<TaskForm> cusOutEquipForm(){
        return null;
    }
}
