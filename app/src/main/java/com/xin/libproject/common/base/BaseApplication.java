package com.xin.libproject.common.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by xin on 2017/2/24.
 */

public class BaseApplication extends Application {


    private static String cacheDir;
    public static Context applicationInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationInstance=getApplicationContext();
    }

    public static Context getAppContext() {
        return applicationInstance;
    }
}
