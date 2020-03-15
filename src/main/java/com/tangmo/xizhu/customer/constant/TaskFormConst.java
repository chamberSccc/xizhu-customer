package com.tangmo.xizhu.customer.constant;

import com.tangmo.xizhu.customer.entity.FormState;
import com.tangmo.xizhu.customer.entity.TaskForm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/11/4
 * @Version V1.0
 * @Description: 获取任务所需表单列表
 **/
public class TaskFormConst {

    /**
     * @param list
     * @param formState
     * @return
     * @author chen bo
     * @date 2019/12/21
     * @description: 给表单添加是否填写完成的状态
     */
    public static void changeState(List<TaskForm> list, FormState formState){
        if(formState == null || list == null){
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            TaskForm taskForm = list.get(i);
            if(taskForm.getFormName().equals(FormNameConst.FAST_FB)){
                if(formState.getForm02() != null && formState.getForm02() == true){
                    taskForm.setDoneState(true);
                }
                continue;
            }
            if(taskForm.getFormName().equals(FormNameConst.FAST_SURVEY)){
                if(formState.getForm03() != null && formState.getForm03() == true){
                    taskForm.setDoneState(true);
                }
                continue;
            }
            if(taskForm.getFormName().equals(FormNameConst.FIELD_APPLY)){
                if(formState.getForm04() != null && formState.getForm04() == true){
                    taskForm.setDoneState(true);
                }
                continue;
            }
            if(taskForm.getFormName().equals(FormNameConst.FIELD_ASSIGN)){
                if(formState.getForm05() != null && formState.getForm05() == true){
                    taskForm.setDoneState(true);
                }
                continue;
            }
            if(taskForm.getFormName().equals(FormNameConst.FIELD_FB)){
                if(formState.getForm06() != null && formState.getForm06() == true){
                    taskForm.setDoneState(true);
                }
                continue;
            }
            if(taskForm.getFormName().equals(FormNameConst.FIELD_SURVEY)){
                if(formState.getForm07() != null && formState.getForm07() == true){
                    taskForm.setDoneState(true);
                }
                continue;
            }
            if(taskForm.getFormName().equals(FormNameConst.SAFE_CONFIDE)){
                if(formState.getForm08() != null && formState.getForm08() == true){
                    taskForm.setDoneState(true);
                }
                continue;
            }
            if(taskForm.getFormName().equals(FormNameConst.DEVICE_FILE)){
                if(formState.getForm09() != null && formState.getForm09() == true){
                    taskForm.setDoneState(true);
                }
                continue;
            }
            if(taskForm.getFormName().equals(FormNameConst.MACH_RECORD)){
                if(formState.getForm10() != null && formState.getForm10() == true){
                    taskForm.setDoneState(true);
                }
                continue;
            }
            if(taskForm.getFormName().equals(FormNameConst.ELEC_RECORD)){
                if(formState.getForm11() != null && formState.getForm11() == true){
                    taskForm.setDoneState(true);
                }
                continue;
            }
            if(taskForm.getFormName().equals(FormNameConst.MTAIN_CONFIDE)){
                if(formState.getForm12() != null && formState.getForm12() == true){
                    taskForm.setDoneState(true);
                }
                continue;
            }
            if(taskForm.getFormName().equals(FormNameConst.EQUIP_APPLY)){
                if(formState.getForm13() != null && formState.getForm13() == true){
                    taskForm.setDoneState(true);
                }
                continue;
            }
            if(taskForm.getFormName().equals(FormNameConst.EQUIP_AUDIT)){
                if(formState.getForm14() != null && formState.getForm14() == true){
                    taskForm.setDoneState(true);
                }
                continue;
            }
            if(taskForm.getFormName().equals(FormNameConst.EQUIP_CHECK)){
                if(formState.getForm15() != null && formState.getForm15() == true){
                    taskForm.setDoneState(true);
                }
                continue;
            }
            if(taskForm.getFormName().equals(FormNameConst.EQUIP_SURVEY)){
                if(formState.getForm16() != null && formState.getForm16() == true){
                    taskForm.setDoneState(true);
                }
                continue;
            }
        }
    }
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
                add(new TaskForm(FormNameConst.REQUIRE,false,true));
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
                ArrayList<TaskForm> fieldList = adminFieldForm();
                return fieldList;
            }
            //安装调试单子
            if(taskType.equals(TaskTypeConst.EQUIPMENT)){
                return adminEquipForm(troubleType);
            }
            //外购件安装单子
            if(taskType.equals(TaskTypeConst.OUT_EQUIPMENT)){
                ArrayList<TaskForm> outList = adminOutEquipForm();
                return outList;
            }
            // 售后调查单子
            if(taskType.equals(TaskTypeConst.SURVEY)){
                ArrayList<TaskForm> outList = adminSurveyForm();
                return outList;
            }
        }
        if(userType.equals(UserTypeConst.SERVICE)){
            //快速服务单子
            if(taskType.equals(TaskTypeConst.FAST_SERVICE)){
                return userFastForm();
            }
            //现场服务单子
            if(taskType.equals(TaskTypeConst.FIELD_SERVICE)){
                ArrayList<TaskForm> fieldList = userFieldForm();
                return fieldList;
            }
            //安装调试单子
            if(taskType.equals(TaskTypeConst.EQUIPMENT)){
                return userEquipForm(troubleType);
            }
            //外购件安装单子
            if(taskType.equals(TaskTypeConst.OUT_EQUIPMENT)){
                ArrayList<TaskForm> outList = userOutEquipForm();
                return outList;
            }
            //满意度调查单子
            if(taskType.equals(TaskTypeConst.SURVEY)){
                ArrayList<TaskForm> outList = userSurveyForm();
                return outList;
            }
        }
        if(userType.equals(UserTypeConst.CUSTOMER)){
            //快速服务单子
            if(taskType.equals(TaskTypeConst.FAST_SERVICE)){
                return cusFastForm();
            }
            //现场服务单子
            if(taskType.equals(TaskTypeConst.FIELD_SERVICE)){
                ArrayList<TaskForm> fieldList = cusFieldForm();
                return fieldList;
            }
            //安装调试单子
            if(taskType.equals(TaskTypeConst.EQUIPMENT)){
                return cusEquipForm();
            }
            //外购件安装单子
            if(taskType.equals(TaskTypeConst.OUT_EQUIPMENT)){
                ArrayList<TaskForm> equipList = cusEquipForm();
                ArrayList<TaskForm> outList = cusOutEquipForm();
                equipList.addAll(outList);
                return equipList;
            }
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
            add(new TaskForm(FormNameConst.REQUIRE,false,true));
            add(new TaskForm(FormNameConst.FAST_FB,false));
//            add(new TaskForm(FormNameConst.FAST_SURVEY,true));
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
            add(new TaskForm(FormNameConst.REQUIRE,false,true));
            add(new TaskForm(FormNameConst.FIELD_APPLY,true));
//            add(new TaskForm(FormNameConst.FIELD_ASSIGN,true));
            add(new TaskForm(FormNameConst.FIELD_FB,true));
//            add(new TaskForm(FormNameConst.FIELD_SURVEY,true));
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
            add(new TaskForm(FormNameConst.REQUIRE,true,true));
            add(new TaskForm(FormNameConst.FIELD_APPLY,true));
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
//        list.add(new TaskForm(FormNameConst.EQUIP_SURVEY,true));
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
            add(new TaskForm(FormNameConst.REQUIRE,true,true));
            add(new TaskForm(FormNameConst.EQUIP_APPLY,true));
            add(new TaskForm(FormNameConst.EQUIP_AUDIT,true));
            add(new TaskForm(FormNameConst.EQUIP_CHECK,true));
        }};
        return list;
    }

    /**
     * 审核人员可以看到的快速调查单子
     * @return
     */
    public static ArrayList<TaskForm> adminSurveyForm(){
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.REQUIRE,true,true));
            add(new TaskForm(FormNameConst.FAST_SURVEY,true));
            add(new TaskForm(FormNameConst.FIELD_SURVEY,true));
        }};
        return list;
    }

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 服务人员可看快速服务单子列表
     */
    public static ArrayList<TaskForm> userFastForm(){
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.REQUIRE,false,true));
            add(new TaskForm(FormNameConst.FAST_FB,false));
            add(new TaskForm(FormNameConst.FIELD_APPLY,true));
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
    public static ArrayList<TaskForm> userFieldForm(){
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.REQUIRE,false,true));
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
     * @description: 服务人员可看安装单子列表
     */
    public static ArrayList<TaskForm> userEquipForm(Byte troubleType){
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.REQUIRE,true,true));
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
     * @description: 服务人员可看外购件单子列表
     */
    public static ArrayList<TaskForm> userOutEquipForm(){
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.REQUIRE,true,true));
            add(new TaskForm(FormNameConst.EQUIP_APPLY,true));
            add(new TaskForm(FormNameConst.EQUIP_AUDIT,true));
            add(new TaskForm(FormNameConst.EQUIP_CHECK,true));
        }};
        return list;
    }

    /**
     * 服务人员可以看到的满意度调查
     * @return
     */
    public static ArrayList<TaskForm> userSurveyForm(){
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.REQUIRE,true,true));
            add(new TaskForm(FormNameConst.FAST_SURVEY,true));
            add(new TaskForm(FormNameConst.FIELD_SURVEY,true));
        }};
        return list;
    }

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 客户可看快速服务单子列表
     */
    public static ArrayList<TaskForm> cusFastForm(){
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.REQUIRE,false));
        }};
        return list;
    }

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 客户可看现场服务单子列表
     */
    public static ArrayList<TaskForm> cusFieldForm(){
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.REQUIRE,false));
            add(new TaskForm(FormNameConst.FIELD_FB,false));
            add(new TaskForm(FormNameConst.FIELD_SURVEY,false));
        }};
        return list;
    }
    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 客户可看安装单子列表
     */
    public static ArrayList<TaskForm> cusEquipForm(){
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.REQUIRE,false));
            add(new TaskForm(FormNameConst.SAFE_CONFIDE,true));
            add(new TaskForm(FormNameConst.MTAIN_CONFIDE,true));
            add(new TaskForm(FormNameConst.EQUIP_SURVEY,false));
        }};
        return list;
    }

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2019/11/4
     * @description: 客户可看外购件单子列表
     */
    public static ArrayList<TaskForm> cusOutEquipForm(){
        ArrayList<TaskForm> list = new ArrayList<TaskForm>() {{
            add(new TaskForm(FormNameConst.EQUIP_CHECK,true));
        }};
        return list;
    }
}
