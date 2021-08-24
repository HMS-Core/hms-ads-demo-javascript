# HMS Ads Demo for JavaScript
English | [中文](README_ZH.md)
## Table of Contents

 * [Introduction](#introduction)
 * [Installation](#installation)
 * [Supported Environments](#supported-environments)
 * [Sample Code](#sample-code)
 * [Result](#result)
 * [License](#license)


## Introduction
The hms-ads-demo-javascript program demonstrates how to integrate the HMS  Ads JavaScript API into a H5 Page and display ads.

## Installation
Install the program on Huawei Android mobile phones.

## Supported Environments
HMS Core (APK) 6.0.0 or later has been installed on Huawei Android phones.

## Sample Code
The hms-ads-demo-javascript program integrates the HMS Ads JavaScript API and provides the pages for displaying banner, native, rewarded, interstitial ads respectively.
The following html in the demo are used for loading and displaying ads and collecting user comments:

1). banner.html
Loads and displays banner ads.
<br>Code location: app\src\main\assets\banner.html</br>
    
2). native.html
Loads and displays native ads.
<br>Code location: app\src\main\assets\native.html</br>
    
3). reward.html
Loads and displays rewarded ads.
<br>Code location: app\src\main\assets\reward.html</br>
	
4). interstitial.html
Loads and displays interstitial ads.
<br>Code location: app\src\main\assets\interstitial.html</br>

5). ConsentActivity.java
Collects user consent.
<br>Code location: app\src\main\java\com\huawei\hms\ads\jsdemo\ConsentActivity.java</br>    

6). ProtocolActivity.java
Collects user consent on privacy terms.
<br>Code location: app\src\main\java\com\huawei\hms\ads\jsdemo\ProtocolActivity.java</br>

## Result
Banner Ads&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp; Interstitial Ads 

 <img src=result/Banner.gif width=200>  <img src=result/Interstitial.gif width=200>  

Reward Ads&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Native Ads

<img src=result/Reward.gif width=200>    <img src=result/Native.gif width=200> 

## Question or issues
If you want to evaluate more about HMS Core,
[HMSCore on Reddit](https://www.reddit.com/r/HuaweiDevelopers/) is for you to keep up with latest news about HMS Core, and to exchange insights with other developers.

If you have questions about how to use HMS samples, try the following options:
- [Stack Overflow](https://stackoverflow.com/questions/tagged/huawei-mobile-services) is the best place for any programming questions. Be sure to tag your question with 
`huawei-mobile-services`.
- [Huawei Developer Forum](https://forums.developer.huawei.com/forumPortal/en/home?fid=0101187876626530001) HMS Core Module is great for general questions, or seeking recommendations and opinions.

If you run into a bug in our samples, please submit an [issue](https://github.com/HMS-Core/hms-ads-demo-java/issues) to the Repository. Even better you can submit a [Pull Request](https://github.com/HMS-Core/hms-ads-demo-java/pulls) with a fix.

##  License
hms-ads-demo-javascript is licensed under the [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
