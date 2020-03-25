package com.db.cloud.common;

/**
 * 自定义异常类 统一异常管理
 * @author yunkk
 * @version 1.0
 * @date 2020/3/25 18:11
 */
public class ApplicationException extends RuntimeException {

    private Integer code;

    public ApplicationException() {
    }

    public ApplicationException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
