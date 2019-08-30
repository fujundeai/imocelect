package com.example.imocelect;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.latte_core.delegates.IPageLoadListener;
import com.example.latte_core.delegates.web.IUrlHandler;
import com.example.latte_core.delegates.web.IWebViewInitializer;
import com.example.latte_core.delegates.web.WebDelegate;
import com.example.latte_core.delegates.web.WebViewInitializar;
import com.example.latte_core.delegates.web.chromeclient.WebChromClientImpl;
import com.example.latte_core.delegates.web.route.RouteKeys;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-29
 * Time: 15:38
 */
public class WebExampleFragment extends WebDelegate implements IPageLoadListener {
    //简单工厂，让参数更加透明
    public static WebExampleFragment create(String url) {
        final Bundle args = new Bundle();
        args.putString(RouteKeys.URL.name(), url);
        final WebExampleFragment fragment =
                new WebExampleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public IWebViewInitializer setInitializer() {
        return this;
    }

    @Override
    public IUrlHandler setUrlHandler() {
        return new UrlHandlerExample();
    }

    @Override
    public Object setLayout() {
        return getWebView();
    }

    @Override
    public WebView initWebView(WebView webView) {
        return new WebViewInitializar().createWebView(webView);
    }

    @Override
    public WebViewClient initWebViewClient() {
        final WebViewClientExample client =
                new WebViewClientExample(this);
        client.setPageLoadListener(this);
        return client;
    }

    @Override
    public WebChromeClient initWebChromClient() {
        return new WebChromClientImpl();
    }


    @Override
    public void onLoadStart() {

    }

    @Override
    public void onLoadEnd() {

    }
}
