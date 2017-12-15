package com.exbawei.liteli.gongye.app;

import android.app.Application;


import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;



public class MyApp extends Application {
    public static MyApp mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Config.DEBUG=true;
        PlatformConfig.setQQZone("1106036236","mjFCi0oxXZKZEWJs");
        UMShareAPI.get(this);

    }
    public static MyApp getInstance() {
        return mInstance;
    }
}
