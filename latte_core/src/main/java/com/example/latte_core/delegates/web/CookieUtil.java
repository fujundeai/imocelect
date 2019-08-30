package com.example.latte_core.delegates.web;

import android.webkit.CookieManager;

import com.example.latte_core.app.ConfigKeys;
import com.example.latte_core.app.Latte;
import com.example.latte_core.util.storage.LattePreference;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-29
 * Time: 15:49
 */
public class CookieUtil {
    //获取浏览器cookie，并存入本地
    public static void syncCookie() {
        final CookieManager manager = CookieManager.getInstance();
        /*
          注意，这里的Cookie和API请求的Cookie是不一样的，这个在网页不可见
         */
        final String webApiHost = Latte.getConfiguration(ConfigKeys.NATIVE_API_HOST);
        if (webApiHost != null) {
            if (manager.hasCookies()) {
                final String cookieStr = manager.getCookie(webApiHost);
                if (cookieStr != null && !cookieStr.equals("")) {
                    //将WebApi都Cookie存入本地
                    LattePreference.addCustomAppProfile(ConfigKeys.COOKIE, cookieStr);
                }
            } else {
                LattePreference.removeCustomAppProfile(ConfigKeys.COOKIE);
            }
        }
    }
}
