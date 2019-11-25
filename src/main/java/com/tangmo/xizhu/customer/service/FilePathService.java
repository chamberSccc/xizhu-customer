package com.tangmo.xizhu.customer.service;

import com.tangmo.xizhu.customer.common.HttpResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author boge
 * @date 2019/10/25
 * @description 文件路径service
 */

public interface FilePathService {

    /**
     * @param file
     * @param userId
     * @return
     * @author chen bo
     * @date 2019/11/25
     * @description: 上传文件
     */
    HttpResult uploadFile(MultipartFile file,String userId);

    /**
     * @param fileId
     * @param agent
     * @return
     * @author chen bo
     * @date 2019/11/25
     * @description: 下载文件
     */
    ResponseEntity<byte[]> downloadFile(String fileId,String agent);

    /**
     * @param agent
     * @return
     * @author chen bo
     * @date 2019/11/25
     * @description: 下载apk包
     */
    ResponseEntity<byte[]> downloadApk(String agent);

}
