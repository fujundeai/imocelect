package com.example.latte_core.ui.recycler;

import androidx.annotation.ColorInt;

import com.choices.divider.DividerItemDecoration;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-22
 * Time: 14:52
 */
public class BaseDecoration extends DividerItemDecoration {

    private BaseDecoration(@ColorInt int color, int size) {
        setDividerLookup(new DividerLookupImpl(color,size));
    }

    public static BaseDecoration create(@ColorInt int color,int size){
        return new BaseDecoration(color,size);
    }
}
