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

    HttpResult uploadFile(MultipartFile file,String userId);

    ResponseEntity<byte[]> downloadFile(String fileId,String agent);

}
