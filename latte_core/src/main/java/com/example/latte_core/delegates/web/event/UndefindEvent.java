package com.example.latte_core.delegates.web.event;

import com.example.latte_core.util.log.LatteLogger;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-27
 * Time: 15:21
 */
public class UndefindEvent extends Event {
    @Override
    public String excute(String params) {
        LatteLogger.e("UndefindEvent",params);
        return null;
    }
}
