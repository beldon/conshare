package bd.conshare.core.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;


/**
 * Created by Beldon.
 * Copyright (c) 2017, All Rights Reserved.
 * http://beldon.me
 */
@Controller("ControllerBase")
public abstract class ControllerBase {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected ApplicationContext applicationContext;

    /**
     * 获取模板路径，控制器不同，模板路径不同，如前台的有前台的路径，后台有后台的路径
     *
     * @return
     */
    protected abstract String getTemplate(String template);

    /**
     * 发送事件通知
     *
     * @param event
     */
    protected void publishEvent(Object event) {
        if (applicationContext != null) {
            applicationContext.publishEvent(event);
        }
    }

    /**
     * log debug模式下输出info信息
     *
     * @param msg
     * @param e
     */
    protected void debugInfo(String msg, Exception e) {
        if (logger.isDebugEnabled()) {
            logger.info(msg, e);
        }
    }

    protected void debugInfo(String msg) {
        debugInfo(msg, null);
    }


    public UserDetails getCurrentUserDetails() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * 获取当前用户名称
     *
     * @return
     */
    public String getCurrentUserAccount() {
        UserDetails userDetails = getCurrentUserDetails();
        return userDetails == null ? "" : userDetails.getUsername();
    }

    /**
     * 获取当前用户id
     *
     * @return
     */
    public String getCurrentUid() {
        return "beldon";
    }

    /**
     * url跳转
     *
     * @param url
     * @return
     */
    protected String redirectTo(String url) {
        StringBuffer rto = new StringBuffer("redirect:");
        rto.append(url);
        return rto.toString();
    }

}
