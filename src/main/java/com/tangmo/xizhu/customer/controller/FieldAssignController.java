package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.entity.FieldAssign;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description: 现场服务指派单相关操作
 **/
public class FieldAssignController extends BaseController {

    /**
     * @param fieldAssign
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 新增现场服务指派单
     */
    public HttpResult addFieldAssign(@RequestBody FieldAssign fieldAssign){
        return fieldAssignService.addFieldAssign(fieldAssign);
    }

    /**
     * @param fieldAssign
     * @return
     * @author chen bo
     * @date 2019/10/20
     * @description: 修改现场服务指派单
     */
    public HttpResult changeAssign(@RequestBody FieldAssign fieldAssign){
        return fieldAssignService.changeFieldAssign(fieldAssign);
    }

}
