package bd.conshare.core.utils.bookmarks;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Beldon.
 * Copyright (c)  2017/5/8, All Rights Reserved.
 * http://beldon.me
 */
public class BookMarksUtils {

    /**
     * 书签解释
     *
     * @param document
     * @return
     */
    public static List<BookMarks> parse(Document document) {
        List<BookMarks> bookMarksList = new ArrayList<>();
        try {
            Elements metasDts = document.select("dt");
            for (Element dt : metasDts) {
                String categoryName = "";
                Elements dtcs = dt.children();
                List<BookMark> bookMarkList = new ArrayList<>();
                for (Element dt1 : dtcs) {
                    if ("h3".equalsIgnoreCase(dt1.nodeName())) {
                        categoryName = dt1.text();
                    } else if ("dl".equalsIgnoreCase(dt1.nodeName())) {
                        Elements dts = dt1.children();
                        for (Element dt11 : dts) {
                            if ("dt".equals(dt11.nodeName())) {
                                if ("a".equals(dt11.child(0).nodeName())) {
                                    Element a = dt11.child(0);
                                    BookMark bookMark = new BookMark();
                                    bookMark.setTitle(a.text());
                                    bookMark.setUrl(a.attr("HREF"));
                                    bookMark.setIcon(a.attr("ICON"));
                                    bookMark.setAddDate(new Date(Long.parseLong(a.attr("ADD_DATE")) * 1000));
                                    bookMarkList.add(bookMark);
                                }
                            }
                        }
                    }
                }

                if (StringUtils.hasText(categoryName) && bookMarkList.size() > 0) {
                    BookMarks bookMarks = new BookMarks();
                    bookMarks.setCategoryName(categoryName);
                    bookMarks.setBookMarks(bookMarkList);
                    bookMarksList.add(bookMarks);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookMarksList;
    }

    /**
     * 书签解释
     *
     * @param file 书签文件
     * @return
     */
    public static List<BookMarks> parse(File file) {
        try {
            return parse(Jsoup.parse(file, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static List<BookMarks> parse(InputStream inputStream) {
        try {
            return parse(Jsoup.parse(inputStream, "UTF-8", ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
