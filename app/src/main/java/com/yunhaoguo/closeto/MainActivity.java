package com.yunhaoguo.closeto;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.yunhaoguo.closeto.base.BasePermissionActivity;

public class MainActivity extends BasePermissionActivity implements NavigationView.OnNavigationItemSelectedListener {


    private Toolbar toolbarTitle;
    private NavigationView viewNav;
    private DrawerLayout dlMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar();
        initView();
    }

    private void initToolBar() {
        toolbarTitle = findViewById(R.id.tb_title);
        setSupportActionBar(toolbarTitle);
    }

    private void initView() {
        dlMain = findViewById(R.id.dl_main);
        viewNav = findViewById(R.id.view_nav);
        viewNav.setNavigationItemSelectedListener(this);

        //标题栏左侧的打开侧边栏开关
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dlMain, toolbarTitle,
                R.string.openDrawerContentDescRes, R.string.closeDrawerContentDescRes);

        //切换菜单动画
        dlMain.addDrawerListener(toggle);
        //同步状态
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
