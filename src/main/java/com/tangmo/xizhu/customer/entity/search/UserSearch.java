package com.tangmo.xizhu.customer.entity.search;

import com.tangmo.xizhu.customer.common.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author chen bo
 * @Date 2019/11/2
 * @Version V1.0
 * @Description: 用户信息搜索对象
 **/
@Data
public class UserSearch extends Page {
    @ApiModelProperty(value="用户姓名",name="userName",example="")
    private String userName;
    private Byte userState;

    public void setUserName(String userName) {
        if(userName.equals("")){
            this.userName = null;
        }else{
            this.userName = userName;
        }
    }
}
