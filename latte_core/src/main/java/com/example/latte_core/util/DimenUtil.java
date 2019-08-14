package com.example.latte_core.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.latte_core.app.Latte;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-14
 * Time: 13:54
 */
public class DimenUtil {
    public static int getScreenWidth(){
        final Resources resources= Latte.getApplicationContext().getResources();
        final DisplayMetrics metrics=resources.getDisplayMetrics();
        return metrics.widthPixels;
    }

    public static int getScreenHeight(){
        final Resources resources= Latte.getApplicationContext().getResources();
        final DisplayMetrics metrics=resources.getDisplayMetrics();
        return metrics.heightPixels;
    }
}
