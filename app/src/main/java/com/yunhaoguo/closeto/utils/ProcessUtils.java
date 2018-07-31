package com.yunhaoguo.closeto.utils;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.utils
 * 文件名:     ProcessUtils
 * 创建者:     yunhaoguo
 * 创建时间:    2018/7/31 下午4:25
 * 描述:      进程封装
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ProcessUtils {

    //获取主进程
    public static String getTopProcess() {
        try {
            File file = new File("/proc/" + android.os.Process.myPid() + "/cmdline");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String processName = reader.readLine().trim();
            reader.close();
            return processName;
        } catch (Exception e) {
            return null;
        }
    }
}
