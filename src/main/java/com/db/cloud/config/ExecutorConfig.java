package com.db.cloud.config;

import com.db.cloud.common.VisiableThreadPoolTaskExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author yunkk
 * @description 线程池配置
 */
@Configuration
@EnableAsync
@Slf4j
public class ExecutorConfig implements AsyncConfigurer {

    @Bean
    public Executor asyncServiceExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new VisiableThreadPoolTaskExecutor();
//        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
        // 最大线程
        threadPoolTaskExecutor.setMaxPoolSize(10);
        // 配置队列大小
        threadPoolTaskExecutor.setQueueCapacity(50);
        threadPoolTaskExecutor.setThreadNamePrefix("async-");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    // 配置异常处理机制
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler(){
        return (ex,method,params)->{
            log.error("异步线程执行失败。方法：[{}],异常信息[{}] : ", method, ex.getMessage(),ex);
        };

    }
}
