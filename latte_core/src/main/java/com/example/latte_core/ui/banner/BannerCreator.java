package com.example.latte_core.ui.banner;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.latte_core.R;
import com.example.latte_core.util.log.LatteLogger;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;



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
