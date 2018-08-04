package com.yunhaoguo.closeto.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.yunhaoguo.closeto.R;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.fragment
 * 文件名:     HomeFragment
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/2 下午7:01
 * 描述:      主页fragment
 */


public class HomeFragment extends Fragment implements View.OnClickListener {

    private LinearLayout bottomNavHomeLayout;
    private Button btnSelect;
    private Button btnMusic;
    private Button btnMovie;
    private Button btnMe;

    private FragmentManager fragmentManager;
    private HomeSelectFragment homeSelectFragment;
    private HomeMusicFragment homeMusicFragment;
    private HomeMovieFragment homeMovieFragment;
    private HomeMeFragment homeMeFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        bottomNavHomeLayout = view.findViewById(R.id.layout_bottom_nav_home);
        btnSelect = bottomNavHomeLayout.findViewById(R.id.btn_bottom_nav_select);
        btnSelect.setOnClickListener(this);
        btnMusic = bottomNavHomeLayout.findViewById(R.id.btn_bottom_nav_music);
        btnMusic.setOnClickListener(this);
        btnMovie = bottomNavHomeLayout.findViewById(R.id.btn_bottom_nav_movie);
        btnMovie.setOnClickListener(this);
        btnMe = bottomNavHomeLayout.findViewById(R.id.btn_bottom_nav_me);
        btnMe.setOnClickListener(this);
        btnSelect.setSelected(true);

        fragmentManager = getActivity().getSupportFragmentManager();
        showSelectFragment();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_bottom_nav_select:
                setNavBtnSelect(0);
                showSelectFragment();
                break;
            case R.id.btn_bottom_nav_music:
                setNavBtnSelect(1);
                showMusicFragment();
                break;
            case R.id.btn_bottom_nav_movie:
                setNavBtnSelect(2);
                showMovieFragment();
                break;
            case R.id.btn_bottom_nav_me:
                setNavBtnSelect(3);
                showMeFragment();
                break;
        }
    }

    //设置底部导航按钮选中状态
    private void setNavBtnSelect(int index) {
        switch (index) {
            case 0:
                btnSelect.setSelected(true);
                btnMusic.setSelected(false);
                btnMovie.setSelected(false);
                btnMe.setSelected(false);
                break;
            case 1:
                btnSelect.setSelected(false);
                btnMusic.setSelected(true);
                btnMovie.setSelected(false);
                btnMe.setSelected(false);
                break;
            case 2:
                btnSelect.setSelected(false);
                btnMusic.setSelected(false);
                btnMovie.setSelected(true);
                btnMe.setSelected(false);
                break;
            case 3:
                btnSelect.setSelected(false);
                btnMusic.setSelected(false);
                btnMovie.setSelected(false);
                btnMe.setSelected(true);
                break;
        }
    }


    private void showSelectFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (homeSelectFragment == null) {
            homeSelectFragment = new HomeSelectFragment();
            transaction.add(R.id.fl_home_main, homeSelectFragment);
        }
        hideAllFragments(transaction);
        transaction.show(homeSelectFragment);
        transaction.commit();
    }

    private void showMusicFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (homeMusicFragment == null) {
            homeMusicFragment = new HomeMusicFragment();
            transaction.add(R.id.fl_home_main, homeMusicFragment);
        }
        hideAllFragments(transaction);
        transaction.show(homeMusicFragment);
        transaction.commit();
    }

    private void showMovieFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (homeMovieFragment == null) {
            homeMovieFragment = new HomeMovieFragment();
            transaction.add(R.id.fl_home_main, homeMovieFragment);
        }
        hideAllFragments(transaction);
        transaction.show(homeMovieFragment);
        transaction.commit();
    }

    private void showMeFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (homeMeFragment == null) {
            homeMeFragment = new HomeMeFragment();
            transaction.add(R.id.fl_home_main, homeMeFragment);
        }
        hideAllFragments(transaction);
        transaction.show(homeMeFragment);
        transaction.commit();
    }

    //隐藏所有Fragments
    private void hideAllFragments(FragmentTransaction transaction) {
        if (homeSelectFragment != null) {
            transaction.hide(homeSelectFragment);
        }
        if (homeMusicFragment != null) {
            transaction.hide(homeMusicFragment);
        }
        if (homeMovieFragment != null) {
            transaction.hide(homeMovieFragment);
        }
        if (homeMeFragment != null) {
            transaction.hide(homeMeFragment);
        }
    }
}
