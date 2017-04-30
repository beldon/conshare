package bd.conshare.core.bean;

/**
 * 数据交互实体类
 * Created by Beldon.
 * Copyright (c) 2017, All Rights Reserved.
 * http://beldon.me
 */
public class ResData {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态描述
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 全局附加数据，字段、内容不定
     */
    private Object extra;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "ResData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", extra=" + extra +
                '}';
    }
}
