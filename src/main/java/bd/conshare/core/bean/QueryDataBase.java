package bd.conshare.core.bean;

/**
 * Created by Beldon.
 * Copyright (c)  2017-01-24, All Rights Reserved.
 * http://beldon.me
 */
public abstract class QueryDataBase {
    /**
     * 实体类属性名，如果存在，最终会转为column
     */
    private String property;

    /**
     * 数据库对应的字段名
     */
    private String column;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
}
