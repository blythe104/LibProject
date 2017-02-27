package com.xin.libproject.common.utils;

/**
 * Created by xin on 2017/2/27.
 */

public class DoubleClickExit {
    private static final int THRESHOLD = 2000;// 1000ms
    /**
     * 双击退出检测, 阈值 1000ms
     */
    public static long mLastClick = 0L;

    public static boolean check() {
        long now = System.currentTimeMillis();
        boolean b = now - mLastClick < THRESHOLD;
        mLastClick = now;
        return b;
    }
}
