package bd.conshare.web.module.collect.controller;

import bd.conshare.core.bean.ResData;
import bd.conshare.core.common.controller.FrontControllerBase;
import bd.conshare.core.utils.ResDataUtils;
import bd.conshare.web.module.collect.domain.CollectCategory;
import bd.conshare.web.module.collect.service.ICollectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public String add(Model model) {
        model.addAttribute("category", new CollectCategory());
        return getTemplate("collectCategory/add");
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("id") String id, Model model) {
        Optional<CollectCategory> categoryOptional = collectCategoryService.findById(id);
        categoryOptional.ifPresent(collectCategory -> model.addAttribute("category", collectCategory));
        return getTemplate("collectCategory/add");
    }

    @RequestMapping("/addSave")
    @ResponseBody
    public ResData addSave(@RequestParam("name") String name, @RequestParam(value = "sort", defaultValue = "0") Integer sort) {
        Optional<CollectCategory> categoryOptional = collectCategoryService.addSave(getCurrentUid(), name, sort);
        return categoryOptional.map(collectCategory -> ResDataUtils.success("success", collectCategory, null)).orElseGet(() -> ResDataUtils.getData(-1, "error"));
    }

    @RequestMapping("/editSave")
    @ResponseBody
    public ResData editSave(@ModelAttribute("collectCategory") CollectCategory collectCategory) {
        if (StringUtils.isEmpty(collectCategory.getId())) {
            return ResDataUtils.getData(-1, "分类id不能为空");
        }
        if (StringUtils.isEmpty(collectCategory.getName())) {
            return ResDataUtils.getData(-1, "分类名字不能为空");
        }

        String uid = getCurrentUid();
        Optional<CollectCategory> categoryOptional = collectCategoryService.findById(collectCategory.getId());
        if (categoryOptional.isPresent()) {
            CollectCategory category = categoryOptional.get();
            if (!uid.equals(category.getUid())) {
                return ResDataUtils.getData(-1, "无权限");
            }else{
                category.setName(collectCategory.getName());
                category.setSort(collectCategory.getSort());
                collectCategoryService.editSave(category);
                return ResDataUtils.success("success");
            }
        }

        return ResDataUtils.getData(-1, "error");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResData delete(@RequestParam("id") String id) {
        Optional<CollectCategory> categoryOptional = collectCategoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return ResDataUtils.getData(-1, "找不到要删除的分类");
        }
        CollectCategory category = categoryOptional.get();
        if (!getCurrentUid().equals(category.getUid())) {
            return ResDataUtils.getData(-1, "无权限");
        }
        collectCategoryService.delete(id);
        return ResDataUtils.success("success");
    }
}
