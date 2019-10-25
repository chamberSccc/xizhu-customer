package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.constant.TaskAttachConst;
import com.tangmo.xizhu.customer.dao.FieldFeedbackDao;
import com.tangmo.xizhu.customer.dao.TaskAttachDao;
import com.tangmo.xizhu.customer.entity.FieldApply;
import com.tangmo.xizhu.customer.entity.FieldFeedBack;
import com.tangmo.xizhu.customer.entity.converter.FieldApplyConverter;
import com.tangmo.xizhu.customer.service.FieldApplyService;
import com.tangmo.xizhu.customer.service.FieldFeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description: 现场服务反馈单service实现类
 **/
@Service("fieldFeedbackService")
public class FieldFeedbackServiceImpl implements FieldFeedbackService {
    @Resource
    private FieldFeedbackDao fieldFeedbackDao;
    @Resource
    private FieldApplyService fieldApplyService;
    @Resource
    private TaskAttachDao taskAttachDao;
    @Override
    public HttpResult addFeedback(FieldFeedBack feedBack) {
        fieldFeedbackDao.insertFeedback(feedBack);
        return HttpResult.success();
    }

    @Override
    public HttpResult changeFeedback(FieldFeedBack fieldFeedBack) {
        fieldFeedbackDao.updateFeedback(fieldFeedBack);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        FieldFeedBack fieldFeedBack = fieldFeedbackDao.selectByTaskId(taskId);
        if(fieldFeedBack == null){
            FieldApply fieldApply = (FieldApply) fieldApplyService.getByTaskId(taskId).getData();
            fieldFeedBack = FieldApplyConverter.apply2FieldFb(fieldApply);
        }else{
            List<String> detail = taskAttachDao.selectByParentAndType(fieldFeedBack.getUuid(), TaskAttachConst.FIELD_APPLY,
                    TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
            fieldFeedBack.setDetailPictureList(detail);
        }
        return HttpResult.success(fieldFeedBack);
    }
}
