package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.TaskAttach;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/24
 * @Version V1.0
 * @Description: 任务附件dao
 **/
@Repository
public interface TaskAttachDao {

    /**
     * @param parentId
     * @param parentType
     * @param attachType
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 根据父类型和附件类型查询任务附件
     */
    List<String> selectByParentAndType(@Param("parentId") String parentId,@Param("parentType") Byte parentType,
                                       @Param("attachType") Byte attachType);

    /**
     * @param list
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 批量增加任务附件
     */
    void insertBatchAttach(List<TaskAttach> list);

    /**
     * @param parentId
     * @param parentType
     * @param attachType
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: 根据父类型和附件类型删除任务附件
     */
    void deleteByParentAndType(@Param("parentId") String parentId,@Param("parentType") Byte parentType,
                               @Param("attachType") Byte attachType);
}
