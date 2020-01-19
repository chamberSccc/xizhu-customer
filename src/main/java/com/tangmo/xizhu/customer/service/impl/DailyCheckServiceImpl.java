package com.tangmo.xizhu.customer.service.impl;

import com.tangmo.xizhu.customer.common.HttpResult;
import com.tangmo.xizhu.customer.dao.DailyCheckDao;
import com.tangmo.xizhu.customer.dao.UserDao;
import com.tangmo.xizhu.customer.entity.DailyCheck;
import com.tangmo.xizhu.customer.entity.User;
import com.tangmo.xizhu.customer.service.DailyCheckService;
import com.tangmo.xizhu.customer.util.DateUtil;
import com.tangmo.xizhu.customer.util.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chen bo
 * @Date 2020/1/15
 * @Version V1.0
 * @Description:
 **/
@Service("dailyCheckService")
public class DailyCheckServiceImpl implements DailyCheckService {
    @Resource
    private DailyCheckDao dailyCheckDao;
    @Resource
    private UserDao userDao;
    @Override
    public HttpResult addDailyPunch(DailyCheck dailyCheck) {
        dailyCheck.setUuid(EncryptUtil.get32Uuid());
        dailyCheckDao.insertDailyCheck(dailyCheck);
        return HttpResult.success();
    }

    @Override
    public HttpResult getMonthCount(String userId) {
        Integer year = DateUtil.getYear();
        Integer month = DateUtil.getMonth();
        return HttpResult.success(dailyCheckDao.selectMonthCount(userId,year,month));
    }

    @Override
    public HttpResult getUserPunch(String uuid) {
        User user = userDao.selectByUserId(uuid);
        List<DailyCheck> list =dailyCheckDao.selectByUserId(uuid);
        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        map.put("history",list);

        return HttpResult.success(map);
    }
}
