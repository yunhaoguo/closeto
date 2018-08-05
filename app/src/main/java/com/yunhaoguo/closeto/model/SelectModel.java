package com.yunhaoguo.closeto.model;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.model
 * 文件名:     SelectModel
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/5 下午4:18
 * 描述:      主页下的精选页面Model
 */


public class SelectModel {

    //标题
    private String title;

    //署名
    private String author;

    //内容
    private String content;

    //最后更新时间
    private String lastUpdateTime;

    //图片地址
    private String imgUrl;

    //链接地址
    private String webUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}
