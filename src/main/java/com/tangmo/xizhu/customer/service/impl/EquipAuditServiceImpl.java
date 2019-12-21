package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.constant.AuditOperateConst;
import com.tangmo.xizhu.customer.constant.OptConst;
import com.tangmo.xizhu.customer.constant.TaskTypeConst;
import com.tangmo.xizhu.customer.dao.AuditTaskDao;
import com.tangmo.xizhu.customer.dao.OutEquipApplyDao;
import com.tangmo.xizhu.customer.dao.OutEquipAuditDao;
import com.tangmo.xizhu.customer.entity.AuditTask;
import com.tangmo.xizhu.customer.entity.OutEquipApply;
import com.tangmo.xizhu.customer.entity.OutEquipAudit;
import com.tangmo.xizhu.customer.entity.OutEquipNotice;
import com.tangmo.xizhu.customer.entity.converter.EquipApplyConverter;
import com.tangmo.xizhu.customer.service.EquipAuditService;
import com.tangmo.xizhu.customer.service.EquipNoticeService;
import com.tangmo.xizhu.customer.service.FormStateService;
import com.tangmo.xizhu.customer.service.OptRecordService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件安装调试授权审批单service实现类
 **/
@Service("equipAuditService")
public class EquipAuditServiceImpl implements EquipAuditService {
    @Resource
    private OutEquipAuditDao outEquipAuditDao;
    @Resource
    private OutEquipApplyDao outEquipApplyDao;
    @Resource
    private AuditTaskDao auditTaskDao;
    @Resource
    private EquipNoticeService equipNoticeService;
    @Resource
    private OptRecordService optRecordService;
    @Resource
    private FormStateService formStateService;
    @Override
    public HttpResult addOutAudit(OutEquipAudit outEquipAudit) {
        if(outEquipAudit == null || outEquipAudit.getTaskId() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        OutEquipApply outEquipApply = outEquipApplyDao.selectByTaskId(outEquipAudit.getTaskId());
        if(outEquipApply == null){
            return HttpResult.fail(ResultCode.EQUIP_APPLY_MISS);
        }
        OutEquipAudit exists = outEquipAuditDao.selectByTaskId(outEquipAudit.getTaskId());
        if(exists != null){
            return HttpResult.fail(ResultCode.DOUBLE_SUBMIT);
        }
        outEquipAudit.setUuid(EncryptUtil.get32Uuid());
        outEquipAuditDao.insertOutAudit(outEquipAudit);
        //添加通知单
//        OutEquipNotice outEquipNotice = EquipApplyConverter.apply2Notice(outEquipApply);
//        outEquipNotice.setUuid(EncryptUtil.get32Uuid());
//        equipNoticeService.addOutNotice(outEquipNotice);
        //操作记录
        optRecordService.addOptRecord(outEquipApply.getTaskId(),outEquipApply.getCreatedBy(), OptConst.EQUIP_AUDIT);
        //任务流程
        formStateService.changeFormState(outEquipApply.getTaskId(),"form14");
        return HttpResult.success();
    }

    @Override
    public HttpResult changeOutAudit(OutEquipAudit outEquipAudit) {
        if(outEquipAudit.getUuid() == null){
            return HttpResult.fail(ResultCode.PARAM_ERROR);
        }
        outEquipAuditDao.updateOutAudit(outEquipAudit);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        OutEquipAudit outEquipAudit = outEquipAuditDao.selectByTaskId(taskId);
        if(outEquipAudit == null){
            OutEquipApply outEquipApply = outEquipApplyDao.selectByTaskId(taskId);
            if(outEquipApply == null){
                return HttpResult.fail(ResultCode.EQUIP_APPLY_MISS);
            }else{
                outEquipAudit = EquipApplyConverter.apply2Audit(outEquipApply);
            }
        }
        return HttpResult.success(outEquipAudit);
    }
}
