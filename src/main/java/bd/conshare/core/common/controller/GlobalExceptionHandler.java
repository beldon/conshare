package bd.conshare.core.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 统一异常处理类
 * Created by Beldon.
 * Copyright (c) 2017, All Rights Reserved.
 * http://beldon.me
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

}
