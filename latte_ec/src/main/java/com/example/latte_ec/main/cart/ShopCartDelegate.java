package com.example.latte_ec.main.cart;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latte_core.delegates.bottom.BottomItemDelegate;
import com.example.latte_core.net.RestClient;
import com.example.latte_core.net.callback.ISuccess;
import com.example.latte_core.ui.recycler.MultipleItemEntity;
import com.example.latte_ec.R;
import com.example.latte_ec.R2;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-27
 * Time: 17:13
 */
public class ShopCartDelegate extends BottomItemDelegate implements ISuccess {
    @BindView(R2.id.iv_shop_cart)
    RecyclerView recyclerView=null;
    ShopCartAdapter mAdapter=null;
    @BindView(R2.id.icon_shop_cart_select_all)
    IconTextView mIconSelectAll=null;
    //购物车数量标记
    private int mCurrentCount=0;
    private int mTotalCount=0;

    @OnClick(R2.id.icon_shop_cart_select_all)
    public void onClickSelectAll(){
        final int tag= (int) mIconSelectAll.getTag();
        if(tag==0){
            mIconSelectAll.setTextColor(ContextCompat.getColor(getContext(),R.color.app_main));
            mIconSelectAll.setTag(1);
            mAdapter.setIsSelectedAll(true);
            //更新RecyclerView的显示状态
            mAdapter.notifyItemRangeChanged(0,mAdapter.getItemCount());
        }else {
            mIconSelectAll.setTextColor(Color.GRAY);
            mIconSelectAll.setTag(0);
            mAdapter.setIsSelectedAll(false);
            mAdapter.notifyItemRangeChanged(0,mAdapter.getItemCount());
        }
    }

    @OnClick(R2.id.tv_top_shop_cart_remove_selected)
    public void onClickRemoveSelectedItem(){
        final List<MultipleItemEntity> data=mAdapter.getData();
        //要删除的数据
        List<MultipleItemEntity> deleteEntities=new ArrayList<>();
        for(MultipleItemEntity entity:data){
            final boolean isSelected=entity.getField(ShopCartItemFields.IS_SELECTED);
            if(isSelected){
                deleteEntities.add(entity);
            }
        }
        for(MultipleItemEntity entity:deleteEntities){
            int removePosition;
            final int entityPosition=entity.getField(ShopCartItemFields.POSITION);
            if(entityPosition>mCurrentCount-1){
                removePosition=entityPosition-(mTotalCount-mCurrentCount);
            }else {
                removePosition=entityPosition;
            }
            if(removePosition<=mAdapter.getItemCount()){
                mAdapter.remove(removePosition);
                mCurrentCount=mAdapter.getItemCount();
                //更新数据
                mAdapter.notifyItemRangeChanged(removePosition,mAdapter.getItemCount());
            }

        }
    }

    @OnClick(R2.id.tv_top_shop_cart_clear)
    public void onClickClear(){
        mAdapter.getData().clear();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_shop_cart;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mIconSelectAll.setTag(0);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        RestClient.builder()
                .url("data/shop_cart_data.json")
                .loader(getContext())
                .success(this)
                .build()
                .get();
    }

    @Override
    public void onSuccess(String response) {
        final ArrayList<MultipleItemEntity> data=new ShopCartDataConverter().setJsonData(response).convert();
        mAdapter=new ShopCartAdapter(data);
        final LinearLayoutManager manager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(mAdapter);
    }
}
