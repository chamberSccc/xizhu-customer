package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.constant.TaskAttachConst;
import com.tangmo.xizhu.customer.dao.FieldApplyDao;
import com.tangmo.xizhu.customer.dao.TaskAttachDao;
import com.tangmo.xizhu.customer.entity.FastFeedBack;
import com.tangmo.xizhu.customer.entity.FieldApply;
import com.tangmo.xizhu.customer.entity.TaskAttach;
import com.tangmo.xizhu.customer.entity.converter.FastFbConverter;
import com.tangmo.xizhu.customer.entity.converter.TaskAttachConverter;
import com.tangmo.xizhu.customer.service.FastFeedbackService;
import com.tangmo.xizhu.customer.service.FieldApplyService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description: 现场服务申请单service实现类
 **/
@Service("fieldApplyService")
public class FieldApplyServiceImpl implements FieldApplyService {
    @Resource
    private FieldApplyDao fieldApplyDao;
    @Resource
    private TaskAttachDao taskAttachDao;
    @Resource
    private FastFeedbackService fastFeedbackService;
    @Override
    public HttpResult addApply(FieldApply fieldApply) {
        String uuid = EncryptUtil.get32Uuid();
        fieldApply.setUuid(uuid);
        fieldApplyDao.insertFieldApply(fieldApply);
        //存储附件
        List<String> picture = fieldApply.getDetailPictureList();
        List<TaskAttach> list = TaskAttachConverter.String2Entity(picture, uuid,TaskAttachConst.FIELD_APPLY,
                TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
        if(list != null){
            taskAttachDao.insertBatchAttach(list);
        }
        return HttpResult.success();
    }

    @Override
    public HttpResult changeApply(FieldApply fieldApply) {
        fieldApplyDao.updateFieldApply(fieldApply);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        FieldApply fieldApply = fieldApplyDao.selectByTaskId(taskId);
        if(fieldApply == null){
            FastFeedBack fastFeedBack = (FastFeedBack) fastFeedbackService.getByTaskId(taskId).getData();
            fieldApply = FastFbConverter.fastFb2FieldApply(fastFeedBack);
        }else{
            List<String> detail = taskAttachDao.selectByParentAndType(fieldApply.getUuid(), TaskAttachConst.FIELD_APPLY,
                    TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
            fieldApply.setDetailPictureList(detail);
        }
        return HttpResult.success(fieldApply);
    }
}
