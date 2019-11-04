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

    public static ArrayList<TaskForm> getTaskForm(Byte taskType,Byte userType){
        ArrayList<TaskForm> list;
        if(taskType == null){
            list = new ArrayList<TaskForm>() {{
                add(new TaskForm(FormNameConst.REQUIRE,false));
            }};
            return list;
        }
        if(taskType.equals(TaskTypeConst.FAST_SERVICE)){
            return adminFastForm();
        }
        if(taskType.equals(TaskTypeConst.FIELD_SERVICE)){
            return adminFieldForm();
        }
        if(taskType.equals(TaskTypeConst.EQUIPMENT)){
            return adminEquipForm();
        }
        if(taskType.equals(TaskTypeConst.OUT_EQUIPMENT)){
            return adminOutEquipForm();
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
        ArrayList<TaskForm> fastList = adminFastForm();
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.FIELD_ASSIGN,true));
            add(new TaskForm(FormNameConst.FIELD_FB,true));
        }};
        fastList.addAll(list);
        return fastList;
    }

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 审核人员可看安装单子列表
     */
    public static ArrayList<TaskForm> adminEquipForm(){
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.REQUIRE,true));
            add(new TaskForm(FormNameConst.FIELD_ASSIGN,true));
            add(new TaskForm(FormNameConst.SAFE_CONFIDE,true));
            add(new TaskForm(FormNameConst.DEVICE_FILE,true));
            add(new TaskForm(FormNameConst.MACH_RECORD,true));
            add(new TaskForm(FormNameConst.ELEC_RECORD,true));
            add(new TaskForm(FormNameConst.MTAIN_CONFIDE,true));
            add(new TaskForm(FormNameConst.EQUIP_APPLY,true));
        }};
        return null;
    }

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 审核人员可看外购件单子列表
     */
    public static ArrayList<TaskForm> adminOutEquipForm(){
        ArrayList<TaskForm> fastList = adminEquipForm();
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.EQUIP_AUDIT,true));
            add(new TaskForm(FormNameConst.EQUIP_CHECK,true));
            add(new TaskForm(FormNameConst.EQUIP_NOTICE,true));
        }};
        return null;
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
