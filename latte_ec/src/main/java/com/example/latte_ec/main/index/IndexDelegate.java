package com.example.latte_ec.main.index;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.latte_core.delegates.bottom.BaseBottomDelegate;
import com.example.latte_core.delegates.bottom.BottomItemDelegate;
import com.example.latte_core.delegates.bottom.BottomTabBean;
import com.example.latte_core.delegates.bottom.ItemBuilder;
import com.example.latte_ec.R;

import java.util.LinkedHashMap;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-20
 * Time: 16:27
 */
public class IndexDelegate extends BottomItemDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
