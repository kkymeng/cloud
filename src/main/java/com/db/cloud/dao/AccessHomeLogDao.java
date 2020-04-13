package com.db.cloud.dao;

import com.db.cloud.entity.po.AccessHomeData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author yunkk
 * @description 口令日志记录
 */
@Repository
public interface AccessHomeLogDao {

    Integer accessHomeLog(@Param("accessHomeData") AccessHomeData accessHomeData);
}
