package com.yunhaoguo.closeto.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.ui.FileBrowseActivity;
import com.yunhaoguo.closeto.ui.ScreenCheckActivity;
import com.yunhaoguo.closeto.ui.SystemInfoActivity;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.fragment
 * 文件名:     SystemFragment
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/2 下午7:07
 * 描述:      系统fragment
 */


public class SystemFragment extends Fragment implements View.OnClickListener {

    private LinearLayout llScreenCheck;
    private LinearLayout llFileManage;
    private LinearLayout llSystemInfo;


    private ProgressBar pbBattery;
    private TextView tvBatteryInfo;
    private TextView tvBatteryHealth;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_system, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        pbBattery = view.findViewById(R.id.pb_system_battery);
        pbBattery.setMax(100);

        tvBatteryInfo = view.findViewById(R.id.tv_system_battery_info);
        tvBatteryHealth = view.findViewById(R.id.tv_system_battery_health);

        llScreenCheck = view.findViewById(R.id.ll_screen_check);
        llScreenCheck.setOnClickListener(this);

        llFileManage = view.findViewById(R.id.ll_file_manage);
        llFileManage.setOnClickListener(this);

        llSystemInfo = view.findViewById(R.id.ll_system_info);
        llSystemInfo.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.ll_screen_check:
                intent.setClass(getActivity(), ScreenCheckActivity.class);
                break;
            case R.id.ll_file_manage:
                intent.setClass(getActivity(), FileBrowseActivity.class);
                break;
            case R.id.ll_system_info:
                intent.setClass(getActivity(), SystemInfoActivity.class);
        }
        startActivity(intent);
    }




}
