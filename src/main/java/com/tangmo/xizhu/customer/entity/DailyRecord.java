package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

/**
 * @Author chen bo
 * @Date 2019/10/22
 * @Version V1.0
 * @Description: 每天工作记录
 **/
@Data
public class DailyRecord {
    @ApiModelProperty(value="id",name="uuid",example="")
    private String uuid;
    @ApiModelProperty(value="内容",name="content",example="")
    private String content;
    @ApiModelProperty(value="照片id",name="pictureId",example="")
    private String pictureId;
    @ApiModelProperty(value="视频id",name="audioId",example="")
    private String audioId;
    private String parentId; //安装表id
    private Byte contentType;//0 工作内容，1，安全记录
    private Byte baseType;//0 机械，1电器
    private Date createdTime;
}
