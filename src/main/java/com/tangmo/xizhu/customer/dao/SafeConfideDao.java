package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.SafeConfide;
import org.springframework.stereotype.Repository;

/**
 * @Author chen bo
 * @Date 2019/10/23
 * @Version V1.0
 * @Description: 安全交底表 dao
 **/
@Repository
public interface SafeConfideDao {

    /**
     * @param safeConfide
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 增加安全交底表
     */
    void insertSafeConfide(SafeConfide safeConfide);

    /**
     * @param safeConfide
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 修改安全交底表
     */
    void updateSafeConfide(SafeConfide safeConfide);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 查询任务的安全交底表
     */
    SafeConfide selectByTaskId(String taskId);
}
