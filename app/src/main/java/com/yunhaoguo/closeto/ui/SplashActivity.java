package com.yunhaoguo.closeto.ui;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.yunhaoguo.closeto.MainActivity;
import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.base.BasePermissionActivity;
import com.yunhaoguo.closeto.entity.Constant;
import com.yunhaoguo.closeto.listener.OnRequestPermissionListener;
import com.yunhaoguo.closeto.utils.SharedPrefsUtils;
import com.yunhaoguo.closeto.utils.VersionUtils;

public class SplashActivity extends BasePermissionActivity {

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.SPLASH_DELAY_CODE:
                    if (isFirstRunApp()) {
                        startActivity(new Intent(SplashActivity.this, GuideActivity.class));
                    } else {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    }
                    finish();
                    break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initPermissions();

        initView();
    }

    //动态权限申请
    private void initPermissions() {
        if (VersionUtils.isM()) {
            askPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1001, new OnRequestPermissionListener() {
                @Override
                public void onSuccess(int[] result) {

                }

                @Override
                public void onFailure() {

                }
            });
        }
    }
    //加载界面
    private void initView() {
        mHandler.sendEmptyMessageDelayed(Constant.SPLASH_DELAY_CODE, 2000);
    }

    //判断是否第一次运行
    private boolean isFirstRunApp() {
        boolean isFirst = SharedPrefsUtils.getBoolean(this, "is_first", true);
        if (isFirst) {
            SharedPrefsUtils.putBoolean(this, "is_first", false);
            return true;
        } else {
            return false;
        }
    }
}
