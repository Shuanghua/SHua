package com.shuanghua.shua.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.shuanghua.shua.R;
import com.shuanghua.shua.view.widget.RippleButton;
import com.shuanghua.shua.view.widget.StatusBarCompat;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class WebActivity extends BaseActivity {

    @InjectView(R.id.webView)
    WebView mWebView;
    @InjectView(R.id.ll)
    LinearLayout ll;
    @InjectView(R.id.web_progress)
    ProgressBar webProgress;
    @InjectView(R.id.web_back)
    RippleButton webBack;
    @InjectView(R.id.web_in)
    RippleButton webIn;
    @InjectView(R.id.web_stop)
    RippleButton webStop;
    @InjectView(R.id.web_refresh)
    RippleButton webRefresh;
    private String url;
    private WebSettings mWebSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.inject(this);
        setToolbar();
        mWebSettings = mWebView.getSettings();
        Intent intent = getIntent();
        url = intent.getStringExtra("url");

        if (null != savedInstanceState) {
            mWebView.restoreState(savedInstanceState);
        } else {
            setWebView();
        }
        setOnClickEvent();
    }

    private void setOnClickEvent() {
        webBack.setOnClickListener(v -> mWebView.goBack());
        webIn.setOnClickListener(v -> mWebView.goForward());
        webStop.setOnClickListener(v -> mWebView.stopLoading());
        webRefresh.setOnClickListener(v -> mWebView.reload());
    }

    @Override
    protected void setToolbar() {
        StatusBarCompat.compat(this, getResources().getColor(R.color.colorPrimaryDark));
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setWebView() {
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                System.out.println("---------------------->>" + newProgress);
                if (newProgress == 100) {
                    webProgress.setVisibility(View.INVISIBLE);
                    webStop.setVisibility(View.INVISIBLE);
                } else {
                    if (View.INVISIBLE == webProgress.getVisibility()) {
                        webProgress.setVisibility(View.VISIBLE);
                        webStop.setVisibility(View.VISIBLE);
                    }
                    webProgress.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(url);
        mWebView.getSettings().setJavaScriptEnabled(true);
        //mWebSettings.setDomStorageEnabled(true);
        mWebSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        mWebSettings.setAllowFileAccess(true);
        mWebSettings.setAppCacheEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onDestroy() {
        ll.removeAllViews();
        mWebView.stopLoading();
        mWebView.removeAllViews();
        mWebView.destroy();
        mWebView = null;
        ll = null;
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mWebView.saveState(outState);
    }
}
