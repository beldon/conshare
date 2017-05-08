package bd.conshare.core.utils.bookmarks;

import java.util.Date;

/**
 * Created by Beldon.
 * Copyright (c)  2017/5/8, All Rights Reserved.
 * http://beldon.me
 */
public class BookMark {
    /**
     * 链接标题
     */
    private String title;

    /**
     * 链接
     */
    private String url;

    /**
     * favicon图标
     */
    private String icon;

    /**
     * 添加时间
     */
    private Date addDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}
