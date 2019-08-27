package com.example.imocelect.event;

import android.webkit.WebView;

import com.example.latte_core.delegates.web.event.Event;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-27
 * Time: 15:51
 */
public class TestEvent extends Event {

    @Override
    public String excute(String params) {
        if(getAction().equals("test")){
            final WebView webView=getWebView();
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.evaluateJavascript("nativeCall()",null);
                }
            });
        }
        return null;
    }
}
