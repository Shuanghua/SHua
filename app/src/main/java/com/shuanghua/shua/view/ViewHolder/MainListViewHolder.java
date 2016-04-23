package com.shuanghua.shua.view.viewHolder;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.shuanghua.shua.R;
import com.shuanghua.shua.model.bean.MainListBean;

/**
 * Main ViewHolder
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

        AssetManager manager = getContext().getAssets();
        Typeface titleTTF = Typeface.createFromAsset(manager, "fonts/Roboto-Black.ttf");
        Typeface contentTTF = Typeface.createFromAsset(manager, "fonts/RobotoCondensed-Regular.ttf");

        mTitle.setTypeface(titleTTF);
        mContent.setTypeface(contentTTF);

        mTitle.setText(data.getTitle());
        mContent.setText(data.getContent());
        mLabel.setText(data.getLabel());
        mDate.setText(data.getDate());


    }
}
