package com.shuanghua.shua.presenter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.shuanghua.shua.model.bean.MainListBean;
import com.shuanghua.shua.view.viewHolder.MainListViewHolder;

import java.util.List;

/**
 * Main Adapter
 * Created by ShuangHua on 2016/3/13.
 */
public class MainListAdapter extends RecyclerArrayAdapter<MainListBean> {

    public MainListAdapter(Context context, List<MainListBean> data) {
        super(context, data);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainListViewHolder(parent);
    }
}
