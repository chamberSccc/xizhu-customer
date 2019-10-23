package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.EquipUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/23
 * @Version V1.0
 * @Description: 设备档案表中所需的安调人员
 **/
@Repository
public interface EquipUserDao {

    /**
     * @param list
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 批量增加安调人员
     */
    void insertBatchUser(List<EquipUser> list);

    /**
     * @param deviceFileId
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 删除设备档案下的安调人员
     */
    void deleteByDeviceFileId(String deviceFileId);

    /**
     * @param deviceFileId
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 查询设备档案下的安调人员
     */
    List<EquipUser> selectByDeviceFileId(String deviceFileId);
}
