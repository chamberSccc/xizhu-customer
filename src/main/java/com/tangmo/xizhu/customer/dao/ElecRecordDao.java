package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.ElecRecord;
import org.springframework.stereotype.Repository;

/**
 * @Author chen bo
 * @Date 2019/10/23
 * @Version V1.0
 * @Description: 安装工作记录(电气)dao
 **/
@Repository
public interface ElecRecordDao {

    /**
     * @param elecRecord
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 增加安装工作记录
     */
    void insertElecRecord(ElecRecord elecRecord);

    /**
     * @param elecRecord
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 修改安装工作记录
     */
    void updateElecRecord(ElecRecord elecRecord);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 查询任务下的安装工作记录
     */
    ElecRecord selectByTaskId(String taskId);
}
