package com.tangmo.xizhu.customer.entity.converter;

import com.tangmo.xizhu.customer.entity.TaskAttach;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/24
 * @Version V1.0
 * @Description: 任务附件转换器
 **/
public class TaskAttachConverter {

    /**
     * @param list	        附件id列表
     * @param parentId	    父Id
     * @param parentType	父类型
     * @param attachType	附件类型
     * @return
     * @author chen bo
     * @date 2019/10/24
     * @description: TODO
     */
    public static List<TaskAttach> String2Entity(List<String> list, String parentId, Byte parentType, Byte attachType){
        if(list == null || list.size() == 0 || parentId == null || parentType == null || attachType == null){
            return null;
        }
        List<TaskAttach> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String attachId = list.get(i);
            TaskAttach taskAttach = new TaskAttach();
            taskAttach.setAttachId(attachId);
            taskAttach.setAttachType(attachType);
            taskAttach.setParentId(parentId);
            taskAttach.setParentType(parentType);
            result.add(taskAttach);
        }
        return result;
    }
}
