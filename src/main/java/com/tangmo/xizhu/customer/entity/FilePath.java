package com.tangmo.xizhu.customer.entity;

import lombok.Data;

/**
 * @author boge
 * @date 2019/10/25
 * @description 文件路径类
 */
@Data
public class FilePath {
    private String uuid;
    private String filePath;
    private String userId;
    private String fileType;
}
