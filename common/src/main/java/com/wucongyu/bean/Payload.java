package com.wucongyu.bean;

import java.util.Date;

/**
 * @author 吴聪宇
 * @version 1.0
 */
public class Payload<T> {
    private String id;
    private T userInfo;
    private Date expiration;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(T userInfo) {
        this.userInfo = userInfo;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}
