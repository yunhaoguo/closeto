package com.yunhaoguo.closeto.bean;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.bean
 * 文件名:     MovieBean
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/8 下午3:13
 * 描述:      主页电影列表adapter数据源
 */


public class MovieBean {

    private String id;
    private String title;
    private String picUrl;
    private String content;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
