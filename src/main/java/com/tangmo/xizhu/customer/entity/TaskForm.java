package com.tangmo.xizhu.customer.entity;

import lombok.Data;

/**
 * @Author chen bo
 * @Date 2019/11/4
 * @Version V1.0
 * @Description:
 **/
@Data
public class TaskForm {

    private String formName;
    private boolean editable;//是否可编辑
    private boolean doneState;//是否已填写

    public TaskForm() {
    }

    public TaskForm(String formName, boolean editable) {
        this.formName = formName;
        this.editable = editable;
        this.doneState = false;
    }

    public TaskForm(String formName, boolean editable ,boolean doneState) {
        this.formName = formName;
        this.editable = editable;
        this.doneState = doneState;
    }
}
