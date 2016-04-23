package com.shuanghua.shua.view.activity;

import android.os.Bundle;

import com.jude.beam.bijection.BeamAppCompatActivity;

/**
 * Created by ShuangHua on 2016/3/11.
 */
public abstract class BaseActivity extends BeamAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected abstract void setToolbar();
}
