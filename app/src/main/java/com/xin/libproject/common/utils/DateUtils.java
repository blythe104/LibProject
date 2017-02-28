package com.xin.libproject.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xin on 2017/2/28.
 * 日期工具
 *
 */

public class DateUtils {

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    /**
     * 获取选取月份的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getFisrtDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance(); // 设置年份
        cal.set(Calendar.YEAR, year); // 设置月份
        cal.set(Calendar.MONTH, month); // 获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH); // 设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay); // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayOfMonth = sdf.format(cal.getTime());
        return firstDayOfMonth;
    }

    /**
     * 获取选取月份的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, value);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /**
     * 获取年月日格式
     *
     * @param date
     * @return
     */
    public static String getYMDDate(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

}

