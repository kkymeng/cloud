package com.db.cloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Mybatis 配置文件
 * @author yunkk
 * @description
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.db.cloud.dao"})
public class MyBatisConfig {
}
