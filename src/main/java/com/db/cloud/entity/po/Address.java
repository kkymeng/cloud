package com.db.cloud.entity.po;

/**
 * 首页导航地址实体类
 * @author yunkk
 * @version 1.0
 * @date 2020/3/26 16:52
 */
public class Address {

    /**
     * 地址ID
     */
    Integer id;

    /**
     * 地址编码
     */
    String code;

    /**
     * 地址路径
     */
    String path;

    /**
     * 地址备注
     */
    String mark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
