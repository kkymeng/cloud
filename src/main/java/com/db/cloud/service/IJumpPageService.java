package com.db.cloud.service;

import com.db.cloud.entity.po.Address;

import java.util.List;

/**
 * 跳转页面服务
 * @author yunkk
 * @description 跳转页面服务
 */
public interface IJumpPageService {
    /**
     * 通过code获取地址详细信息
     * @param code
     * @return 地址详细信息
     */
    Address getAddressByCode(String code);

    /***
     *  获取所有地址
     * @return
     */
    List<Address> getAllAddress();

    /**
     * 获取随机地址
     * @return
     */
    Address getRoundAddr();
}
