package bd.conshare.core.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by Beldon.
 * Copyright (c) 2017, All Rights Reserved.
 * http://beldon.me
 */
public abstract class ServiceBase {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected ApplicationContext applicationContext;

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

    /**
     * 获取当前登录用户id
     *
     * @return 用户id
     */
    protected String getUid() {

        return "";
    }
}
