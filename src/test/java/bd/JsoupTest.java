package bd;

import bd.conshare.core.utils.bookmarks.BookMarks;
import bd.conshare.core.utils.bookmarks.BookMarksUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Beldon.
 * Copyright (c)  2017/5/8, All Rights Reserved.
 * http://beldon.me
 */
public class JsoupTest {


    @Test
    public void test()throws Exception {
        File file = new File("D:\\test\\bookmarks_2017_5_8.html");
        Document document = Jsoup.parse(file, "UTF-8");
        System.out.println(document.body());
        Elements elements = document.select("A");

        for (Element element : elements) {
            String addTime = element.attr("ADD_DATE");
            System.out.println(element.attr("HREF"));
            System.out.println(element.attr("ADD_DATE"));
            System.out.println(element.text());

            Element parent = element.parent().parent().parent();
            parent.previousElementSibling();

            Date date = new Date(Long.valueOf(addTime)*1000);
            System.out.println(date);
        }

    }


    @Test
    public void test2() throws Exception {
        File file = new File("D:\\test\\bookmarks_17_5_8.html");

        List<BookMarks> bookMarksList = BookMarksUtils.parse(file);
        System.out.println(bookMarksList);

    }
}
