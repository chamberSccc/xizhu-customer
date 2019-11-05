package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.common.ResultCode;
import com.tangmo.xizhu.customer.dao.OutEquipApplyDao;
import com.tangmo.xizhu.customer.dao.OutEquipNoticeDao;
import com.tangmo.xizhu.customer.entity.OutEquipApply;
import com.tangmo.xizhu.customer.entity.OutEquipNotice;
import com.tangmo.xizhu.customer.entity.converter.EquipApplyConverter;
import com.tangmo.xizhu.customer.service.EquipNoticeService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chen bo
 * @Date 2019/10/31
 * @Version V1.0
 * @Description: 外购件厂家现场安装调试通知service实现类
 **/
@Service("equipNoticeService")
public class EquipNoticeServiceImpl implements EquipNoticeService {
    @Resource
    private OutEquipNoticeDao outEquipNoticeDao;
    @Resource
    private OutEquipApplyDao outEquipApplyDao;
    @Override
    public HttpResult addOutNotice(OutEquipNotice outEquipNotice) {
        outEquipNotice.setUuid(EncryptUtil.get32Uuid());
        outEquipNoticeDao.insertOutNotice(outEquipNotice);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeOutNotice(OutEquipNotice outEquipNotice) {
        outEquipNoticeDao.updateOutNotice(outEquipNotice);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        OutEquipNotice outEquipNotice = outEquipNoticeDao.selectByTaskId(taskId);
        if(outEquipNotice == null){
            OutEquipApply outEquipApply = outEquipApplyDao.selectByTaskId(taskId);
            if(outEquipApply == null){
                return HttpResult.fail(ResultCode.EQUIP_APPLY_MISS);
            }else{
                outEquipNotice = EquipApplyConverter.apply2Notice(outEquipApply);
                StringBuilder sb = new StringBuilder();
                sb.append("尊敬的用户/").append(outEquipApply.getCreatedBy()).append(" 服务任务您好!");
                sb.append("您发出的<").append(outEquipApply.getEquipName()).append("安装调试申请单>我们已经收到,");
                sb.append("为了做好专业的服务工作,  厂家  工程师,电话  ,于  年  月  日出发进行现场的安装调试工作.感谢您对中交西安筑路有限公司的支持!");
                outEquipNotice.setNotice(sb.toString());
            }
        }
        return HttpResult.success(outEquipNotice);
    }
}
