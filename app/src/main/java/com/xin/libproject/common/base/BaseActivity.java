package com.xin.libproject.common.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

/**
 * Created by xin on 2017/2/24.
 */

public abstract class BaseActivity extends FragmentActivity {

    private static final String TAG = "BaseActivity";

    private boolean isTransparentStatus = true;

    public void setTransparentStatus(boolean transparentStatus) {
        isTransparentStatus = transparentStatus;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化界面
        initViews();
        //初始化变量
        initVariables();
        //加载数据
        loadData();

        //设置监听
        setOnClick();
    }


    /**
     * 加载布局文件
     */
    protected abstract void initViews();

    /**
     * 初始化变量，包含Intent带的数据和Activity内部的变量
     */
    protected void initVariables() {
        if (isTransparentStatus) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * 加载数据
     */
    protected void loadData() {

    }

    protected abstract void setOnClick();


}
