package com.xin.libproject.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;

/**
 * Created by xin on 2017/2/27.
 */

public class DensityUtil {

    private static float scale = Resources.getSystem().getDisplayMetrics().density;
    private static float scale = Resources.getSystem().getDisplayMetrics().densityDpi;

    public static int px2dip(Context context, float pxValue) {
        return (int) (pxValue / scale + 0.5F);
    }

    public static int dip2px(Context context, float dipValue) {

        return (int) (dipValue * scale + 0.5F);
    }

    public static int px2sp(Context context, float pxValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5F);
    }

    public static int sp2px(Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5F);
    }

    public static float getFontHeightOff(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (fontMetrics.descent - fontMetrics.ascent) / 2.0F - fontMetrics.descent;
    }
}
