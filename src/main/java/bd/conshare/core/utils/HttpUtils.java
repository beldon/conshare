package bd.conshare.core.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Beldon.
 * Copyright (c)  2017/4/30, All Rights Reserved.
 * http://beldon.me
 */
public abstract class HttpUtils {

    /**
     * 判断是否是异步请求
     * @param request
     * @return true-异步请求
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if (StringUtils.hasText(requestType) && "XMLHttpRequest".equals(requestType)) {
            return true;
        }
        return false;
    }
}
