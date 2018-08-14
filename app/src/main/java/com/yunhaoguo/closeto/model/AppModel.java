package com.yunhaoguo.closeto.model;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.model
 * 文件名:     AppModel
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/13 下午5:01
 * 描述:      应用模型
 */


import android.graphics.drawable.Drawable;

public class AppModel {
    //icon
    private Drawable icon;
    //名字
    private String appName;
    //大小
    private String appSize;
    //是否系统应用
    private boolean isSys = false;
    //包名
    private String packageName;

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppSize() {
        return appSize;
    }

    public void setAppSize(String appSize) {
        this.appSize = appSize;
    }

    public boolean isSys() {
        return isSys;
    }

    public void setSys(boolean sys) {
        isSys = sys;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
