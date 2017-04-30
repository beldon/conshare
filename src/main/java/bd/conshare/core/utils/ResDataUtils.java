package bd.conshare.core.utils;


import bd.conshare.core.bean.ResData;

/**
 * Created by Beldon.
 * Copyright (c) 2017, All Rights Reserved.
 * http://beldon.me
 */
public class ResDataUtils {

    public static ResData success(String msg) {
        return getData(0, msg);
    }

    public static ResData success(String msg, Object data, Object extra) {
        return getData(0, msg, data, extra);
    }

    public static ResData getData(Integer code, String msg) {
        return getData(code, msg, null);
    }

    public static ResData getData(Integer code, String msg, Object data) {
        return getData(code, msg, data, null);
    }

    public static ResData getData(Integer code, String msg, Object data, Object extra) {
        ResData target = new ResData();
        target.setCode(code);
        target.setMsg(msg);
        target.setData(data);
        target.setExtra(extra);
        return target;
    }
}
