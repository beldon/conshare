package bd.conshare.web.module.collect.domain;

import java.util.Date;

/**
 * 云收藏分类表
 * Created by Beldon.
 * Copyright (c) 2017-04-30, All Rights Reserved.
 * 
*/
public class CollectCategory {

    /**
    * 收藏分类id
    */
    private String id;
    /**
    * 收藏分类名称
    */
    private String name;
    /**
    * 用户id
    */
    private String uid;
    /**
    * 父id，默认是'root'
    */
    private String pid;
    /**
    * 排序,越小越靠前
    */
    private Long sort;
    /**
    * 创建时间
    */
    private Date creTime;
    /**
    * 最后更新时间
    */
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Date getCreTime() {
        return creTime;
    }

    public void setCreTime(Date creTime) {
        this.creTime = creTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
