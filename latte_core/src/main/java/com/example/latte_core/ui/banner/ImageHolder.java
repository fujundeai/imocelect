package com.example.latte_core.ui.banner;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.ImageViewCompat;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.latte_core.R;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-21
 * Time: 16:25
 */
public class ImageHolder implements Holder<String> {
    private AppCompatImageView mImageVIew=null;


    @Override
    public View createView(Context context) {
        mImageVIew=new AppCompatImageView(context);
        return mImageVIew;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        Glide.with(context)
                .load(data)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .centerCrop()
                .into(mImageVIew);
    }
}
