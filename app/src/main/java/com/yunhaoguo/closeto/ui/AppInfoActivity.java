package com.yunhaoguo.closeto.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.base.BaseActivity;
import com.yunhaoguo.closeto.manager.AppManager;
import com.yunhaoguo.closeto.utils.LogUtils;

public class AppInfoActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivAppInfoIcon;
    private TextView tvAppInfoName;
    private TextView tvAppInfoVersion;
    private Button tvAppInfoUninstall;
    private ListView lvAppInfoPermissions;

    private String packageName;
    private String appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);
        initIntent();
        initView();


    }

    private void initIntent() {
        Intent intent = getIntent();
        appName = intent.getStringExtra("app_name");
        getSupportActionBar().setTitle(appName);
        packageName = intent.getStringExtra("package_name");
    }

    private void initView() {
        ivAppInfoIcon = findViewById(R.id.iv_app_info_icon);
        ivAppInfoIcon.setImageDrawable(AppManager.getInstance(this).getAppIcon(packageName));
        tvAppInfoName = findViewById(R.id.tv_app_info_name);
        tvAppInfoName.setText(appName);
        tvAppInfoVersion = findViewById(R.id.tv_app_info_version);
        tvAppInfoVersion.setText(AppManager.getInstance(this).getAppVersion(packageName));
        tvAppInfoUninstall = findViewById(R.id.tv_app_info_uninstall);
        lvAppInfoPermissions = findViewById(R.id.lv_app_info_permissions);
        String[] permissions =  AppManager.getInstance(this).getAppPermissions(packageName);
        if (permissions != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, permissions);
            lvAppInfoPermissions.setAdapter(adapter);
        } else {
            LogUtils.i("权限", "权限获取为空");
        }

        tvAppInfoUninstall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_app_info_uninstall:
                AppManager.getInstance(this).uninstallApp(packageName);
                finish();
                break;
        }
    }
}
