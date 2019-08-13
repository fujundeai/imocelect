package com.example.imocelect;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.latte_core.delegates.LatteDelegate;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-13
 * Time: 15:00
 */
public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
