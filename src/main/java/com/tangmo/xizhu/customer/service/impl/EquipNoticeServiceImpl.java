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
            }
        }
        return HttpResult.success(outEquipNotice);
    }
}
