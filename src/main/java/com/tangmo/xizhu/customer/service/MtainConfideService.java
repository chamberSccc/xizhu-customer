package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.MaintainConfide;

/**
 * @Author chen bo
 * @Date 2019/10/26
 * @Version V1.0
 * @Description: 沥青混合料搅拌设备维护保养交底表service
 **/
public interface MtainConfideService {

    /**
     * @param maintainConfide
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 增加交底表
     */
    HttpResult addMtainConfide(MaintainConfide maintainConfide);

    /**
     * @param maintainConfide
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 修改交底表
     */
    HttpResult changeMtainConfide(MaintainConfide maintainConfide);

    /**
     * @param taskId
     * @param type
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 查询任务下1-11种类型的表
     */
    HttpResult getByTaskIdAndType(String taskId,Byte type);
}
