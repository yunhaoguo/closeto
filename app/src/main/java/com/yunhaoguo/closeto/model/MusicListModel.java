package com.yunhaoguo.closeto.model;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.model
 * 文件名:     MusicListModel
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/6 下午3:26
 * 描述:      主页下音乐列表模板
 */


import java.util.List;

public class MusicListModel {

    /**
     * res : 0
     * data : ["2729","2730","2727","2728","2726","2725","2724","2723","2722","2721"]
     */

    private int res;
    private List<String> data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
