package com.yunhaoguo.closeto.bean;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.bean
 * 文件名:     MusicListBean
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/6 下午3:55
 * 描述:      主页音乐列表adapter数据源
 */


public class MusicBean {

    private String title;
    private String picUrl;
    private String id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
