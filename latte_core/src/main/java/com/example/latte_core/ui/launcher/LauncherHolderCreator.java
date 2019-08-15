package com.example.latte_core.ui.launcher;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.example.latte_core.R;


import java.util.ArrayList;

import okhttp3.ResponseBody;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-15
 * Time: 11:36
 */
public class LauncherHolderCreator implements CBViewHolderCreator<LauncherHolder> {

    @Override
    public LauncherHolder createHolder() {
        return new LauncherHolder();
    }
}
