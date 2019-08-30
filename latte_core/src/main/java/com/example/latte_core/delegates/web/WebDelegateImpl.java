package com.example.latte_core.delegates.web;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;

import com.example.latte_core.delegates.IPageLoadListener;
import com.example.latte_core.delegates.web.chromeclient.WebChromClientImpl;
import com.example.latte_core.delegates.web.client.WebViewClientImpl;
import com.example.latte_core.delegates.web.route.RouteKeys;
import com.example.latte_core.delegates.web.route.Router;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-26
 * Time: 15:07
 */
public class WebDelegateImpl extends WebDelegate implements IUrlHandler{
    private IPageLoadListener mIPageLoadListener = null;

    public static WebDelegateImpl create(String url) {
        final Bundle args = new Bundle();
        args.putString(RouteKeys.URL.name(), url);
        final WebDelegateImpl delegate = new WebDelegateImpl();
        delegate.setArguments(args);
        return delegate;
    }

    @Override
    public Object setLayout() {
        return getWebView();
    }

    public void setPageLoadListener(IPageLoadListener listener) {
        this.mIPageLoadListener = listener;
    }

    @Override
    public IWebViewInitializer setInitializer() {
        return this;
    }

    @Override
    public IUrlHandler setUrlHandler() {
        return this;
    }

    @Override
    public WebView initWebView(WebView webView) {
        return new WebViewInitializar().createWebView(webView);
    }

    @Override
    public WebViewClient initWebViewClient() {
        final WebViewClientImpl client = new WebViewClientImpl(this);
        client.setPageLoadListener(mIPageLoadListener);
        return client;
    }

    @Override
    public WebChromeClient initWebChromClient() {
        return new WebChromClientImpl();
    }


    @Override
    public void handleUrl(WebDelegate fragment) {
        if (getUrl() != null) {
            //用原生的方式模拟Web跳转并进行页面加载
            Router.getInstance().loadPage(this, getUrl());
        }
    }
}
