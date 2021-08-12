/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.huawei.hms.ads.jsdemo;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hms.ads.jsb.JsbConfig;
import com.huawei.hms.ads.jsb.PPSJsBridge;

/**
 * This base activity for support navigate up within activity hierarchy from the action bar.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    protected void initViews() {
        setTitle(getString(getActivityTitle()));
        try {
            initLayout();
            initWebViewSetting();
        } catch (Exception e) {
            Log.w(getTag(), "error occurs," + e.getClass().getSimpleName());
        } catch (Throwable e) {
            Log.w(getTag(), "error occurs," + e.getClass().getSimpleName());
        }
    }

    protected void initLayout() {
        setContentView(getLayout());
        mWebView = findViewById(R.id.mWebView);
    }

    public void initWebViewSetting() {
        Log.i(getTag(), "initWebViewSetting");
        if (null == mWebView) {
            Log.w(getTag(), "has no initWebViewSetting");
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mWebView.setWebContentsDebuggingEnabled(true);
        }

        WebSettings websettings = mWebView.getSettings();
        websettings.setJavaScriptEnabled(true);
        websettings.setMediaPlaybackRequiresUserGesture(false);
        websettings.setDomStorageEnabled(true);
        PPSJsBridge.init(new JsbConfig.Builder().enableUserInfo(true).enableLog(true).build());
        new PPSJsBridge(mWebView);
        mWebView.loadUrl(getLoadUrl());
        Log.i(getTag(), "initWebViewSetting end");
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    protected abstract String getTag();

    protected abstract String getLoadUrl();

    protected abstract int getLayout();

    protected abstract int getActivityTitle();
}
