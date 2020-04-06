package com.db.cloud.service.impl;

import com.alibaba.fastjson.JSON;
import com.db.cloud.entity.po.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author yunkk
 * @description 单元测试
 */
@Slf4j
@SpringBootTest
class JumpPageServiceTest {

    @Autowired
    private JumpPageService jumpPageService;

    @Test
    void getAllAddress() {
        List<Address> addressList = jumpPageService.getAllAddress();
        Address address = new Address();
        address.setCode("20180422");
        log.info(JSON.toJSON(addressList).toString());
        assertFalse(addressList.contains(address));
    }
}