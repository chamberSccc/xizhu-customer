package com.tangmo.xizhu.customer.controller;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.controller.base.BaseController;
import com.tangmo.xizhu.customer.entity.TaskRequire;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description: 服务任务需求单controller
 **/
@Api(description="任务需求单接口")
@RestController
@RequestMapping("/require")
public class TaskRequireController extends BaseController {

    /**
     * @param taskRequire
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 新增服务任务需求单
     */
    @PostMapping("")
    public HttpResult addTaskRequire(@RequestBody TaskRequire taskRequire){
        return taskRequireService.addTaskRequire(taskRequire);
    }

    /**
     * @param taskRequire
     * @return
     * @author chen bo
     * @date 2019/10/18
     * @description: 修改服务任务需求单
     */
    @PutMapping("")
    public HttpResult changeTaskRequire(@RequestBody TaskRequire taskRequire){
        return taskRequireService.changeTaskRequire(taskRequire);
    }
}
