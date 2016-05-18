package com.pan.learn.meta.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by panhongwei on 2016/5/17.
 */
public class UserData implements Serializable {

    private Long userId;

    private String userName;

    private String password;

    private Timestamp updateTime;

    private Boolean del;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", updateTime=" + updateTime +
                ", del=" + del +
                '}';
    }
}
