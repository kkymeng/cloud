package com.db.cloud.handle;

import com.db.cloud.common.ApplicationException;
import com.db.cloud.common.Result;
import com.db.cloud.common.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理类
 * @author yunkk
 * @version 1.0
 * @date 2020/3/25 21:19
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler()
    public Result handle(Exception e){
        log.error("接口请求异常{}",e);
        if(e instanceof ApplicationException){
            ApplicationException exception = (ApplicationException)e;
            return ResultUtil.error(exception.getCode(),exception.getMessage());
        }
        return ResultUtil.error(100,"error");
    }
}
