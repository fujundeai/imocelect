package com.example.latte_ec.main.sort.content;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.latte_core.delegates.LatteDelegate;
import com.example.latte_core.net.RestClient;
import com.example.latte_core.net.callback.ISuccess;
import com.example.latte_ec.R;
import com.example.latte_ec.R2;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-23
 * Time: 15:50
 */
public class ContentDelegate extends LatteDelegate {
    public static final String ARG_CONTENT_ID="CONTENT_ID";
    private int mContentId=-1;
    @BindView(R2.id.rv_list_content)
    RecyclerView mRecyclerView=null;
    private List<SectionBean> mData=null;

    public static ContentDelegate getInstance(int contentId){
        final Bundle args=new Bundle();
        args.putInt(ARG_CONTENT_ID,contentId);
        final ContentDelegate delegate=new ContentDelegate();
        delegate.setArguments(args);
        return delegate;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args=getArguments();
        if(args!=null){
            mContentId=args.getInt(ARG_CONTENT_ID);
        }
    }

    private void initData(){
        RestClient.builder()
                .url("")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        mData=new SectionDataConverter().convert(response);
                        final SectionAdapter sectionAdapter=new SectionAdapter(R.layout.item_section_content,R.layout.item_section_header,mData);
                        mRecyclerView.setAdapter(sectionAdapter);
                    }
                })
                .build()
                .get();;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_list_content;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        final StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        initData();
    }
}
