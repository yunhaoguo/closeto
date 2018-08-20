package com.yunhaoguo.closeto.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.yunhaoguo.closeto.utils.VersionUtils;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.base
 * 文件名:     BaseActivity
 * 创建者:     yunhaoguo
 * 创建时间:    2018/7/31 下午5:20
 * 描述:      TODO
 */


public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //添加返回键
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //阴影
        if (VersionUtils.isLollipop()) {
            getSupportActionBar().setElevation(0);
        }
    }

    /**
     * 菜单栏操作
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
