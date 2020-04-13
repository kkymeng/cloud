package com.db.cloud.service;

import com.db.cloud.entity.po.AccessData;

/**
 * @author yunkk
 * @description 日志记录服务
 */
public interface ILogService {

    /**
     * 记录日志服务
     * @param accessData
     */
    void logService(AccessData accessData);
}
