package bd.conshare.core.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;


/**
 * 前端控制器父类
 * Created by Beldon.
 * Copyright (c) 2017, All Rights Reserved.
 * http://beldon.me
 */
@Controller("FrontControllerBase")
public abstract class FrontControllerBase extends ControllerBase {
    @Override
    protected String getTemplate(String template) {
        return "theme/" + getTheme() + "/" + template;
    }

    /**
     * 获取模板，默认是default，为后期模板开发做准备
     *
     * @return
     */
    protected String getTheme() {
        return "default";
    }
}
