package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.FieldAssign;
import org.springframework.stereotype.Repository;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description:
 **/
@Repository
public interface FieldAssignDao {

    /**
     * @param fieldAssign
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 增加现场服务指派单
     */
    void insertAssign(FieldAssign fieldAssign);

    /**
     * @param fieldAssign
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 修改现场服务指派单
     */
    void updateAssign(FieldAssign fieldAssign);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 通过任务id查询
     */
    FieldAssign selectByTaskId(String taskId);
}
