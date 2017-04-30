package bd.conshare.core.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询实体类
 * Created by Beldon.
 * Copyright (c)  2017-01-24, All Rights Reserved.
 * http://beldon.me
 */
public class Query {
    /**
     * 要查询的实体类
     */
    private Object domain;
    /**
     * 排序
     */
    private List<QueryOrder> orders;

    /**
     * 与模糊查询
     */
    private List<QueryLikes> andLikes;

    /**
     * 或模板查询
     */
    private List<QueryLikes> orLikes;

    private List<QueryCompare> compares;

    private Query() {

    }

    public static Query create() {
        return new Query();
    }

    /**
     * 添加排序
     *
     * @param order 排序实体
     * @return
     */
    public Query order(QueryOrder order) {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
        return this;
    }

    public Query compare(QueryCompare compare) {
        if (compares == null) {
            compares = new ArrayList<>();
        }
        compares.add(compare);
        return this;
    }

    /**
     * 添加and模糊查询
     *
     * @param like 模糊查询
     * @return
     */
    public Query andLike(QueryLikes like) {
        if (andLikes == null) {
            andLikes = new ArrayList<>();
        }
        andLikes.add(like);
        return this;
    }

    /**
     * 添加or模糊查询
     *
     * @param like 模糊查询
     * @return
     */
    public Query orLike(QueryLikes like) {
        if (orLikes == null) {
            orLikes = new ArrayList<>();
        }
        orLikes.add(like);
        return this;
    }

    public Object getDomain() {
        return domain;
    }

    public Query domain(Object domain) {
        this.domain = domain;
        return this;
    }

    public List<QueryOrder> getOrders() {
        return orders;
    }

    public List<QueryLikes> getAndLikes() {
        return andLikes;
    }

    public List<QueryLikes> getOrLikes() {
        return orLikes;
    }

    public List<QueryCompare> getCompares() {
        return compares;
    }
}
