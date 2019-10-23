package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.DailyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/23
 * @Version V1.0
 * @Description: 每日工作内容，安全记录dao
 **/
public interface DailyRecordDao {

    /**
     * @param dailyRecord
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 批量增加每日工作记录
     */
    Integer insertBatchDaily(List<DailyRecord> list);

    /**
     * @param parentId	安装工作记录id
     * @param baseType	0 机械安装工作记录，1电器安装工作记录
     * @param contentType 0 工作内容，1，安全记录
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: 根据父id和类型查询
     */
    List<DailyRecord> selectByParentAndType(@Param("parentId") String parentId,@Param("baseType") Byte baseType,
                                            @Param("contentType") Byte contentType);

    /**
     * @param parentId
     * @param baseType 0 机械安装工作记录，1电器安装工作记录
     * @return
     * @author chen bo
     * @date 2019/10/23
     * @description: TODO
     */
    Integer deleteByParentAndBase(@Param("parentId") String parentId,@Param("baseType") Byte baseType);
}
