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
import android.util.Log;
import android.widget.Toast;

import com.huawei.hms.ads.consent.bean.AdProvider;
import com.huawei.hms.ads.consent.constant.ConsentStatus;
import com.huawei.hms.ads.consent.constant.DebugNeedConsent;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.hms.ads.consent.inter.ConsentUpdateListener;
import com.huawei.hms.ads.jsdemo.dialogs.ConsentDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity for displaying consent.
 */
public class ConsentActivity extends BaseActivity implements ConsentDialog.ConsentDialogCallback {
    private static final String TAG = ConsentActivity.class.getSimpleName();

    private List<AdProvider> mAdProviders = new ArrayList<AdProvider>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.consent_settings));
        setContentView(R.layout.activity_consent);

        // Check consent status.
        checkConsentStatus();
    }

    @Override
    protected String getTag() {
        return null;
    }

    @Override
    protected String getLoadUrl() {
        return null;
    }

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected int getActivityTitle() {
        return 0;
    }

    /**
     * Check consent status.
     */
    private void checkConsentStatus() {
        Consent consentInfo = Consent.getInstance(this);

        // To ensure that a dialog box is displayed each time you access the code demo, set ConsentStatus to UNKNOWN.
        // In normal cases, the code does not need to be added.
        consentInfo.setConsentStatus(ConsentStatus.UNKNOWN);
        String testDeviceId = consentInfo.getTestDeviceId();
        consentInfo.addTestDeviceId(testDeviceId);

        // After DEBUG_NEED_CONSENT is set, ensure that the consent is required even if a device is not located in a
        // specified area.
        consentInfo.setDebugNeedConsent(DebugNeedConsent.DEBUG_NEED_CONSENT);
        consentInfo.requestConsentUpdate(new ConsentUpdateListener() {
            @Override
            public void onSuccess(ConsentStatus consentStatus, boolean isNeedConsent, List<AdProvider> adProviders) {
                Log.d(TAG, "ConsentStatus: " + consentStatus + ", isNeedConsent: " + isNeedConsent);

                // The parameter indicating whether the consent is required is returned.
                if (isNeedConsent) {
                    // If ConsentStatus is set to UNKNOWN, re-collect user consent.
                    if (consentStatus == ConsentStatus.UNKNOWN) {
                        mAdProviders.clear();
                        mAdProviders.addAll(adProviders);
                        showConsentDialog();
                    } else {
                        // If ConsentStatus is set to PERSONALIZED or NON_PERSONALIZED, no dialog box is displayed to
                        // collect user consent.

                    }
                } else {
                    // If a country does not require your app to collect user consent before displaying ads, your app
                    // can request a personalized ad directly.
                    Log.d(TAG, "User is NOT need Consent");

                }
            }

            @Override
            public void onFail(String errorDescription) {
                Log.e(TAG, "User's consent status failed to update: " + errorDescription);
                Toast
                    .makeText(ConsentActivity.this, "User's consent status failed to update: " + errorDescription,
                        Toast.LENGTH_LONG)
                    .show();

                // In this demo,if the request fails ,you can load a non-personalized ad by default.

            }
        });
    }

    /**
     * Display the consent dialog box.
     */
    private void showConsentDialog() {
        // Start to process the consent dialog box.
        ConsentDialog dialog = new ConsentDialog(this, mAdProviders);
        dialog.setCallback(this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @Override
    public void updateConsentStatus(ConsentStatus consentStatus) {

    }
}