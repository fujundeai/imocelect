package com.example.latte_ec.main.cart;

import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.latte_core.app.Latte;
import com.example.latte_core.ui.recycler.MultipleFields;
import com.example.latte_core.ui.recycler.MultipleItemEntity;
import com.example.latte_core.ui.recycler.MultipleRecyclerAdapter;
import com.example.latte_core.ui.recycler.MultipleViewHolder;
import com.example.latte_ec.R;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.List;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-28
 * Time: 13:58
 */
public class ShopCartAdapter extends MultipleRecyclerAdapter {
    private boolean mIsSelectedAll=false;

    private static final RequestOptions OPTIONS=new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .dontAnimate();

    protected ShopCartAdapter(List<MultipleItemEntity> data) {
        super(data);
        //添加购物车item布局
        addItemType(ShopCartItemType.SHOP_CART_ITEM, R.layout.item_shop_cart);
    }

    public void setIsSelectedAll(boolean isSelectedAll){
        this.mIsSelectedAll=isSelectedAll;
    }

    @Override
    protected void convert(@NonNull MultipleViewHolder holder, final MultipleItemEntity item) {
        super.convert(holder, item);
        switch (holder.getItemViewType()){
            case ShopCartItemType.SHOP_CART_ITEM:
                //先取出所有的值
                final int id=item.getField(MultipleFields.ID);
                final String thumb=item.getField(MultipleFields.IMAGE_URL);
                final String title=item.getField(ShopCartItemFields.TITLE);
                final String desc=item.getField(ShopCartItemFields.DESC);
                final int count=item.getField(ShopCartItemFields.COUNT);
                final double price=item.getField(ShopCartItemFields.PRICE);

                //取出所有控件
                final AppCompatImageView imgThumb=holder.getView(R.id.image_item_shop_cart);
                final AppCompatTextView tvTitle=holder.getView(R.id.tv_item_shop_cart_title);
                final AppCompatTextView tvDesc=holder.getView(R.id.tv_item_shop_cart_desc);
                final AppCompatTextView tvPrice=holder.getView(R.id.tv_item_shop_cart_price);
                final IconTextView iconMins=holder.getView(R.id.icon_item_minus);
                final IconTextView iconPlus=holder.getView(R.id.icon_item_plus);
                final AppCompatTextView tvCount=holder.getView(R.id.tv_item_shop_cart_count);
                final IconTextView iconIsSelected=holder.getView(R.id.icon_item_shop_cart);
                //赋值
                tvTitle.setText(title);
                tvDesc.setText(desc);
                tvPrice.setText(String.valueOf(price));
                tvCount.setText(String.valueOf(count));
                Glide.with(mContext)
                        .load(thumb)
                        .apply(OPTIONS)
                        .into(imgThumb);
                //在左侧勾渲染之前改变状态
                item.setField(ShopCartItemFields.IS_SELECTED,mIsSelectedAll);
                final boolean isSelected=item.getField(ShopCartItemFields.IS_SELECTED);
                //根据数据状态显示左侧勾
                if(isSelected){
                    iconIsSelected.setTextColor(ContextCompat.getColor(Latte.getApplicationContext(),R.color.app_main));
                }else {
                    iconIsSelected.setTextColor(Color.GRAY);
                }
                //添加左侧钩点击事件
                iconIsSelected.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final boolean currentSelected=item.getField(ShopCartItemFields.IS_SELECTED);
                        if(currentSelected){
                            iconIsSelected.setTextColor(Color.GRAY);
                            item.setField(ShopCartItemFields.IS_SELECTED,false);
                        }else {
                            iconIsSelected.setTextColor(ContextCompat.getColor(Latte.getApplicationContext(),R.color.app_main));
                            item.setField(ShopCartItemFields.IS_SELECTED,true);
                        }
                    }
                });
                break;
                default:
                    break;
        }
    }
}
