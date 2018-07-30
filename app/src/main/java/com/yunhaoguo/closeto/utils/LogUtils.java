package com.yunhaoguo.closeto.utils;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.utils
 * 文件名:     LogUtils
 * 创建者:     yunhaoguo
 * 创建时间:    2018/7/30 下午7:20
 * 描述:      Log封装
 */


import android.util.Log;

public class LogUtils {
    //开关
    private static final boolean IS_DEBUG = true;
    //标记
    private static final String TAG = "CloseTo";

    //log方法
    public static void i(String tag, String text) {
        if (IS_DEBUG) {
            Log.i(tag, text);
        }
    }
    public static void w(String tag, String text) {
        if (IS_DEBUG) {
            Log.w(tag, text);
        }
    }
    public static void v(String tag, String text) {
        if (IS_DEBUG) {
            Log.v(tag, text);
        }
    }
    public static void e(String tag, String text) {
        if (IS_DEBUG) {
            Log.e(tag, text);
        }
    }
    public static void d(String tag, String text) {
        if (IS_DEBUG) {
            Log.d(tag, text);
        }
    }
}
