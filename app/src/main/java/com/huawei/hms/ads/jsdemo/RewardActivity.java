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

import android.os.Bundle;
import android.view.KeyEvent;

/**
 * Activity for displaying a rewarded ad.
 */
public class RewardActivity extends BaseActivity {
    private static final String TAG = "RewardActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    @Override
    protected String getTag() {
        return TAG;
    }

    @Override
    protected int getActivityTitle() {
        return R.string.reward_ad;
    }

    @Override
    protected String getLoadUrl() {
        return "file:///android_asset/reward.html";
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_reward;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //释放资源
        mWebView.destroy();
        mWebView = null;
    }
}