package bd.conshare.core.bean;

/**
 * 模糊查询
 * Created by Beldon.
 * Copyright (c)  2017-01-24, All Rights Reserved.
 * http://beldon.me
 */
public class QueryLikes extends QueryDataBase {
    /**
     * true-左模糊
     */
    private Boolean leftLike = true;
    /**
     * true-右模糊
     */
    private Boolean rightLike = true;
    /**
     * 关键字
     */
    private String keyword;

    private QueryLikes(Boolean leftLike, Boolean rightLike) {
        this.leftLike = leftLike;
        this.rightLike = rightLike;
    }

    /**
     * 全模糊查询
     *
     * @return
     */
    public static QueryLikes like() {
        return new QueryLikes(true, true);
    }

    public static QueryLikes like(String column, String keyword) {
        return new QueryLikes(true, true).column(column).keyword(keyword);
    }

    /**
     * 仅左模糊查询
     *
     * @return
     */
    public static QueryLikes leftLike() {
        return new QueryLikes(true, false);
    }

    public static QueryLikes leftLike(String column, String keyword) {
        return new QueryLikes(true, false).column(column).keyword(keyword);
    }

    /**
     * 仅右模糊查询
     *
     * @return
     */
    public static QueryLikes rightLike() {
        return new QueryLikes(false, true);
    }

    public static QueryLikes rightLike(String column, String keyword) {
        return new QueryLikes(false, true).column(column).keyword(keyword);
    }

    public QueryLikes column(String column) {
        setColumn(column);
        return this;
    }

    public QueryLikes keyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public Boolean getLeftLike() {
        return leftLike;
    }

    public Boolean getRightLike() {
        return rightLike;
    }

    public String getKeyword() {
        String key = "";
        if (leftLike) {
            key += "%";
        }
        key += keyword;
        if (rightLike) {
            key += "%";
        }
        System.out.println("key:" + key);
        return keyword;
    }
}
