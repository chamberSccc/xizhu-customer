package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.OptRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/12/20
 * @Version V1.0
 * @Description: 操作记录dao
 **/
public interface OptRecordDao {

    /**
     * @param optRecord
     * @return
     * @author chen bo
     * @date 2019/12/20
     * @description: 添加操作记录
     */
    void insertOptRecord(OptRecord optRecord);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/12/20
     * @description: 查找任务的操作记录
     */
    List<OptRecord> selectByTaskIdAndType(@Param("taskId") String taskId, @Param("taskType") Byte taskType);
}
