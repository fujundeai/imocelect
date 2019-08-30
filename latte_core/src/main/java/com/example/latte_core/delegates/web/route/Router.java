package com.example.latte_core.delegates.web.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.URLUtil;
import android.webkit.WebView;

import androidx.core.content.ContextCompat;

import com.example.latte_core.delegates.LatteDelegate;
import com.example.latte_core.delegates.web.WebDelegate;
import com.example.latte_core.delegates.web.WebDelegateImpl;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-26
 * Time: 15:40
 */
public class Router {
    private Router() {
    }

    private static class Holder{
        private static final Router INSTANCE=new Router();
    }

    public static Router getInstance(){
        return Holder.INSTANCE;
    }

    public final boolean handleWebUrl(WebDelegate delegate,String url){
        //如果是电话协议
        if(url.contains("tel:")){
            callPhone(delegate.getContext(),url);
            return true;
        }
        final LatteDelegate topDelegate=delegate.getTopFragment();

        final WebDelegateImpl webDelegate=WebDelegateImpl.create(url);
        topDelegate.start(webDelegate);

        return true;
    }

    private void loadWebPage(WebView webView,String url){
        if(webView!=null){
            webView.loadUrl(url);
        }else {
            throw new NullPointerException("WebView is Null");
        }
    }

    private void loadLocalPage(WebView webView,String url){
        loadWebPage(webView,"file:///android_asset/"+url);
    }

    private void loadPage(WebView webView,String url){
        if(URLUtil.isNetworkUrl(url) || URLUtil.isAssetUrl(url)){
            loadWebPage(webView,url);
        }else {
            loadLocalPage(webView, url);
        }
    }

    public final void loadPage(WebDelegate delegate,String url){
        loadPage(delegate.getWebView(),url);
    }

    private void callPhone(Context context,String uri){
        final Intent intent=new Intent(Intent.ACTION_DIAL);
        final Uri data=Uri.parse(uri);
        intent.setData(data);
        context.startActivity(intent);
        ContextCompat.startActivity(context,intent,null);
    }
}
