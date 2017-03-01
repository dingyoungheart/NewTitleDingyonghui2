package com.dingyonghui.newtitledingyonghui.util;

import java.util.Date;

/**
 * Created by cj on 2016/12/4.
 */

public class ApplicationConstants {
    private static int pageSize = 15;
    public static final String APP_KEY = "a0f19c0e92c82045c9cc4f7e716e6c33";
    public static final String URL_PICTURE = "http://japi.juhe.cn/joke/content/list.from?key="+APP_KEY;

    public static String getUrl(int currentPage) {
        String url = URL_PICTURE + "&page="+currentPage+"&pagesize="+pageSize+"&sort=asc&time="+"1418816972";
        return url;
    }

    public static String getTimeStr() {
        return String.valueOf(new Date().getTime()).substring(0,10);
    }
}
