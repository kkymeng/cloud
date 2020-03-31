package com.db.cloud.dao;

import com.db.cloud.entity.po.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yunkk
 * @description
 */
@Repository
public interface JumpPageDao {
    /**
     * 通过code获取Address
     * @param code
     * @return Address 详细信息
     */
    Address getAddressByCode(@Param("code") String code);

    List<Address> getAllAddress();
}
