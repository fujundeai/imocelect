package com.example.latte_core.app;

import java.util.WeakHashMap;
import java.util.logging.Handler;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-12
 * Time: 16:00
 */
public class Configuator {
    //全局信息初始化
    private static final WeakHashMap<String,Object> LATTE_CONFIGS=new WeakHashMap<>();
    private Configuator(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }

    public static Configuator getInstance(){
        return Holder.INSTANCE;
    }

    final WeakHashMap<String,Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }

    public static class Holder{
        private static final Configuator INSTANCE=new Configuator();
    }

    public final void configure(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    public final Configuator withAPIHost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }

    private void checkConfiguration(){
        final boolean isReady= (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if(!isReady){
            throw new RuntimeException("Configration is not ready");
        }
    }

    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }
}
