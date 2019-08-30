package com.example.latte_ec.main.sort;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.latte_core.delegates.LatteDelegate;
import com.example.latte_core.delegates.bottom.BottomItemDelegate;
import com.example.latte_ec.R;
import com.example.latte_ec.main.sort.content.ContentDelegate;
import com.example.latte_ec.main.sort.list.VerticalListDelegate;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-20
 * Time: 16:27
 */
public class SortDelegate extends BottomItemDelegate {


    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        final VerticalListDelegate listDelegate=new VerticalListDelegate();
        getSupportDelegate().loadRootFragment(R.id.vertical_list_container,listDelegate);
        //设置右侧第一个分类显示，默认显示分类一
//       replaceLoadRootFragment(R.id.sort_content_container,ContentDelegate.getInstance(1),false);
        final ContentDelegate contentDelegate=ContentDelegate.getInstance(1);
        getSupportDelegate().loadRootFragment(R.id.sort_content_container,contentDelegate);
        getSupportDelegate().replaceChildFragment(contentDelegate,false);
    }
}
