package com.shuanghua.shua.app;

import android.app.Application;

import com.jude.beam.Beam;

/**
 * Created by ShuangHua on 2016/3/10.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Beam.init(this);//初始化MVP框架
    }
}
