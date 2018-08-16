package com.yunhaoguo.closeto.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
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

    private BatteryInfoReceiver receiver;

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
    }

    @Override
    public void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        receiver = new BatteryInfoReceiver();
        getActivity().registerReceiver(receiver, filter);
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(receiver);
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
        }
        startActivity(intent);
    }

    class BatteryInfoReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            loadBatteryStatus(intent);




        }
    }

    //加载电池状态
    private void loadBatteryStatus(Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, BatteryManager.BATTERY_STATUS_DISCHARGING);
        int health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, BatteryManager.BATTERY_HEALTH_GOOD);
        if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
            tvBatteryInfo.setText("充电中");
        } else {
            tvBatteryInfo.setText("未充电");
        }
        if (health == BatteryManager.BATTERY_HEALTH_GOOD) {
            tvBatteryHealth.setText("电池状态良好");
        } else if (health == BatteryManager.BATTERY_HEALTH_OVERHEAT) {
            tvBatteryHealth.setText("电池过热");
        } else if (health == BatteryManager.BATTERY_HEALTH_COLD) {
            tvBatteryHealth.setText("电池过冷");
        } else {
            tvBatteryHealth.setText("电池出现未知问题");
        }
        pbBattery.setProgress(level);
    }
}
