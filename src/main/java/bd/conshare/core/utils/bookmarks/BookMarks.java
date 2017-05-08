package bd.conshare.core.utils.bookmarks;

import java.util.List;

/**
 * Created by Beldon.
 * Copyright (c)  2017/5/8, All Rights Reserved.
 * http://beldon.me
 */
public class BookMarks {
    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 所有书签
     */
    private List<BookMark> bookMarks;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<BookMark> getBookMarks() {
        return bookMarks;
    }

    public void setBookMarks(List<BookMark> bookMarks) {
        this.bookMarks = bookMarks;
    }
}
