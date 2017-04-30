package bd.conshare.web.module.collect.controller;

import bd.conshare.core.common.controller.FrontControllerBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Beldon.
 * Copyright (c)  2017/4/30, All Rights Reserved.
 * http://beldon.me
 */
@Controller
@RequestMapping("/user/collect/category")
public class CollectCategoryController extends FrontControllerBase {

    @RequestMapping("/list")
    public String list() {
        return getTemplate("collectCategory/list");
    }
}
