package bd.conshare.web.module.user.controller;

import bd.conshare.core.bean.ResData;
import bd.conshare.core.common.controller.FrontControllerBase;
import bd.conshare.core.utils.ResDataUtils;
import bd.conshare.web.module.collect.domain.CollectCategory;
import bd.conshare.web.module.collect.service.ICollectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Beldon.
 * Copyright (c)  2017/4/30, All Rights Reserved.
 * http://beldon.me
 */
@Controller
@RequestMapping("/user")
public class UserController extends FrontControllerBase{

    @Autowired
    private ICollectCategoryService collectCategoryService;

    @RequestMapping({"/index", "/"})
    public String index(Model model) {
        String uid = getCurrentUid();
        if (StringUtils.hasText(uid)) {
            List<CollectCategory> collectCategoryList = collectCategoryService.getAllCategory(uid);
            model.addAttribute("categorys", collectCategoryList);
        }
        return getTemplate("user/index");
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return getTemplate("user/welcome");
    }

    @RequestMapping("/login")
    public String login() {
        return getTemplate("user/login");
    }

    @RequestMapping("/doLogin.json")
    @ResponseBody
    public ResData doLogin() {
        return ResDataUtils.success("success");
    }

    @RequestMapping("/reg")
    public String reg() {
        return getTemplate("user/reg");
    }
}
