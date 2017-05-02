package bd.conshare.web.module.user.domain;

import java.util.Date;

/**
 * 用户主表
 * Created by Beldon.
 * Copyright (c) 2017-05-02, All Rights Reserved.
 * 
*/
public class User {

    /**
    * 用户id
    */
    private String uid;
    /**
    * 用户账号
    */
    private String account;
    /**
    * 登录密码
    */
    private String password;
    /**
    * 用户昵称
    */
    private String nickname;
    /**
    * 头像
    */
    private String avatar;
    /**
    * 用户状态，0:正常，1:冻结，2:删除
    */
    private Long status;
    /**
    * 用户积分
    */
    private Long credits;
    /**
    * 用户创建时间
    */
    private Date regTime;
    /**
    * 创建用户id
    */
    private String creUid;
    /**
    * 用户信息更新时间
    */
    private Date updateTime;
    /**
    * 更新的用户id
    */
    private String updateUid;
    /**
    * 是否可用，1-true，0-false
    */
    private Boolean enable;
    /**
    * 是否为管理员，1-true，0-false
    */
    private Boolean admin;

    private UserProfile profile;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getCredits() {
        return credits;
    }

    public void setCredits(Long credits) {
        this.credits = credits;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getCreUid() {
        return creUid;
    }

    public void setCreUid(String creUid) {
        this.creUid = creUid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(String updateUid) {
        this.updateUid = updateUid;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }
}
