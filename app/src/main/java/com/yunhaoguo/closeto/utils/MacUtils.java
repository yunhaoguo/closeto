package com.yunhaoguo.closeto.utils;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.utils
 * 文件名:     MacUtils
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/16 下午5:18
 * 描述:      MAC地址
 */


import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

public class MacUtils {

    public static String getMac(Context mContext) {
        WifiManager wifiManager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
        String mac = wifiManager.getConnectionInfo().getMacAddress();
        if(!TextUtils.isEmpty(mac)){
            return mac;
        }
        return  "";
    }
}
