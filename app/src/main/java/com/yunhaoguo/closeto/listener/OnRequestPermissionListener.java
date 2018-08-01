package com.yunhaoguo.closeto.listener;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.listener
 * 文件名:     OnRequestPermissionListener
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/1 下午4:11
 * 描述:      申请动态权限的回调
 */


public interface OnRequestPermissionListener {

    //成功
    void onSuccess(int[] result);

    //失败
    void onFailure();
}
