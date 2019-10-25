package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.FilePath;
import org.springframework.stereotype.Repository;

/**
 * @author boge
 * @date 2019/10/25
 * @description 文件路径dao
 */
@Repository
public interface FilePathDao {

    /**
     * @param filePath
     * @description 新增文件路径
     * @return
     */
    Integer insertFilePath(FilePath filePath);

    /**
     * @param uuid
     * @description 根据uuid查询
     * @return
     */
    FilePath selectById(String uuid);
}
