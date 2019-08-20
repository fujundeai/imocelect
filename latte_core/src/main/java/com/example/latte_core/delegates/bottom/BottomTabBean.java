package com.example.latte_core.delegates.bottom;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-20
 * Time: 13:41
 * tab下按钮信息存储
 */
public final class BottomTabBean {
    private final CharSequence ICON;
    private final CharSequence TITILE;

    public BottomTabBean(CharSequence icon, CharSequence title) {
        this.ICON = icon;
        this.TITILE = title;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTitle() {
        return TITILE;
    }
}
