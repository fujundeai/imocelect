package com.example.latte_ec.main;

import android.graphics.Color;

import com.example.latte_core.delegates.bottom.BaseBottomDelegate;
import com.example.latte_core.delegates.bottom.BottomItemDelegate;
import com.example.latte_core.delegates.bottom.BottomTabBean;
import com.example.latte_core.delegates.bottom.ItemBuilder;
import com.example.latte_ec.main.cart.ShopCartDelegate;
import com.example.latte_ec.main.discover.DiscoverDelegate;
import com.example.latte_ec.main.index.IndexDelegate;
import com.example.latte_ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-20
 * Time: 16:26
 */
public class EcBottomDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder itemBuilder) {
        final LinkedHashMap<BottomTabBean,BottomItemDelegate> items=new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}","主页"),new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}","分类"),new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}","发现"),new DiscoverDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}","购物车"),new ShopCartDelegate());
        items.put(new BottomTabBean("{fa-user}","我的"),new IndexDelegate());
        return itemBuilder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
