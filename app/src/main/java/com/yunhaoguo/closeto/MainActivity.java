package com.yunhaoguo.closeto;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.yunhaoguo.closeto.base.BasePermissionActivity;
import com.yunhaoguo.closeto.fragment.AppFragment;
import com.yunhaoguo.closeto.fragment.HomeFragment;
import com.yunhaoguo.closeto.fragment.SystemFragment;
import com.yunhaoguo.closeto.fragment.TimeFragment;
import com.yunhaoguo.closeto.fragment.WallpaperFragment;

public class MainActivity extends BasePermissionActivity implements NavigationView.OnNavigationItemSelectedListener {

    //标题栏
    private Toolbar toolbarTitle;
    //侧边栏
    private NavigationView viewNav;
    //整个drawerlayout
    private DrawerLayout dlMain;

    private FragmentManager fragmentManager;

    private HomeFragment homeFragment;
    private WallpaperFragment wallpaperFragment;
    private AppFragment appFragment;
    private SystemFragment systemFragment;
    private TimeFragment timeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();
        initView();
        initHeaderView();
    }
    //加载侧边栏头部
    private void initHeaderView() {
        View view = viewNav.getHeaderView(0);
        TextView name = view.findViewById(R.id.tv_nav_header_title);
        name.setText("郭大哥");
        TextView desc = view.findViewById(R.id.tv_nav_header_content);
        desc.setText("IT小菜鸟");
    }
    //加载标题栏
    private void initToolBar() {
        toolbarTitle = findViewById(R.id.tb_title);
        setSupportActionBar(toolbarTitle);
    }
    //加载界面
    private void initView() {
        dlMain = findViewById(R.id.dl_main);
        viewNav = findViewById(R.id.view_nav);
        viewNav.setNavigationItemSelectedListener(this);
        //去掉渲染
        viewNav.setItemIconTintList(null);
        //标题栏左侧的打开侧边栏开关
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dlMain, toolbarTitle,
                R.string.openDrawerContentDescRes, R.string.closeDrawerContentDescRes);

        //切换菜单动画
        dlMain.addDrawerListener(toggle);
        //同步状态
        toggle.syncState();


        fragmentManager = getSupportFragmentManager();
        //默认显示主页
        showHomeFragment();

    }

    //侧边栏内部item被选中后处理
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_nav_home:
                showHomeFragment();
                break;
            case R.id.menu_nav_wallpaper:
                showWallpaperFragment();
                break;
            case R.id.menu_nav_app:
                showAppFragment();
                break;
            case R.id.menu_nav_system:
                showSystemFragment();
                break;
            case R.id.menu_nav_time:
                showTimeFragment();
                break;
            case R.id.menu_nav_share:
                break;
            case R.id.menu_nav_setting:
                break;
        }
        //点击完一个item后恢复
        dlMain.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    private void showHomeFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
            transaction.add(R.id.fl_main, homeFragment);
        }
        hideAllFragments(transaction);
        transaction.show(homeFragment);
        transaction.commit();
    }

    private void showWallpaperFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (wallpaperFragment == null) {
            wallpaperFragment = new WallpaperFragment();
            transaction.add(R.id.fl_main, wallpaperFragment);
        }
        hideAllFragments(transaction);
        transaction.show(wallpaperFragment);
        transaction.commit();
    }

    private void showAppFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (appFragment == null) {
            appFragment = new AppFragment();
            transaction.add(R.id.fl_main, appFragment);
        }
        hideAllFragments(transaction);
        transaction.show(appFragment);
        transaction.commit();
    }

    private void showSystemFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (systemFragment == null) {
            systemFragment = new SystemFragment();
            transaction.add(R.id.fl_main, systemFragment);
        }
        hideAllFragments(transaction);
        transaction.show(systemFragment);
        transaction.commit();
    }

    private void showTimeFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (timeFragment == null) {
            timeFragment = new TimeFragment();
            transaction.add(R.id.fl_main, timeFragment);
        }
        hideAllFragments(transaction);
        transaction.show(timeFragment);
        transaction.commit();
    }

    private void hideAllFragments(FragmentTransaction transaction) {
        if (appFragment != null) {
            transaction.hide(appFragment);
        }
        if (wallpaperFragment != null) {
            transaction.hide(wallpaperFragment);
        }
        if (systemFragment != null) {
            transaction.hide(systemFragment);
        }
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (timeFragment != null) {
            transaction.hide(timeFragment);
        }

    }
}
