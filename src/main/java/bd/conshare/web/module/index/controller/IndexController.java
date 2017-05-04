package bd.conshare.web.module.index.controller;

import bd.conshare.core.bean.ResData;
import bd.conshare.core.common.controller.FrontControllerBase;
import bd.conshare.core.utils.ResDataUtils;
import bd.conshare.web.module.collect.service.ICollectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Beldon.
 * Copyright (c)  2017/4/30, All Rights Reserved.
 * http://beldon.me
 */
@Controller
public class IndexController extends FrontControllerBase{

    @RequestMapping({"/", "/index"})
    public String index(HttpServletRequest request, Model model) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
//        String collectJs = "javascript:(function(){var description;var desString='';var metas=document.getElementsByTagName('meta');for(var x=0,y=metas.length;x%3Cy;x++){if(metas[x].name.toLowerCase()==='description'){description=metas[x];}}if(description){desString='&amp;description='+encodeURIComponent(description.content);}var win=window.open('"+basePath+"user/collect/collect?from=webtool&amp;url='+encodeURIComponent(document.URL)+desString+'&amp;title='+encodeURIComponent(document.title)+'&amp;charset='+document.charset,'_blank');win.focus()})();";
        String collectJs = "javascript:(function(){var description;var desString='';var metas=document.getElementsByTagName('meta');for(var x=0,y=metas.length;x%3Cy;x++){if(metas[x].name.toLowerCase()==='description'){description=metas[x];}}if(description){desString='&description='+encodeURIComponent(description.content);}var win=window.open('"+basePath+"user/collect/collect?from=webtool&url='+encodeURIComponent(document.URL)+desString+'&title='+encodeURIComponent(document.title)+'&charset='+document.charset,'_blank');win.focus()})();";
        model.addAttribute("collectJs", collectJs);
        return getTemplate("index");
    }


    @RequestMapping("/test")
    @ResponseBody
    public ResData test() {
        return ResDataUtils.success("成功");
    }
}
