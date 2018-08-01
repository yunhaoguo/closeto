package com.yunhaoguo.closeto.base;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.yunhaoguo.closeto.listener.OnRequestPermissionListener;

import java.util.ArrayList;
import java.util.List;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.base
 * 文件名:     BasePermissionActivity
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/1 下午4:13
 * 描述:      动态权限申请基类Activity
 */


public class BasePermissionActivity extends AppCompatActivity {

    private List<String> unPermittedList = new ArrayList<>();

    private int requestCode;

    private OnRequestPermissionListener listener;

    //请求权限
    protected void askPermissions(String[] permissions, int requestCode, OnRequestPermissionListener listener) {
        if (permissions != null && permissions.length != 0) {
            this.requestCode = requestCode;
            this.listener = listener;
            for (int i = 0; i < permissions.length; i++) {
                if (!isPermissionGranted(permissions[i])) {
                    unPermittedList.add(permissions[i]);
                }
            }
            String[] newPermissions = unPermittedList.toArray(new String[unPermittedList.size()]);
            ActivityCompat.requestPermissions(this, newPermissions, requestCode);
        }
    }

    private boolean isPermissionGranted(String permission) {
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (this.requestCode == requestCode && listener != null) {
            if (grantResults.length > 0) {
                this.listener.onSuccess(grantResults);
            } else {
                this.listener.onFailure();
            }
        }
    }
}
