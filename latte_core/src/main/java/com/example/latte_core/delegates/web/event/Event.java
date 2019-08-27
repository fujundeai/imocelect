package com.example.latte_core.delegates.web.event;

import android.content.Context;
import android.webkit.WebView;

import com.example.latte_core.delegates.LatteDelegate;
import com.example.latte_core.delegates.web.WebDelegate;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-27
 * Time: 15:08
 */
public abstract class Event implements IEvent {
    private Context mContext=null;
    private String mAction=null;
    private WebDelegate mDelegate=null;
    private String mUrl=null;
    private WebView mWebView=null;

    public WebView getWebView() {
        return mWebView;
    }

    public void setWebView(WebView mWebView) {
        this.mWebView = mWebView;
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }

    public String getAction() {
        return mAction;
    }

    public void setAction(String mAction) {
        this.mAction = mAction;
    }

    public LatteDelegate getDelegate() {
        return mDelegate;
    }

    public void setDelegate(WebDelegate mDelegate) {
        this.mDelegate = mDelegate;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
