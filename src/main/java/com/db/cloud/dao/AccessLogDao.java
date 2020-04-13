package com.db.cloud.dao;

import com.db.cloud.entity.po.AccessData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author yunkk
 * @description 日志记录dao层
 */
@Repository
public interface AccessLogDao {

    /**
     * 记录接口日志
     * @param accessData
     * @return
     */
    Integer accessLog(@Param("accessData") AccessData accessData);

}
