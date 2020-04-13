package com.db.cloud.service;

import com.db.cloud.entity.po.AccessHomeData;

/**
 * @author yunkk
 * @description 记录入口口令日志
 */
public interface ILogHomeService {

    /**
     * 记录入口口令日志
     * @param accessHomeData
     */
    void logHomeService(AccessHomeData accessHomeData);
}
