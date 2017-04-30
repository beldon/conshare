package bd.conshare.web.module.collect.domain;

import java.util.Date;

/**
 * 用户收藏表
 * Created by Beldon.
 * Copyright (c) 2017-04-30, All Rights Reserved.
 * 
*/
public class Collect {

    /**
    * 收藏id
    */
    private String id;
    /**
    * 标题
    */
    private String title;
    /**
    * 描述
    */
    private String description;
    /**
    * 网址
    */
    private String url;
    /**
    * favicon
    */
    private String favicon;
    /**
    * logo链接
    */
    private String logoUrl;
    /**
    * 网页编码
    */
    private String charset;
    /**
    * 备注
    */
    private String remark;
    /**
    * 分类id
    */
    private String categoryId;
    /**
    * 用户id
    */
    private String uid;
    /**
    * 创建时间
    */
    private Date creTime;
    /**
    * 是否可用，1-true，0-false
    */
    private Boolean enable;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 是否分享，1-true，0-false
    */
    private Boolean share;
    /**
    * 点击数
    */
    private Long clientCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getCreTime() {
        return creTime;
    }

    public void setCreTime(Date creTime) {
        this.creTime = creTime;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getShare() {
        return share;
    }

    public void setShare(Boolean share) {
        this.share = share;
    }

    public Long getClientCount() {
        return clientCount;
    }

    public void setClientCount(Long clientCount) {
        this.clientCount = clientCount;
    }

}
