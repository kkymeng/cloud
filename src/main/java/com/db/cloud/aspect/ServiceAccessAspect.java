package com.db.cloud.aspect;

import com.db.cloud.common.AccessUtil;
import com.db.cloud.common.Result;
import com.db.cloud.entity.po.AccessData;
import com.db.cloud.entity.po.AccessHomeData;
import com.db.cloud.entity.po.Address;
import com.db.cloud.service.ILogHomeService;
import com.db.cloud.service.ILogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @author yunkk
 * @description 服务日志访问切面
 */
@Aspect
@Component
@Slf4j
public class ServiceAccessAspect {

    @Autowired
    private ILogService logService;

    @Autowired
    private ILogHomeService iLogHomeService;
    /**
     * 全接口切面
     */
    @Pointcut("execution(public * com.db.cloud.controller.*.*(..))")
    public void log(){

    }
    @Pointcut("execution(public * com.db.cloud.controller.JumpPageController.getRoundAddr(..))")
    public void logHome(){

    }
    @Pointcut("execution(public * com.db.cloud.controller.JumpPageController.getAdderByCode(..))")
    public void logHome2(){

    }
    @Before("log()")
    public void doLog(JoinPoint joinPoint){
        log.info("----接口切面日志记录start---");
        HttpServletRequest request = getHttpServletRequest();
        AccessData accessData = new AccessData();
        // 获取IP
        String ip = AccessUtil.getIpAddr(request);
        accessData.setHostName(AccessUtil.getHostName(ip));
        accessData.setAccessIp(ip);
        accessData.setAccessArgs(joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        accessData.setAccessTime(LocalDateTime.now());
        accessData.setAccessUrl(request.getRequestURL().toString());
        try {
            logService.logService(accessData);
        } catch (Exception e) {
            log.error("----日志记录出错.{}",request.getRequestURL().toString());
        }
        log.info("----接口切面日志记录end----");
    }

    private HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes.getRequest();
    }

    /**
     * 记录随机进入进入页面日志
     * @param result
     */
    @AfterReturning(pointcut = "logHome()",returning = "result")
    public void doHomeLog(Result result){
        AccessHomeData accessHomeData = new AccessHomeData();
        accessHomeData.setRemarks("Random");
        logHome(result, accessHomeData);
    }

    private void logHome(Result result, AccessHomeData accessHomeData) {
        log.info("---aspect doHomeLog start---");
        Object object = result.getData();
        if(object instanceof Address){
            // 获取 口令code
            Address address =(Address)object;
            String code = address.getCode();
            // 获取request
            HttpServletRequest request = getHttpServletRequest();
            String ip = AccessUtil.getIpAddr(request);

            accessHomeData.setHomeCode(code);
            accessHomeData.setHomeIp(ip);

            accessHomeData.setHomeName(AccessUtil.getHostName(ip));
            try {
                iLogHomeService.logHomeService(accessHomeData);
            } catch (Exception e) {
                log.error("---口令日志记录失败---");
            }
            log.info("----aspect doHomeLog end----");
        }
    }

    /**
     * 直接进入切面记录
     * @param result
     */
    @AfterReturning(pointcut = "logHome2()",returning = "result")
    public void doHomeDirectLog(Result result){
        AccessHomeData accessHomeData = new AccessHomeData();
        accessHomeData.setRemarks("Direct");
        logHome(result, accessHomeData);
    }
}
