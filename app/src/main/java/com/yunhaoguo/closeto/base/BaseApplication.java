package com.yunhaoguo.closeto.base;

import android.app.Application;

import com.yunhaoguo.closeto.utils.ProcessUtils;
import com.yunhaoguo.closeto.utils.ScreenUtils;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.base
 * 文件名:     BaseApplication
 * 创建者:     yunhaoguo
 * 创建时间:    2018/7/30 下午8:35
 * 描述:      基类
 */


public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //主进程初始化，防止资源重复初始化
        if (getApplicationInfo().packageName.equals(ProcessUtils.getTopProcess())) {
            init();
        }
    }

    //初始化
    private void init() {
        ScreenUtils.init(this);
    }
}
