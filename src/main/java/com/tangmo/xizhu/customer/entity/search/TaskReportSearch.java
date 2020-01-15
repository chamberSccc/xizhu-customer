package com.tangmo.xizhu.customer.entity.search;

import com.tangmo.xizhu.customer.common.Page;
import lombok.Data;

/**
 * @author boge
 * @date 2019/12/25
 * @description 任务报表搜索对象
 */
@Data
public class TaskReportSearch extends Page {

    private Integer year;
    private String troubleType;
    private String assemblyType;
    private Byte status; //任务状态
    private String deviceType;

    public void setTroubleType(String troubleType) {
        if(troubleType.equals("")){
            this.troubleType = null;
        }else{
            this.troubleType = troubleType;
        }

    }

    public void setAssemblyType(String assemblyType) {
        if(assemblyType.equals("")){
            this.assemblyType = null;
        }else{
            this.assemblyType = assemblyType;
        }
    }

    public void setDeviceType(String deviceType) {
        if(deviceType.equals("")){
            this.deviceType = null;
        }else{
            this.deviceType = deviceType;
        }
    }
}
