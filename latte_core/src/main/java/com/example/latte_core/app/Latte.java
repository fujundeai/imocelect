package com.example.latte_core.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-12
 * Time: 15:57
 */
public final class Latte {
    public static Configuator init(Context context){
        getConfigrations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configuator.getInstance();
    }

    private static WeakHashMap<String,Object> getConfigrations(){
        return Configuator.getInstance().getLatteConfigs();
    }
}
