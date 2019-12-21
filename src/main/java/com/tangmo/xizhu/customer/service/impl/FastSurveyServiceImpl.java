package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.constant.OptConst;
import com.tangmo.xizhu.customer.constant.TaskAttachConst;
import com.tangmo.xizhu.customer.dao.FastSurveyDao;
import com.tangmo.xizhu.customer.dao.TaskAttachDao;
import com.tangmo.xizhu.customer.entity.FastFeedBack;
import com.tangmo.xizhu.customer.entity.FastSurvey;
import com.tangmo.xizhu.customer.entity.TaskAttach;
import com.tangmo.xizhu.customer.entity.converter.FastFbConverter;
import com.tangmo.xizhu.customer.entity.converter.TaskAttachConverter;
import com.tangmo.xizhu.customer.service.FastFeedbackService;
import com.tangmo.xizhu.customer.service.FastSurveyService;
import com.tangmo.xizhu.customer.service.FormStateService;
import com.tangmo.xizhu.customer.service.OptRecordService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/18
 * @Version V1.0
 * @Description:
 **/
@Service("fastSurveyService")
public class FastSurveyServiceImpl implements FastSurveyService {
    @Resource
    private FastSurveyDao fastSurveyDao;
    @Resource
    private FastFeedbackService fastFeedbackService;
    @Resource
    private TaskAttachDao taskAttachDao;
    @Resource
    private OptRecordService optRecordService;
    @Resource
    private FormStateService formStateService;

    @Override
    public HttpResult addSurvey(FastSurvey fastSurvey) {
        String uuid = EncryptUtil.get32Uuid();
        fastSurvey.setUuid(uuid);
        fastSurveyDao.insertFastSurvey(fastSurvey);
        List<TaskAttach> detailAttach = TaskAttachConverter.String2Entity(fastSurvey.getDetailPictureList(),uuid,
                TaskAttachConst.FAST_SURVEY,TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
        List<TaskAttach> solAttach = TaskAttachConverter.String2Entity(fastSurvey.getDetailPictureList(),uuid,
                TaskAttachConst.FAST_SURVEY,TaskAttachConst.PICTURE,TaskAttachConst.SOLUTION);
        if(detailAttach != null){
            taskAttachDao.insertBatchAttach(detailAttach);
        }
        if(solAttach != null){
            taskAttachDao.insertBatchAttach(solAttach);
        }
        //操作记录
        optRecordService.addOptRecord(fastSurvey.getTaskId(),fastSurvey.getCreatedBy(), OptConst.FAST_SURVEY);
        //任务流程
        formStateService.changeFormState(fastSurvey.getTaskId(),"form03");
        return HttpResult.success();
    }

    @Override
    public HttpResult changeSurvey(FastSurvey fastSurvey) {
        fastSurveyDao.updateFastSurvey(fastSurvey);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        FastSurvey fastSurvey = fastSurveyDao.selectByTaskId(taskId);
        if(fastSurvey == null){
            FastFeedBack fastFeedBack = (FastFeedBack) fastFeedbackService.getByTaskId(taskId).getData();
            if(fastFeedBack != null){
                fastSurvey = FastFbConverter.FastFb2FastSurvey(fastFeedBack);
            }
        }else{
            List<String> detail = taskAttachDao.selectByParentAndType(fastSurvey.getUuid(), TaskAttachConst.FAST_SURVEY,
                    TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
            List<String> solution = taskAttachDao.selectByParentAndType(fastSurvey.getUuid(), TaskAttachConst.FAST_SURVEY,
                    TaskAttachConst.PICTURE,TaskAttachConst.SOLUTION);
            fastSurvey.setDetailPictureList(detail);
            fastSurvey.setSolPictureList(solution);
        }
        return HttpResult.success(fastSurvey);
    }
}
