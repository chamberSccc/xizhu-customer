package com.tangmo.xizhu.customer.dao;

import com.tangmo.xizhu.customer.entity.DailyCheck;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author chen bo
 * @Date 2020/1/15
 * @Version V1.0
 * @Description: 日常签到dao
 **/
@Repository
public interface DailyCheckDao {

    /**
     * @param dailyCheck
     * @return
     * @author chen bo
     * @date 2020/1/15
     * @description: 增加签到
     */
    Integer insertDailyCheck(DailyCheck dailyCheck);

    /**
     * @param
     * @return
     * @author chen bo
     * @date 2020/1/15
     * @description: 按月查询各类型统计数量
     */
    List<Map<String,Object>> selectMonthCount(@Param("userId") String userId,@Param("year") Integer year,@Param("month") Integer month);

    /**
     * 查询人员打卡记录
     * @param userId
     * @return
     */
    List<DailyCheck> selectByUserId(String userId);
}
