package com.example.latte_core.app;

import android.content.Context;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-12
 * Time: 17:53
 */
public final class Latte {
    public static Configuator init(Context context){
        getConfigrations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configuator.getInstance();
    }

    private static HashMap<String,Object> getConfigrations(){
        return Configuator.getInstance().getLatteConfigs();
    }

    public static Context getAppoication(){
        return (Context) getConfigrations().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
