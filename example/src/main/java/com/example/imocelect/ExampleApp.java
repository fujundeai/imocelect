package com.example.imocelect;

import android.app.Application;

import com.example.latte_core.app.Latte;
import com.example.latte_core.net.interceptors.DebugInterceptor;
import com.example.latte_ec.icon.FontEcModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-12
 * Time: 16:32
 */
public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this).withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withLoaderDelayed(1000)
                .withNativeApiHost("http://192.168.1.110")
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
                .configure();
    }
}
