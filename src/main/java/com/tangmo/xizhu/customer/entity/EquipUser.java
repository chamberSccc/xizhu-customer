package com.tangmo.xizhu.customer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author boge
 * @date 2019/10/21
 * @description 设备档案中的安调人员
 */
@Data
public class EquipUser {
    @ApiModelProperty(value="id",name="uuid",example="")
    private String uuid;
    @ApiModelProperty(value="设备档案表id",name="deviceFileId",example="")
    private String deviceFileId;//设备档案表id
    @ApiModelProperty(value="成员人名",name="memberName",example="")
    private String memberName;//成员人名
    @ApiModelProperty(value="成员类型 0:带队工程师,1:组员",name="memberType",example="")
    private Byte memberType;//成员类型 0:带队工程师,1:组员
    @ApiModelProperty(value="工作内容",name="content",example="")
    private String content;//工作内容
}
