package com.yunhaoguo.closeto.manager;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.manager
 * 文件名:     AppManager
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/13 下午5:00
 * 描述:      应用管理
 */


import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import com.yunhaoguo.closeto.model.AppModel;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class AppManager {

    private static AppManager appInstance = null;

    private Context context;
    private List<PackageInfo> packageInfoList;
    private PackageManager pm;

    private AppManager(Context context) {
        this.context = context;
        initAppManage();
    }

    private void initAppManage() {
        pm = context.getPackageManager();
        packageInfoList = pm.getInstalledPackages(0);
    }

    public static AppManager getInstance(Context context) {
        if (appInstance == null) {
            synchronized (AppManager.class) {
                if (appInstance == null) {
                    appInstance = new AppManager(context);
                }
            }
        }
        return appInstance;
    }

    /**
     * 获取系统已安装应用
     * @return
     */
    public List<AppModel> getAllApps() {
        List<AppModel> res = new ArrayList<>();
        //获取全部已安装应用
        for (PackageInfo info : packageInfoList) {
            ApplicationInfo appInfo = info.applicationInfo;
            AppModel model = new AppModel();
            model.setIcon(appInfo.loadIcon(pm));
            model.setAppName(pm.getApplicationLabel(appInfo).toString());
            model.setPackageName(appInfo.packageName);
            //应用大小
            File file = new File(appInfo.sourceDir);
            model.setAppSize(getSize(file));
            //判断是否是系统应用
            if ((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                model.setSys(true);
            }
            res.add(model);
        }
        return res;
    }

    /**
     * 计算file大小
     * @param file
     * @return
     */
    private String getSize(File file) {
        double fileSize = file.length() / 1024 / 1024;
        DecimalFormat df = new DecimalFormat("0.00");
        if (fileSize > 1024) {
            return df.format(fileSize / 1024) + "G";
        } else {
            return df.format(fileSize) + "M";
        }
    }

    /**
     * 获取指定包名的版本号
     * @param packageName
     * @return
     */
    public String getAppVersion(String packageName) {
        try {
            PackageInfo info = pm.getPackageInfo(packageName, 0);
            return "版本号：" + info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "版本号：获取失败";
        }
    }

    /**
     * 获取指定包名的图标
     * @param packageName
     * @return
     */
    public Drawable getAppIcon(String packageName) {
        try {
            PackageInfo info = pm.getPackageInfo(packageName, 0);
            return info.applicationInfo.loadIcon(pm);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取指定包名的权限列表
     * @param packageName
     * @return
     */
    public String[] getAppPermissions(String packageName) {
        try {
            PackageInfo info = pm.getPackageInfo(packageName, 0);
            return info.requestedPermissions;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 卸载指定包名的应用
     * @param packageName
     */
    public void uninstallApp(String packageName) {
        Intent intent = new Intent(Intent.ACTION_DELETE);
        Uri uri = Uri.parse("package:" + packageName);
        intent.setData(uri);
        context.startActivity(intent);
    }
}
