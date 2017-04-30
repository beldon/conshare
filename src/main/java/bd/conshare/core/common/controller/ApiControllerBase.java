package bd.conshare.core.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * api路径为 /api
 * Created by Beldon.
 * Copyright (c) 2017, All Rights Reserved.
 * http://beldon.me
 */
@Controller("ApiControllerBase")
@RequestMapping("/api")
public abstract class ApiControllerBase extends ControllerBase {
    @Override
    protected String getTemplate(String template) {
        throw new RuntimeException("此路不通");
    }
}
