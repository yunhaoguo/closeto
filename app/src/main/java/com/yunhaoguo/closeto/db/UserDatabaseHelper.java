package com.yunhaoguo.closeto.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.db
 * 文件名:     UserDatabaseHelper
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/13 下午2:30
 * 描述:      用户账户数据库帮助类
 */


public class UserDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_USER = "create table User ("
            + "id integer primary key autoincrement,"
            + "name text,"
            + "password text)";

    private Context mContext;

    public UserDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER);
        Toast.makeText(mContext, "Create User table succeed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
