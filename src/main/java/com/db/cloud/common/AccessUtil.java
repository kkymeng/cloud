package com.db.cloud.common;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author yunkk
 * @description 获取访问者信息
 */
@Slf4j
public final class AccessUtil {

    /**
     * 获取访问者IP
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        // 从header中获取X-real-ip
        String ip = request.getHeader("X-Real-IP");
        if (ip != null && !"".equals(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (ip != null && !"".equals(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    public static String getHostName(String ip){
        InetAddress inetAddress = null;
        try{
            inetAddress = InetAddress.getByName(ip);
            return inetAddress.getHostName();
        } catch (UnknownHostException e) {
            log.error("AccessUtil getHostName error:{0}",e);
        }
        return "";
    }
}
