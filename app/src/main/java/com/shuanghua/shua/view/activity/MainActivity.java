package com.shuanghua.shua.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.shuanghua.shua.R;
import com.shuanghua.shua.model.bean.MainListBean;
import com.shuanghua.shua.presenter.adapter.MainListAdapter;
import com.shuanghua.shua.view.widget.StatusBarCompat;

import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.main_recyclerView)
    EasyRecyclerView mRecyclerView;

    private MainListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setRecyclerView();
        setToolbar();
    }

    @Override
    protected void setToolbar() {
        setSupportActionBar(mToolbar);
        StatusBarCompat.compat(this, getResources().getColor(R.color.colorPrimaryDark));
    }

    private void setRecyclerView() {
        mRecyclerView.setRefreshing(true, true);
        BmobQuery<MainListBean> bmobQuery = new BmobQuery<>();
        bmobQuery.findObjects(this, new FindListener<MainListBean>() {
            @Override
            public void onSuccess(List<MainListBean> data) {
                Collections.reverse(data);//倒序
                mRecyclerView.setRefreshing(false, false);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                mRecyclerView.setAdapter(mAdapter = new MainListAdapter(MainActivity.this, data));
                mAdapter.setOnItemClickListener(position -> setItemOnClick(position, data));
            }

            @Override
            public void onError(int i, String s) {
                Toast.makeText(MainActivity.this, "数据获取失败" + s, Toast.LENGTH_SHORT).show();
            }

            private void setItemOnClick(int position, List<MainListBean> data) {
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                intent.putExtra("url", data.get(position).getUrl());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
