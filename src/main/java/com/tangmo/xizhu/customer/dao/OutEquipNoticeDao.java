package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.OutEquipNotice;
import org.springframework.stereotype.Repository;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件厂家安装通知单
 **/
@Repository
public interface OutEquipNoticeDao {

    /**
     * @param outEquipNotice
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 新增外购件厂家安装通知单
     */
    Integer insertOutAudit(OutEquipNotice outEquipNotice);

    /**
     * @param outEquipNotice
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 修改外购件厂家安装通知单
     */
    Integer updateOutApply(OutEquipNotice outEquipNotice);

    /**
     * @param taskId
     * @return
     * @author chen bo
     * @date 2019/10/31
     * @description: 通过任务id查询外购件厂家安装通知单
     */
    OutEquipNotice selectByTaskId(String taskId);
}
