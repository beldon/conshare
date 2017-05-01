package bd.conshare.web.module.collect.controller;

import bd.conshare.core.bean.ResData;
import bd.conshare.core.common.controller.FrontControllerBase;
import bd.conshare.core.utils.ResDataUtils;
import bd.conshare.web.module.collect.domain.Collect;
import bd.conshare.web.module.collect.domain.CollectCategory;
import bd.conshare.web.module.collect.service.ICollectCategoryService;
import bd.conshare.web.module.collect.service.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/user/collect")
public class CollectController extends FrontControllerBase{
    @Autowired
    private ICollectCategoryService collectCategoryService;

    @Autowired
    private ICollectService collectService;

    @RequestMapping("/collect")
    public String collect(Model model) {
        String uid = getCurrentUid();
        if (StringUtils.hasText(uid)) {
            List<CollectCategory> collectCategoryList = collectCategoryService.getAllCategory(uid);
            model.addAttribute("categorys", collectCategoryList);
        }
        return getTemplate("collect/collect");
    }


    @RequestMapping("/addCollect")
    @ResponseBody
    public ResData addCollect(@ModelAttribute("collect") Collect collect,@RequestParam(value = "categoryId",required = false) String categoryId,
                              @RequestParam(value = "newCategory",required = false) String newCategory) {
        String uid = getCurrentUid();
        collect.setUid(uid);
        Optional<Collect> collectOptional = collectService.addSave(collect);
        if (collectOptional.isPresent()) {
            return ResDataUtils.success("success", collectOptional.get(), null);
        }
        return ResDataUtils.success("success");
    }
}
