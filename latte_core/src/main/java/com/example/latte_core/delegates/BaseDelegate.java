package com.example.latte_core.delegates;

import android.os.Binder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.latte_core.activities.ProxyActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-13
 * Time: 14:10
 * 基类fragment封装
 */
public abstract class BaseDelegate extends SwipeBackFragment {
    @SuppressWarnings("SpellCheckingInspection")
    private Unbinder mUnbinder=null;
    public abstract Object setLayout();
    public abstract void onBindView( @Nullable Bundle savedInstanceState,View rootView);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView;
        if(setLayout() instanceof Integer){
            rootView=inflater.inflate((Integer) setLayout(),container,false);
        }else if(setLayout() instanceof View){
            rootView= (View) setLayout();
        }else {
            throw new ClassCastException("setLayout() type must be int or view!");
        }
        mUnbinder= ButterKnife.bind(this,rootView);
        onBindView(savedInstanceState,rootView);

        return rootView;
    }

    public final ProxyActivity getProxyActivity(){
        return (ProxyActivity) _mActivity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mUnbinder!=null){
            mUnbinder.unbind();
        }
    }
}
