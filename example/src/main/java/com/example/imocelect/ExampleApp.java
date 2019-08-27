package com.example.imocelect;

import android.app.Application;

import com.example.imocelect.event.TestEvent;
import com.example.latte_core.app.Latte;
import com.example.latte_core.net.interceptors.DebugInterceptor;
import com.example.latte_core.net.rx.AddCookieInterceptor;
import com.example.latte_ec.database.DatabaseManager;
import com.example.latte_ec.icon.FontEcModule;
import com.facebook.stetho.Stetho;
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
                .withNativeApiHost("http://mock.fulingjie.com/mock/")
                .withInterceptor(new DebugInterceptor("test",R.raw.test))
                .withJavascriptInterface("latte")
                .withWebEvent("test",new TestEvent())  //web调用原生，原生调用web操作
                //添加cookie同步拦截器
               // .withWebHost("https://www.baidu.com/")
               // .withInterceptor(new AddCookieInterceptor())
                .configure();
        initStetho();
        DatabaseManager.getInstance().init(this);
    }

    /*
    * 数据库查看软件
    * */
    private void initStetho(){
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build()
        );
    }
}
