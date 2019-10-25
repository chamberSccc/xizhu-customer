package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.FilePathDao;
import com.tangmo.xizhu.customer.entity.FilePath;
import com.tangmo.xizhu.customer.service.FilePathService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author boge
 * @date 2019/10/25
 * @description 文件路径service实现类
 */
@Service("filePathService")
public class FilePathServiceImpl implements FilePathService {
    @Resource
    private FilePathDao filePathDao;
    private final static String AGENT_MSIE = "MSIE";
    private final static String AGENT_TRIDENT = "Trident";
    private final static String AGENT_EDGE = "Edge";
    @Override
    public HttpResult uploadFile(MultipartFile file, String userId) {
        FilePath filePath = getPathInfo(file,userId);
        filePath.setUserId(userId);
        filePathDao.insertFilePath(filePath);
        return HttpResult.success();
    }

    @Override
    public ResponseEntity<byte[]> downloadFile(String fileId,String agent) {
//        FilePath fp = filePathDao.selectById(fileId);

        ResponseEntity<byte[]> responseEntity = null;
        try {
            FilePath fp = new FilePath();
            fp.setUserId("1");
            fp.setFileType("jpg");
            fp.setFilePath("/Users/boge/Downloads/xizhu-customer/attach/1/29ff520695534d659c35ad9ad523f7d7.jpg");
            fp.setUuid("29ff520695534d659c35ad9ad523f7d7");
            if (fp == null || fp.getFilePath() == null) {
                return null;
            }
            //获取文件目录
            String filePath = fp.getFilePath();
            responseEntity = downloadEntity(agent, filePath, fileId, fp.getFileType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    /**
     * 下载文件实体
     *
     * @param agent    浏览器标识
     * @param srcFile  源文件路径
     * @param fileName 下载后的文件名
     * @param fileType 下载后的类型
     * @return
     * @throws Exception
     */
    private static ResponseEntity<byte[]> downloadEntity(String agent, String srcFile, String fileName, String fileType)
            throws Exception {
        byte[] body;
        InputStream in = null;
        ResponseEntity<byte[]> response = null;
        try {
            in = new FileInputStream(new File(srcFile));
            //预估文件的有效大小,放入一个body输出
            body = new byte[in.available()];
            in.read(body);
            HttpHeaders headers = new HttpHeaders();
            //浏览器辨别
            if (agent == null) {
                throw new Exception("浏览器标识未获取");
            }
            if (agent.indexOf(AGENT_MSIE) != -1 || agent.indexOf(AGENT_TRIDENT) != -1 || agent.indexOf(AGENT_EDGE) != -1) {
                fileName = fileName.replace(" ", "_");
                fileName = java.net.URLEncoder.encode(fileName, "UTF8");
            } else {// 火狐,chrome等
                fileName = new String(fileName.trim().getBytes("UTF-8"), "iso-8859-1");
            }
            //文件下载后的名称和类型
            headers.add("Content-Disposition", "attachment;filename=" + fileName + "." + fileType.trim());
            //响应状态码ok=200
            HttpStatus statusCode = HttpStatus.OK;
            //返回的数据
            response = new ResponseEntity<byte[]>(body, headers, statusCode);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("下载文件异常：" + e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                throw new Exception("文件输入流关闭时发生异常");
            }
        }
        return response;
    }

    /**
     *
     * @param file
     * @param userId
     * @description 获取数据库所需文件路径信息
     * @return
     */
    private FilePath getPathInfo(MultipartFile file,String userId){
        //验证文件格式
        String orginName = file.getOriginalFilename();
        int index = orginName.lastIndexOf(".") + 1;
        String fileType = orginName.substring(index);
        File basePathFile = new File("");
        String basePath ="";
        try {
            basePath = basePathFile.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String dir = "";//没有拿到上传路径
        String uuid = EncryptUtil.get32Uuid();
        StringBuilder sb = new StringBuilder(basePath).append("/attach/").append(userId).append("/")
                .append(uuid).append(".").append(fileType);
        String fileName = sb.toString();
        boolean bool = uploadFileEntity(file, dir, fileName);
        if (!bool) {
            return null;
        }
        FilePath fp = new FilePath();
        fp.setUuid(uuid);
        fp.setFilePath(fileName);
        fp.setFileType(fileType);
        return fp;
    }
    /**
     *
     * @param file
     * @param dir
     * @param fileName
     * @description 上传文件实体
     * @return
     */
    private Boolean uploadFileEntity(MultipartFile file,String dir,String fileName){
        File entity = new File(dir, fileName);
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), entity);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
