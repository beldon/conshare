package bd.conshare.core.bean;

/**
 * 对比查询，如大于，大于或等于，小于，小于或等于
 * Created by Beldon.
 * Copyright (c)  2017-01-24, All Rights Reserved.
 * http://beldon.me
 */
public class QueryCompare extends QueryDataBase {

    /**
     * 对比类型，lt:小于，gt:大于,lte:小于或等于，gte;大于或等于，eq:等于
     */
    private final String type;

    /**
     * 对比值
     */
    private String value;

    private QueryCompare(String type) {
        this.type = type;
    }


    /**
     * 大于
     */
    public static QueryCompare grater() {
        return new QueryCompare("gt");
    }

    public static QueryCompare grater(String column, String value) {
        return new QueryCompare("gt").column(column).value(value);
    }

    /**
     * 大于或等于
     *
     * @return
     */
    public static QueryCompare graterAndEquals() {
        return new QueryCompare("gte");
    }

    public static QueryCompare graterAndEquals(String column, String value) {
        return new QueryCompare("gte").column(column).value(value);
    }

    /**
     * 小于
     */
    public static QueryCompare lessThan() {
        return new QueryCompare("lt");
    }

    public static QueryCompare lessThan(String column, String value) {
        return new QueryCompare("lt").column(column).value(value);
    }

    /**
     * 小于或等于
     *
     * @return
     */
    public static QueryCompare lessThanAndEquals() {
        return new QueryCompare("lte");
    }

    public static QueryCompare lessThanAndEquals(String column, String value) {
        return new QueryCompare("lte").column(column).value(value);
    }

    public QueryCompare column(String column) {
        setColumn(column);
        return this;
    }

    public QueryCompare value(String value) {
        this.value = value;
        return this;
    }


    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
