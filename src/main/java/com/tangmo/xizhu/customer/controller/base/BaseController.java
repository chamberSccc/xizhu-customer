package com.tangmo.xizhu.customer.controller.base;

import com.tangmo.xizhu.customer.common.TokenBo;
import com.tangmo.xizhu.customer.config.JWTToken;
import com.tangmo.xizhu.customer.service.*;
import com.tangmo.xizhu.customer.util.JWTUtil;
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
    @Resource
    protected CustomerService customerService;
    @Resource
    protected DeviceService deviceService;
    //外购件相关服务
    @Resource
    protected EquipApplyService equipApplyService;
    @Resource
    protected EquipAuditService equipAuditService;
    @Resource
    protected EquipCheckService equipCheckService;
    @Resource
    protected EquipNoticeService equipNoticeService;

    @Resource
    protected TaskPunchService taskPunchService;
    //快速服务满意度调查表
    @Resource
    protected FieldSurveyService fieldSurveyService;
    //安调服务满意度调查表
    @Resource
    protected EquipSurveyService equipSurveyService;

    @Resource
    protected OptRecordService optRecordService;

    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public TokenBo getToken(){
        String authorization = getRequest().getHeader("Authorization");
        JWTToken token = new JWTToken(authorization);
        TokenBo tokenBo = JWTUtil.getTokenBO(token.getToken());
        return tokenBo;
    }
    protected String getUserId(){
        return getToken().getUserId();
    }

    protected Byte getUserType(){
        return getToken().getUserType();
    }

    protected String getDeptId(){  return getToken().getDeptId();}

    protected String getDeptName(){ return getToken().getDeptName();}

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
