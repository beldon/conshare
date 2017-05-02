package bd.conshare.web.module.user.controller;

import bd.conshare.core.bean.ResData;
import bd.conshare.core.common.controller.FrontControllerBase;
import bd.conshare.core.utils.ResDataUtils;
import bd.conshare.web.module.collect.domain.CollectCategory;
import bd.conshare.web.module.collect.service.ICollectCategoryService;
import bd.conshare.web.module.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

/**
 * Created by Beldon.
 * Copyright (c)  2017/4/30, All Rights Reserved.
 * http://beldon.me
 */
@Controller
@RequestMapping("/user")
public class UserController extends FrontControllerBase {

    @Autowired
    private ICollectCategoryService collectCategoryService;

    @RequestMapping({"/index", "/"})
    public String index(Model model) {
        String uid = getCurrentUid();
        if (StringUtils.hasText(uid)) {
            List<CollectCategory> collectCategoryList = collectCategoryService.getAllCategory(uid);
            model.addAttribute("categorys", collectCategoryList);
        }
        model.addAttribute("account", getCurrentUserAccount());
        return getTemplate("user/index");
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return getTemplate("user/welcome");
    }

    @RequestMapping("/login")
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return redirectTo("/user/index");
        }
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


    @RequestMapping("/doReg")
    @ResponseBody
    public ResData doReg(@RequestParam("account") String account, @RequestParam("password") String password) {
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            return ResDataUtils.getData(-1, "用户名或密码不能为空");
        }

        if (userService.checkAccountExit(account)) {
            return ResDataUtils.getData(-1, "该账号已存在");
        }

        Optional<User> userOptional = userService.register(account, password);
        return userOptional.map(user -> ResDataUtils.success("success", user, null)).orElseGet(() -> ResDataUtils.getData(-1, "error"));
    }
}
