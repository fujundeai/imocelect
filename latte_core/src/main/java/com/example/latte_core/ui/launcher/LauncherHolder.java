package com.example.latte_core.ui.launcher;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;

import com.bigkoo.convenientbanner.holder.Holder;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-15
 * Time: 11:37
 */
public class LauncherHolder implements Holder<Integer> {
    private AppCompatImageView mImageView=null;

    @Override
    public View createView(Context context) {
        mImageView=new AppCompatImageView(context);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Integer data) {
        mImageView.setBackgroundResource(data);
    }
}
