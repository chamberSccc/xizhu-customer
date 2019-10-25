package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.MaintainConfide;

/**
 * @Author chen bo
 * @Date 2019/10/26
 * @Version V1.0
 * @Description: 沥青混合料搅拌设备维护保养交底表dao
 **/
public interface MtainConfideDao {

    /**
     * @param maintainConfide
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 新增交底表
     */
    Integer insertMtainConfide(MaintainConfide maintainConfide);
    /**
     * @param maintainConfide
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 修改交底表
     */
    Integer updateMtainConfide(MaintainConfide maintainConfide);

    /**
     * @param taskId
     * @param type
     * @return
     * @author chen bo
     * @date 2019/10/26
     * @description: 通过id和类型查找交底表
     */
    MaintainConfide selectByTaskIdAndType(String taskId,Byte type);
}
