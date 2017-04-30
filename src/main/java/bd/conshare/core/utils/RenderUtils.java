package bd.conshare.core.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Beldon.
 * Copyright (c)  2017/4/30, All Rights Reserved.
 * http://beldon.me
 */
public abstract class RenderUtils {

    private final static Logger logger = LoggerFactory.getLogger(RenderUtils.class);

    public static void renderJson(HttpServletResponse response, String json) {
        PrintWriter out = null;
        try {
            if (StringUtils.hasText(json)) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                out = response.getWriter();
                out.append(json);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("render json error", e);
            if (out != null) {
                out.close();
            }
        }
    }

    public static void renderJson(HttpServletResponse response, Object o) {
        if (o != null) renderJson(response, JSON.toJSONString(o));
    }
}
