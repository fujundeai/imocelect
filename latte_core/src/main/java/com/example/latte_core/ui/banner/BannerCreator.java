package com.example.latte_core.ui.banner;

import android.widget.AdapterView;

import androidx.arch.core.executor.DefaultTaskExecutor;
import androidx.viewpager.widget.ViewPager;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.latte_core.R;
import com.example.latte_core.util.log.LatteLogger;

import java.util.ArrayList;

import javax.xml.transform.Transformer;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-21
 * Time: 16:25
 */
public class BannerCreator {
    public static void setDefault(ConvenientBanner<String> convenientBanner, ArrayList<String> banners,
                                    OnItemClickListener clickListener){
        LatteLogger.e("TAGConvenientBanner",convenientBanner+"");
        LatteLogger.e("TAGBanners",banners+"");
        convenientBanner.setPages(new HolderCreator(),banners)
                .setPageIndicator(new int[]{R.drawable.dot_normal,R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(clickListener)
                .startTurning(3000)
                .setCanLoop(true);

    }
}
