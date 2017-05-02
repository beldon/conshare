package bd.conshare.web.module.user.domain;

import java.util.Date;

/**
 * 用户副表
 * Created by Beldon.
 * Copyright (c) 2017-05-02, All Rights Reserved.
 * 
*/
public class UserProfile {

    /**
    * 用户id
    */
    private String uid;
    /**
    * 用户真实姓名
    */
    private String realName;
    /**
    * 0:未知，1:男，2:女
    */
    private Long gender;
    /**
    * 用户生日
    */
    private Date birthday;
    /**
    * 用户手机号码
    */
    private String mobile;
    /**
    * 
    */
    private String qq;
    /**
    * 
    */
    private String wechat;
    /**
    * 兴趣
    */
    private String interest;
    /**
    * 个人简介
    */
    private String bio;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}
