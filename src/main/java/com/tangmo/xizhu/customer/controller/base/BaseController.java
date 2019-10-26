package com.tangmo.xizhu.customer.controller.base;

import com.tangmo.xizhu.customer.service.*;
import com.tangmo.xizhu.customer.util.MoblieUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author chen bo
 * @Date 2019/10/17
 * @Version V1.0
 * @Description: controller基准类
 **/
public class BaseController {
    @Resource
    protected LoginService loginService;
    @Resource
    protected TaskService taskService;
    @Resource
    protected AuditTaskService auditTaskService;
    @Resource
    protected TaskRequireService taskRequireService;
    @Resource
    protected FastFeedbackService fastFeedbackService;
    @Resource
    protected FastSurveyService fastSurveyService;
    @Resource
    protected FieldApplyService fieldApplyService;
    @Resource
    protected FieldAssignService fieldAssignService;
    @Resource
    protected FieldFeedbackService fieldFeedbackService;
    //安全交底表service
    @Resource
    protected SafeConfideService safeConfideService;
    //设备档案表service
    @Resource
    protected DeviceFileService deviceFileService;
    //机械安装工作记录service
    @Resource
    protected MachRecordService machRecordService;
    //电气安装工作记录service
    @Resource
    protected ElecRecordService elecRecordService;
    @Resource
    protected FilePathService filePathService;
    @Resource
    protected DeptService deptService;
    @Resource
    protected MtainConfideService mtainConfideService;
    @Resource
    protected UserService userService;

    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected String getUserId(){
        return "1";
    }

    protected Byte getUserType(){
        return 0;
    }

    protected String getDeptId(){return "1";}

    protected String getDeptName(){return "1";}

    /**
     * @param
     * @author chen bo
     * @date 2019/10/24
     * @description: 判断是否移动端登录
     */
    protected Boolean getAgent(){
        return MoblieUtil.judgeIsMoblie(getRequest());
    }
}
