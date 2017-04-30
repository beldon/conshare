package bd.conshare.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * Created by Beldon.
 * Copyright (c) 2016/11/23, All Rights Reserved.
 * http://beldon.me
 */
public class SSUtils {
    private final static Pattern humpPattern = Pattern.compile("[A-Z]");
    /**
     * 驼峰转下划线
     */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
