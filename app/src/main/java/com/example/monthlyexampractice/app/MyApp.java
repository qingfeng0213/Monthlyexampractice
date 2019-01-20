package com.example.monthlyexampractice.app;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //UMeng初始化
        UMConfigure.init(this,"5c3588f9b465f57a11000399","小米",UMConfigure.DEVICE_TYPE_PHONE,"");
        UMConfigure.setLogEnabled(true);
        UMShareAPI.get(this);
        PlatformConfig.setQQZone("1106036236","mjFCi0oxXZKZEWJs");
    }
}
