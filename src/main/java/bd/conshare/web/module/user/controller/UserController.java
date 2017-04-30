package bd.conshare.web.module.user.controller;

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
@RequestMapping("/user")
public class UserController extends FrontControllerBase{

    @RequestMapping("/login")
    public String login() {
        return "/theme/default/user/login";
    }

    @RequestMapping("/doLogin.json")
    @ResponseBody
    public ResData doLogin() {
        return ResDataUtils.success("success");
    }
}
