package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.MachRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/23
 * @Version V1.0
 * @Description: 安装工作记录(机械)dao
 **/
@Repository
public interface MachRecordDao {

    /**
     * @param machRecord
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 增加安装工作记录
     */
    void insertMachRecord(MachRecord machRecord);

    /**
     * @param machRecord
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 修改安装工作记录
     */
    void updateMachRecord(MachRecord machRecord);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 查询任务下的安装工作记录
     */
    MachRecord selectByTaskId(String taskId);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/11/3
     * @description: 查询安装工作记录时间
     */
    List<MachRecord> selectDateByTaskId(String taskId);

    /**
     * @param uuid
     * @return
     * @author chen bo
     * @date 2019/11/3
     * @description: 通过主键查询安装工作记录
     */
    MachRecord selectById(String uuid);
}
