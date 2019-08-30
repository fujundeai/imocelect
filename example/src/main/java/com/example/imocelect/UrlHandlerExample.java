package com.example.imocelect;

import android.widget.Toast;

import com.example.latte_core.delegates.web.IUrlHandler;
import com.example.latte_core.delegates.web.WebDelegate;
import com.example.latte_core.delegates.web.route.Router;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-29
 * Time: 15:37
 */
public class UrlHandlerExample implements IUrlHandler {

    @Override
    public void handleUrl(WebDelegate fragment) {
        //是我们跳转新页面的url
        final String url = fragment.getUrl();
        if (url != null) {
            //用原生的方式代替浏览器的跳转，每次打开新的WebFragment
            Router.getInstance().loadPage(fragment, url);
            if (url.contains("www.baidu.com")) {
                Toast.makeText
                        (fragment.getContext(),
                                "这是百度",
                                Toast.LENGTH_SHORT).show();
            }
        }
    }
}
