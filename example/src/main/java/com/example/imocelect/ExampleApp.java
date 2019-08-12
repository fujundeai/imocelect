package com.example.imocelect;

import android.app.Application;

import com.example.latte_core.app.Latte;

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
        Latte.init(this).withAPIHost("http://192.168.1.110/").configure();
    }
}