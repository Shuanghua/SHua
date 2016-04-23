package com.shuanghua.shua.app;

import android.app.Application;

import com.jude.beam.Beam;

import cn.bmob.v3.Bmob;

/**
 * Created by ShuangHua on 2016/3/10.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        Beam.init(this);//初始化MVP框架
        Bmob.initialize(this, "0c4e60a0b70e0c38a023386eb4ff9c7c");
    }
}
