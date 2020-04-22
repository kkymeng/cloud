package com.db.cloud.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yunkk
 * @description
 */
@Slf4j
class RandomNameUtilTest {

    @Test
    void generateName() {
        String s = RandomNameUtil.generateName();
        log.info("自动生成姓名:{}",s);
        assertFalse(s.isEmpty());
    }
}