package com.db.cloud.service.impl;

import com.db.cloud.dao.AccessLogDao;
import com.db.cloud.entity.po.AccessData;
import com.db.cloud.service.ILogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author yunkk
 * @description 服务日志
 */
@Slf4j
@Service
public class LogService implements ILogService {

    private static final Integer URL_LENGTH = 30;
    private static final Integer ARGS_LENGTH = 50;

    @Autowired
    private AccessLogDao accessLogDao;

    @Override
    @Async("asyncServiceExecutor")
    public void logService(AccessData accessData) {
        log.info(Thread.currentThread().getName()+"---start");
        try {
            checkParamLength(accessData);
            Integer integer = accessLogDao.accessLog(accessData);
            if(integer<1){
                log.error("---插入日志失败----message{}",accessData.toString());
            }
        } catch (Exception e) {
            log.error("----LogService error{} ,message {}",e,accessData.toString());
        }
        log.info(Thread.currentThread().getName()+"---end");
    }

    private void checkParamLength(AccessData accessData) {
        String url = accessData.getAccessUrl();
        if(url.length()>URL_LENGTH){
            accessData.setAccessUrl(url.substring(0,URL_LENGTH));
        }
        String args = accessData.getAccessArgs();
        if(args.length()>ARGS_LENGTH){
            accessData.setAccessArgs(args.substring(0,ARGS_LENGTH));
        }
    }

}
