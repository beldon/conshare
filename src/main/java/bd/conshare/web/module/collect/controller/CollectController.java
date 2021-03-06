package bd.conshare.web.module.collect.controller;

import bd.conshare.core.bean.Page;
import bd.conshare.core.bean.ResData;
import bd.conshare.core.common.controller.FrontControllerBase;
import bd.conshare.core.utils.ResDataUtils;
import bd.conshare.core.utils.bookmarks.BookMarks;
import bd.conshare.core.utils.bookmarks.BookMarksUtils;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
public class CollectController extends FrontControllerBase {
    @Autowired
    private ICollectCategoryService collectCategoryService;

    @Autowired
    private ICollectService collectService;

    @RequestMapping("/edit")
    public String edit(String id, Model model) {
        if (StringUtils.hasText(id)) {
            Optional<Collect> collectOptional = collectService.findById(id);
            if (collectOptional.isPresent()) {
                Collect collect = collectOptional.get();
                if (getCurrentUid().equals(collect.getUid())) {
                    model.addAttribute("collect", collect);
                } else {
                    model.addAttribute("collect", new Collect());
                }
            }
        }
        return getTemplate("collect/edit");
    }

    @RequestMapping("/editSave")
    @ResponseBody
    public ResData editSave(Collect collect) {
        if (StringUtils.isEmpty(collect.getId())) {
            return ResDataUtils.getData(-1, "请填入正确的id");
        }
        Optional<Collect> collectOptional = collectService.findById(collect.getId());
        if (collectOptional.isPresent()) {
            Collect temp = collectOptional.get();
            if (!getCurrentUid().equals(temp.getUid())) {
                return ResDataUtils.getData(-1, "无权限");
            }
            temp.setTitle(collect.getTitle());
            temp.setDescription(collect.getDescription());
            temp.setUrl(collect.getUrl());
            temp.setRemark(collect.getRemark());
            Optional<Collect> tempOptional = collectService.editSave(collect);
            if (tempOptional.isPresent()) {
                return ResDataUtils.success("success", tempOptional.get(), null);
            }
        }
        return ResDataUtils.getData(-1, "error");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResData delete(String id) {
        Optional<Collect> collectOptional = collectService.findById(id);
        if (collectOptional.isPresent()) {
            Collect temp = collectOptional.get();
            if (!getCurrentUid().equals(temp.getUid())) {
                return ResDataUtils.getData(-1, "无权限");
            }
            collectService.delete(id);
            return ResDataUtils.success("success");
        }
        return ResDataUtils.getData(-1, "error");
    }


    @RequestMapping("/list")
    public String list(@RequestParam(value = "id", required = false) String id, Model model) {

        CollectCategory category = null;
        if (StringUtils.hasText(id)) {
            Optional<CollectCategory> categoryOptional = collectCategoryService.findById(id);
            if (categoryOptional.isPresent()) {
                category = categoryOptional.get();
            }
        }
        if (category == null) {
            category = new CollectCategory();
            category.setName("默认列表");
        }
        model.addAttribute("category", category);
        model.addAttribute("id", id);
        return getTemplate("collect/list");
    }

    @RequestMapping("/content")
    public String content(Page page, @RequestParam(value = "catId", required = false) String catId, Model model) {
        page.setPageSize(8);
        String uid = getCurrentUid();
        if (StringUtils.hasText(uid)) {
            page = collectService.findByPage(page, uid, catId);
        }
        model.addAttribute("page", page);
        return getTemplate("collect/content");
    }


    @RequestMapping("/collect")
    public String collect(Model model) {
        String uid = getCurrentUid();
        if (StringUtils.hasText(uid)) {
            List<CollectCategory> collectCategoryList = collectCategoryService.getAllCategory(uid);
            model.addAttribute("categorys", collectCategoryList);
        }
        return getTemplate("collect/collect");
    }

    @RequestMapping("/tools")
    public String tools(HttpServletRequest request, Model model) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        String collectJs = "javascript:(function(){var description;var desString='';var metas=document.getElementsByTagName('meta');for(var x=0,y=metas.length;x%3Cy;x++){if(metas[x].name.toLowerCase()==='description'){description=metas[x];}}if(description){desString='&description='+encodeURIComponent(description.content);}var win=window.open('" + basePath + "user/collect/collect?from=webtool&url='+encodeURIComponent(document.URL)+desString+'&title='+encodeURIComponent(document.title)+'&charset='+document.charset,'_blank');win.focus()})();";
        model.addAttribute("collectJs", collectJs);
        return getTemplate("collect/tools");
    }


    @RequestMapping("/addCollect")
    @ResponseBody
    public ResData addCollect(@ModelAttribute("collect") Collect collect, @RequestParam(value = "categoryId", required = false) String categoryId,
                              @RequestParam(value = "newCategory", required = false) String newCategory) {
        String uid = getCurrentUid();

        if (StringUtils.hasText(newCategory)) {
            collectCategoryService.findOrNewByName(uid, newCategory).ifPresent(collectCategory -> collect.setCategoryId(collectCategory.getId()));
        } else if (StringUtils.hasText(categoryId)) {
            Optional<CollectCategory> categoryOptional = collectCategoryService.findById(categoryId);
            categoryOptional.ifPresent(collectCategory -> collect.setCategoryId(collectCategory.getId()));
        }

        collect.setUid(uid);
        Optional<Collect> collectOptional = collectService.addSave(collect);
        return collectOptional.map(collect1 -> ResDataUtils.success("success", collect1, null)).orElseGet(() -> ResDataUtils.getData(-1, "error"));
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
        } finally {
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


    /**
     * 导入书签
     *
     * @return
     */
    @GetMapping("/import")
    public String importBookMark() {
        return getTemplate("collect/import");
    }

    @PostMapping("/import")
    @ResponseBody
    public ResData doImportBookMarks(@RequestParam("bookMark") MultipartFile bookMark) {
        InputStream inputStream = null;
        try {
            List<BookMarks> bookMarksList = BookMarksUtils.parse(inputStream = bookMark.getInputStream());
            collectService.importBookMarks(getCurrentUid(), bookMarksList);
        } catch (IOException e) {
            e.printStackTrace();
            return ResDataUtils.getData(-1, "解析文件失败");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ResDataUtils.success("success");
    }

}
