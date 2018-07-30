package com.yunhaoguo.closeto.utils;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.utils
 * 文件名:     ScreenUtils
 * 创建者:     yunhaoguo
 * 创建时间:    2018/7/30 下午8:24
 * 描述:      屏幕封装
 */


import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.Display;
import android.view.WindowManager;

public class ScreenUtils {

    public static int width;
    public static int height;

    /**
     * 得到屏幕宽高
     * @param context
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void init(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point point = new Point();
        if (VersionUtils.isJELLY_BEAN_MR1()) {
            display.getRealSize(point);
        } else {
            display.getSize(point);
        }
        width = point.x;
        height = point.y;
    }
}
