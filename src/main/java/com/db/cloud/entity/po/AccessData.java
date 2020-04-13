package com.db.cloud.entity.po;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author yunkk
 * @description 接口访问数据表
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccessData {
    /**
     * 表ID
     */
    private Integer accessId;

    /**
     * 访问主机名称
     */
    private String hostName;

    /**
     * 访问请求Ip
     */
    private String accessIp;

    /**
     * 访问请求url
     */
    private String accessUrl;

    /**
     * 访问请求类别
     */
    private String accessType;

    /**
     * 访问请求参数
     */
    private String accessArgs;

    /**
     * 请求发起时间
     */
    private LocalDateTime accessTime;
}
