package com.db.cloud.service.impl;

import com.db.cloud.dao.AccessHomeLogDao;
import com.db.cloud.entity.po.AccessHomeData;
import com.db.cloud.service.ILogHomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author yunkk
 * @description 记录口令日志服务
 */
@Slf4j
@Service
public class LogHomeService implements ILogHomeService {

    @Autowired
    private AccessHomeLogDao accessHomeLogDao;

    @Override
    @Async("asyncServiceExecutor")
    public void logHomeService(AccessHomeData accessHomeData) {
        log.info(Thread.currentThread().getName()+"---start");
        try {
            Integer integer = accessHomeLogDao.accessHomeLog(accessHomeData);
            if(integer<1){
                log.error("---插入日志信息失败----");
            }
        } catch (Exception e) {
            log.error("---accessHomeLog---error.{}",e);
        }
        log.info(Thread.currentThread().getName()+"---end");

    }
}
