package bd.conshare.core.bean;

/**
 * 字段排序查询
 * Created by Beldon.
 * Copyright (c)  2017-01-24, All Rights Reserved.
 * http://beldon.me
 */
public class QueryOrder extends QueryDataBase {
    /**
     * 排序类型：asc|desc
     */
    private String type;

    private QueryOrder(String type) {
        this.type = type;
    }

    /**
     * 创建 type为 asc的对象
     *
     * @return
     */
    public static QueryOrder asc() {
        return new QueryOrder("asc");
    }

    public static QueryOrder asc(String column) {
        return new QueryOrder("asc").column(column);
    }


    /**
     * 创建 type为 desc的对象
     *
     * @return
     */
    public static QueryOrder desc() {
        return new QueryOrder("desc");
    }

    public static QueryOrder desc(String column) {
        return new QueryOrder("desc").column(column);
    }

    public QueryOrder property(String property) {
        super.setProperty(property);
        return this;
    }

    public QueryOrder column(String column) {
        super.setColumn(column);
        return this;
    }

    public String getType() {
        return type;
    }
}
