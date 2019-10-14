package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2019/10/13
 * @Version V1.0
 * @Description: 任务dao
 **/
@Repository
public interface TaskDao {

    List<Task> selectTest();

}
