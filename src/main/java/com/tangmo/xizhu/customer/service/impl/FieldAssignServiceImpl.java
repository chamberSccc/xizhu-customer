package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.constant.TaskAttachConst;
import com.tangmo.xizhu.customer.dao.FieldApplyDao;
import com.tangmo.xizhu.customer.dao.FieldAssignDao;
import com.tangmo.xizhu.customer.dao.TaskAttachDao;
import com.tangmo.xizhu.customer.entity.FieldApply;
import com.tangmo.xizhu.customer.entity.FieldAssign;
import com.tangmo.xizhu.customer.entity.TaskAttach;
import com.tangmo.xizhu.customer.entity.converter.FieldApplyConverter;
import com.tangmo.xizhu.customer.entity.converter.TaskAttachConverter;
import com.tangmo.xizhu.customer.service.FieldAssignService;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description: 现场服务指派单service实现类
 **/
@Service("fieldAssignService")
public class FieldAssignServiceImpl implements FieldAssignService {

    @Resource
    private FieldAssignDao fieldAssignDao;
    @Resource
    private TaskAttachDao taskAttachDao;
    @Resource
    private FieldApplyDao fieldApplyDao;
    @Override
    public HttpResult addFieldAssign(FieldAssign fieldAssign) {
        String uuid = EncryptUtil.get32Uuid();
        fieldAssign.setUuid(uuid);
        fieldAssignDao.insertAssign(fieldAssign);
        List<String> picture = fieldAssign.getDetailPictureList();
        List<TaskAttach> list = TaskAttachConverter.String2Entity(picture, uuid, TaskAttachConst.FIELD_ASSIGN,
                TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
        if(list != null){
            taskAttachDao.insertBatchAttach(list);
        }
        return HttpResult.success();
    }

    @Override
    public HttpResult changeFieldAssign(FieldAssign fieldAssign) {
        fieldAssignDao.updateAssign(fieldAssign);
        return HttpResult.success();
    }

    @Override
    public HttpResult getByTaskId(String taskId) {
        FieldAssign fieldAssign = fieldAssignDao.selectByTaskId(taskId);
        if(fieldAssign == null){
            FieldApply fieldApply = fieldApplyDao.selectByTaskId(taskId);
            fieldAssign = FieldApplyConverter.apply2assign(fieldApply);
        }else{
            List<String> detail = taskAttachDao.selectByParentAndType(fieldAssign.getUuid(), TaskAttachConst.FIELD_ASSIGN,
                    TaskAttachConst.PICTURE,TaskAttachConst.DETAIL);
            fieldAssign.setDetailPictureList(detail);
        }
        return HttpResult.success(fieldAssign);
    }
}
