package com.yunhaoguo.closeto.utils;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.utils
 * 文件名:     SharedPrefsUtils
 * 创建者:     yunhaoguo
 * 创建时间:    2018/7/30 下午7:58
 * 描述:      SharedPreferences封装
 */


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefsUtils {

    private static final String SP_NAME = "config";

    /**
     * 读取String
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Context context, String key, String defaultValue) {
        return context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).getString(key, defaultValue);
    }

    /**
     * 写入String
     * @param context
     * @param key
     * @param value
     */
    public static void putString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * 读取int
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(Context context, String key, int defaultValue) {
        return context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).getInt(key, defaultValue);
    }

    /**
     * 写入int
     * @param context
     * @param key
     * @param value
     */
    public static void putInt(Context context, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * 读取boolean
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(Context context,String key, boolean defaultValue) {
        return context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).getBoolean(key, defaultValue);
    }

    /**
     * 写入boolean
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * 删除一条数据
     * @param context
     * @param key
     */
    public static void delete(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * 删除全部数据
     * @param context
     */
    public static void deleteAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }

}
