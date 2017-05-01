package bd.conshare.web.module.collect.controller;

import bd.conshare.core.bean.ResData;
import bd.conshare.core.common.controller.FrontControllerBase;
import bd.conshare.core.utils.ResDataUtils;
import bd.conshare.web.module.collect.domain.Collect;
import bd.conshare.web.module.collect.domain.CollectCategory;
import bd.conshare.web.module.collect.service.ICollectCategoryService;
import bd.conshare.web.module.collect.service.ICollectService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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

        if (StringUtils.hasText(newCategory)) {
            collectCategoryService.findOrNewByName(uid, newCategory).ifPresent(collectCategory -> collect.setCategoryId(collectCategory.getId()));
        } else if (StringUtils.hasText(categoryId)) {
            Optional<CollectCategory> categoryOptional = collectCategoryService.findById(categoryId);
            categoryOptional.ifPresent(collectCategory -> collect.setCategoryId(collectCategory.getId()));
        }

        collect.setUid(uid);
        Optional<Collect> collectOptional = collectService.addSave(collect);
        return collectOptional.map(collect1 -> ResDataUtils.success("success", collect1, null)).orElseGet(() -> ResDataUtils.getData(-1,"error"));
    }


    @RequestMapping("/favicon")
    public void favicon(@RequestParam("domain") String domain, HttpServletResponse response) {

        InputStream inputStream = null;
        ServletOutputStream outputStream = null;
        try {
            String url = "https://www.google.cn/s2/favicons?domain=" + domain;
            URL requestUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) requestUrl.openConnection();
            conn.setConnectTimeout(3 * 1000);
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            inputStream = conn.getInputStream();
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            outputStream = response.getOutputStream();
            StreamUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
