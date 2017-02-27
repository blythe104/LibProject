package com.xin.libproject.common.utils;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;

import com.xin.libproject.common.base.BaseApplication;


public class SharedPreferenceUtil {


    public static final String CLEAR_CACHE = "clear_cache";//清空缓存
    public static final String AUTO_UPDATE = "change_update_time"; //自动更新时长
    public static final String NOTIFICATION_MODEL = "notification_model";
    public static final String ANIM_START = "animation_start";

    private SharedPreferences mPrefs;

    private SharedPreferenceUtil() {
        mPrefs = BaseApplication.getAppContext().getSharedPreferences("setting", Context.MODE_PRIVATE);
    }

    public static SharedPreferenceUtil getInstance() {
        return SPHolder.sInstance;
    }

    public SharedPreferenceUtil putInt(String key, int value) {
        mPrefs.edit().putInt(key, value).apply();
        return this;
    }

    public int getInt(String key, int defValue) {
        return mPrefs.getInt(key, defValue);
    }

    public SharedPreferenceUtil putString(String key, String value) {
        mPrefs.edit().putString(key, value).apply();
        return this;
    }

    public String getString(String key, String defValue) {
        return mPrefs.getString(key, defValue);
    }

    public SharedPreferenceUtil putBoolean(String key, boolean value) {
        mPrefs.edit().putBoolean(key, value).apply();
        return this;
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mPrefs.getBoolean(key, defValue);
    }

    public int getAutoUpdate() {
        return mPrefs.getInt(AUTO_UPDATE, 3);
    }

    public int getNotificationModel() {
        return mPrefs.getInt(NOTIFICATION_MODEL, Notification.FLAG_ONGOING_EVENT);
    }

    //  通知栏模式 默认为常驻
    public void setNotificationModel(int t) {
        mPrefs.edit().putInt(NOTIFICATION_MODEL, t).apply();
    }

    public boolean getMainAnim() {
        return mPrefs.getBoolean(ANIM_START, false);
    }

    // 首页 Item 动画效果 默认关闭
    public void setMainAnim(boolean b) {
        mPrefs.edit().putBoolean(ANIM_START, b).apply();
    }

    private static class SPHolder {
        private static final SharedPreferenceUtil sInstance = new SharedPreferenceUtil();
    }
}
