package bd.conshare.core.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台路径为 /sys
 * Created by Beldon.
 * Copyright (c) 2017, All Rights Reserved.
 * http://beldon.me
 */
@Controller("SysControllerBase")
@RequestMapping("/sys")
public abstract class SysControllerBase extends ControllerBase {
    @Override
    protected String getTemplate(String template) {
        return "sys/" + template;
    }
}
