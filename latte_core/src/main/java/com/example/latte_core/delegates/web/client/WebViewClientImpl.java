package com.example.latte_core.delegates.web.client;

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.latte_core.app.ConfigKeys;
import com.example.latte_core.app.Latte;
import com.example.latte_core.delegates.IPageLoadListener;
import com.example.latte_core.delegates.web.WebDelegate;
import com.example.latte_core.delegates.web.route.Router;
import com.example.latte_core.ui.loader.LatteLoader;
import com.example.latte_core.util.log.LatteLogger;
import com.example.latte_core.util.storage.LattePreference;

import okhttp3.Cookie;
import retrofit2.http.DELETE;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-26
 * Time: 15:37
 */
public class WebViewClientImpl extends WebViewClient {

    private final WebDelegate DELEGATE;
    private IPageLoadListener mIPageLoadListener=null;
    private final Handler HANDLER= Latte.getHandler();

    public void setPageLoadListener(IPageLoadListener listener){
        this.mIPageLoadListener=listener;
    }

    public WebViewClientImpl(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        LatteLogger.d("shouldOverrideUrlLoading",url);
        return Router.getInstance().handleWebUrl(DELEGATE,url);
    }

    //获取浏览器cookie
    private void sycnCookie(){
        final CookieManager manager=CookieManager.getInstance();
        //注意这里的cookie和api请求的cookie是不一样的，这个在网页不可见
        final String webHost=Latte.getConfiguration(ConfigKeys.WEB_HOST);
        if(webHost!=null){
            if(manager.hasCookies()){
                final String cookieStr=manager.getCookie(webHost);
                if(cookieStr!=null && !cookieStr.equals("")){
                    LattePreference.addCustomAppProfile("cookie",cookieStr);
                }
            }
        }
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if(mIPageLoadListener!=null){
            mIPageLoadListener.onLoadStart();
        }
        LatteLoader.showLoading(view.getContext());
    }

    @Override
    public void onPageFinished(WebView view, String url) {
//        sycnCookie();
        super.onPageFinished(view, url);
        if(mIPageLoadListener!=null){
            mIPageLoadListener.onLoadEnd();
        }
        HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                LatteLoader.stopLoading();
            }
        },1000);
    }
}
