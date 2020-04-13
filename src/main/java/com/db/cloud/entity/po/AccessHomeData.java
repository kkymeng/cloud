package com.db.cloud.entity.po;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author yunkk
 * @description 首页登录数据日志记录
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccessHomeData {
    /**
     * ID
     */
    private Integer homeId;

    /**
     * 首页进入Code
     */
    private String homeCode;

    /**
     * 备注 Rondom 随机进入，Direct 口令进入
     */
    private String remarks;

    /**
     * 访问主机名称
     */
    private String homeName;

    /**
     * 访问主机IP
     */
    private String homeIp;

    /**
     * 访问时间
     */
    private LocalDateTime time;
}
