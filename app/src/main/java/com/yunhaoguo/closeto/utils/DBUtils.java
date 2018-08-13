package com.yunhaoguo.closeto.utils;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.utils
 * 文件名:     DBUtils
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/13 下午3:23
 * 描述:      数据库封装
 */


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.yunhaoguo.closeto.db.UserDatabaseHelper;
import com.yunhaoguo.closeto.entity.Constant;

public class DBUtils {


    public static SQLiteDatabase initAccount(Context context) {
        UserDatabaseHelper dbHelper = new UserDatabaseHelper(context, Constant.DB_USER_ACCOUNT, null, 1);
        return dbHelper.getWritableDatabase();
    }
}
