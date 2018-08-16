package com.yunhaoguo.closeto.model;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.model
 * 文件名:     FileBrowseModel
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/15 上午10:46
 * 描述:      文件浏览模型
 */


import android.graphics.drawable.Drawable;

public class FileBrowseModel {

    private String title;
    private String path;
    private Drawable icon;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
