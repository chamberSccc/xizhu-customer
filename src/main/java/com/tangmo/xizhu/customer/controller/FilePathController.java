package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author boge
 * @date 2019/10/25
 * @description 文件上传/下载接口
 */
@Api(description="文件操作接口")
@RestController
@RequestMapping("/file")
public class FilePathController extends BaseController{

    /**
     * 上传文件
     * @param file
     * @return
     */
    @ApiOperation(value = "上传文件",httpMethod = "POST",notes = "")
    @PostMapping("/upload")
    public HttpResult uploadFile(MultipartFile file){
        return filePathService.uploadFile(file,getUserId());
    }

    /**
     * 下载文件
     * @param fileId
     * @return
     */
    @ApiOperation(value = "下载文件",httpMethod = "GET",notes = "")
    @GetMapping("/download/{fileId}")
    public ResponseEntity<byte[]> download(@PathVariable String fileId){
        String agent = this.getRequest().getHeader("USER-AGENT");
        return filePathService.downloadFile(fileId,agent);
    }
}
