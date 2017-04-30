package bd.conshare.web.module.index.controller;

import bd.conshare.core.bean.ResData;
import bd.conshare.core.common.controller.FrontControllerBase;
import bd.conshare.core.utils.ResDataUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Beldon.
 * Copyright (c)  2017/4/30, All Rights Reserved.
 * http://beldon.me
 */
@Controller
public class IndexController extends FrontControllerBase{


    @RequestMapping({"/", "/index"})
    public String index() {
        return getTemplate("index");
    }


    @RequestMapping("/test")
    @ResponseBody
    public ResData test() {
        return ResDataUtils.success("成功");
    }
}
