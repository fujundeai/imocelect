package com.example.latte_core.ui.recycler;

import com.google.auto.value.AutoValue;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-22
 * Time: 16:06
 */
@AutoValue
public abstract class RgbValue {
    public abstract int red();
    public abstract int green();
    public abstract int blue();

    public static RgbValue create(int red,int green,int blue){
        return new AutoValue_RgbValue(red,green,blue);
    }
}
