package com.shuanghua.shua.view.viewHolder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.shuanghua.shua.R;
import com.shuanghua.shua.model.bean.MainListBean;

/**
 * Created by ShuangHua on 2016/3/13.
 */
public class MainListViewHolder extends BaseViewHolder<MainListBean> {

    private TextView mTitle;//标题
    private TextView mContent;//内容
    private TextView mLabel;//标签
    private TextView mDate;//日期

    public MainListViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_recycler_main);
        mTitle = $(R.id.item_main_title);
        mContent = $(R.id.item_main_content);
        mLabel = $(R.id.item_main_label);
        mDate = $(R.id.item_main_date);
    }

    @Override
    public void setData(MainListBean data) {
        mTitle.setText(R.string.string_main_title);
        mContent.setText(R.string.string_main_content);
        mLabel.setText(R.string.string_main_label);
        mDate.setText(R.string.string_main_date);
    }
}
