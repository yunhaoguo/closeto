package com.yunhaoguo.closeto.utils;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.utils
 * 文件名:     FormatUtils
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/16 下午5:16
 * 描述:      格式化
 */


import java.math.BigDecimal;

public class FormatUtils {

    public static String formatSize(long size){
        double kilo = size/ 1024;
        if(kilo < 1){
            return size + "B";
        }
        double megaByte = kilo / 1024 ;
        if(megaByte < 1){
            BigDecimal bgByte1 = new BigDecimal(Double.toString(kilo));
            return  bgByte1.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
        }
        double gigaM = megaByte / 1024 ;
        if(megaByte < 1){
            BigDecimal bgByte2 = new BigDecimal(Double.toString(megaByte));
            return  bgByte2.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
        }
        double tear = gigaM / 1024 ;
        BigDecimal bgByte3 = new BigDecimal(Double.toString(gigaM));
        return bgByte3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
    }
}
