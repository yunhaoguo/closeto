package com.yunhaoguo.closeto.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.adapter.SystemInfoAdapter;
import com.yunhaoguo.closeto.base.BaseActivity;
import com.yunhaoguo.closeto.entity.Constant;
import com.yunhaoguo.closeto.entity.Type;
import com.yunhaoguo.closeto.manager.ScreenManager;
import com.yunhaoguo.closeto.model.SystemInfoModel;
import com.yunhaoguo.closeto.utils.FileUtils;
import com.yunhaoguo.closeto.utils.FormatUtils;
import com.yunhaoguo.closeto.utils.MacUtils;
import com.yunhaoguo.closeto.utils.VersionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 手机的基本信息：
 * - 基本信息
 * - 品牌 Android / XIAOMI
 * - 型号 Android SDK built for x86
 * - CPU型号 Core X86
 * - CPU渲染器
 * - 分辨率
 * - 后置摄像头
 * - 设备IMEI
 * - 一键ROOT
 * - 数据同步
 * - 存储信息
 * - ROM RAM
 * - CPU信息
 * - 显示信息
 * - 相机信息
 * - 电池信息
 * - OS信息
 * - NFC信息
 * - 网络信息
 * - 传感器信息
 */

public class SystemInfoActivity extends BaseActivity {

    private static final int PERMISSION_REQUEST_CODE = 102;

    private RecyclerView rvSystemInfo;
    private SystemInfoAdapter adapter;
    private List<SystemInfoModel> systemInfoList = new ArrayList<>();

    private BatteryInfoReceiver receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_info);
        if (havePermission()) {
            initView();
            initData();
        }
    }

    private boolean havePermission() {
         if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                 != PackageManager.PERMISSION_GRANTED) {
             ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_PHONE_STATE}, PERMISSION_REQUEST_CODE);
             return false;
         }
         return true;
    }

    @SuppressLint("MissingPermission")
    private void initData() {
        addTitle("基本信息");

        addContentText("品牌:", Build.MANUFACTURER);
        addContentText("型号:", Build.MODEL);
        addContentText("CPU:", Build.CPU_ABI);
        addContentText("分辨率:", ScreenManager.getInstance(this).getW() + " x " + ScreenManager.getInstance(this).getH());
        addContentText("IMEI:", ((TelephonyManager) (getSystemService(TELEPHONY_SERVICE))).getDeviceId());
        addContentText("MAC:", MacUtils.getMac(this));
        addContentButton("一键ROOT", "ROOT");
        addContentButton("数据同步", "同步");

        addTitle("存储信息");
        addContentText("总大小:", FormatUtils.formatSize(FileUtils.getSDSize(0)) + "");
        addContentText("可用大小:", FormatUtils.formatSize(FileUtils.getSDSize(1)) + "");
        addContentText("运行内存:",
                FormatUtils.formatSize(FileUtils.getAvailMemory(this, 0))
                        + " / " +
                        FormatUtils.formatSize(FileUtils.getAvailMemory(this, 1)));

        addTitle("电池");
        addContentText("电量", Constant.BATTERY_T);
        addContentText("温度", Constant.BATTERY_TEMP + "");
        addContentButton("一键降温", "降温");

        addTitle("OS");
        addContentText("Android版本", VersionUtils.getVersion() + "");
        addContentText("内核版本", FileUtils.getLinuxVersion());

        addTitle("传输");
        addContentText("NFC", getPackageManager().hasSystemFeature(PackageManager.FEATURE_NFC)?"支持":"不支持");

        adapter.notifyDataSetChanged();
    }

    private void addContentButton(String key, String value) {
        SystemInfoModel model = new SystemInfoModel();
        model.setButtonKey(key);
        model.setButtonValue(value);
        model.setType(Type.SYSTEM_LIST_CONTENT_BUTTON);
        systemInfoList.add(model);
    }

    private void addContentText(String key, String value) {
        SystemInfoModel model = new SystemInfoModel();
        model.setTextKey(key);
        model.setTextValue(value);
        model.setType(Type.SYSTEM_LIST_CONTENT_TEXT);
        systemInfoList.add(model);
    }

    private void addTitle(String title) {
        SystemInfoModel model = new SystemInfoModel();
        model.setTitle(title);
        model.setType(Type.SYSTEM_LIST_TITLE);
        systemInfoList.add(model);
    }

    private void initView() {
        rvSystemInfo = findViewById(R.id.rv_system_info);
        rvSystemInfo.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SystemInfoAdapter(this, systemInfoList);
        rvSystemInfo.setAdapter(adapter);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initView();
                initData();
            } else {
                Toast.makeText(this, "有些信息可能无法获取", Toast.LENGTH_SHORT).show();
            }
        }
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
        systemInfoList.get(14).setTextValue(level + "%");
        double temp = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0) / 10.0;
        systemInfoList.get(15).setTextValue(temp + "°C");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        receiver = new BatteryInfoReceiver();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
