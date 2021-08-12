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

const requestBtn = document.querySelector(".request-btn");
let sizeRadioGroups = document.getElementsByName("size");
let bannerSizeList = [
  [320, 50],
  [320, 100],
  [-1, -2],
  [300, 250],
  [360, 57],
  [360, 144],
];
let bannerView = document.getElementById("banner-view");
var adManger = null;

customElements.whenDefined("ads-banner").then(() => {
  adManger = new AdManager(bannerView);
  adManger.loadAd(getBannerSize());
});

requestBtn.addEventListener(
  "click",
  () => {
    if (adManger) {
      adManger.loadAd(getBannerSize());
    }
  },
  false
);

function getBannerSize() {
  for (i = 0; i < sizeRadioGroups.length; i++) {
    if (sizeRadioGroups[i].checked) {
      return bannerSizeList[sizeRadioGroups[i].value];
    }
  }
}

function loadBannerAdByApi() {
  const bannerContainer = document.getElementById("banner-container");
  window.ppsads.ready(() => {
    const bannerAd = window.ppsads.createBannerAd({
      slotId: "testw6vs28auh3",
      width: 360,
      height: 57,
      container: bannerContainer,
    });
    bannerAd.load();
    bannerAd.onLoad(() => {
      $Toast.show("Ad loaded");
    });
    bannerAd.onError((errorCode) => {
      $Toast.show("Ad failed: " + errorCode);
    });
  });
}
