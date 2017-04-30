package bd.conshare.web.module.collect.controller;

import bd.conshare.core.common.controller.FrontControllerBase;
import bd.conshare.web.module.collect.domain.CollectCategory;
import bd.conshare.web.module.collect.service.ICollectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Beldon.
 * Copyright (c)  2017/4/30, All Rights Reserved.
 * http://beldon.me
 */
@Controller
@RequestMapping("/user/collect/category")
public class CollectCategoryController extends FrontControllerBase {

    @Autowired
    private ICollectCategoryService collectCategoryService;

    @RequestMapping("/list")
    public String list(Model model) {
        String uid = getCurrentUid();
        if (StringUtils.hasText(uid)) {
            List<CollectCategory> collectCategoryList = collectCategoryService.getAllCategory(uid);
            model.addAttribute("categorys", collectCategoryList);
        }
        return getTemplate("collectCategory/list");
    }

    @RequestMapping("/add")
    public String add() {
        return getTemplate("collectCategory/add");
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("id") String id, Model model) {
        return getTemplate("collectCategory/add");
    }
}
