package com.yunhaoguo.closeto.manager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.manager
 * 文件名:     AppManager
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/13 下午5:00
 * 描述:      应用管理
 */
public class ScreenManager {

    private Context mContext;
    private static ScreenManager mInstance = null;
    private  WindowManager wm;
    private DisplayMetrics dm;

    private ScreenManager( Context mContext){
        this.mContext = mContext;
        wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
    }

    public static ScreenManager getInstance(Context mContext){
        if(mInstance == null){
            synchronized (ScreenManager.class){
                if(mInstance == null){
                    mInstance = new ScreenManager(mContext);
                }
            }
        }
        return mInstance;
    }

    public int getW(){
        return dm.widthPixels;
    }

    public int getH(){
        return dm.heightPixels;
    }

}
