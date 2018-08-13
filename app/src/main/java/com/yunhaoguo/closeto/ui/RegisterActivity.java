package com.yunhaoguo.closeto.ui;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.base.BaseActivity;
import com.yunhaoguo.closeto.utils.DBUtils;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private SQLiteDatabase db;
    private EditText etRegisterUsername;
    private EditText etRegisterPassword;
    private Button btnRegisterRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initDB();
        initView();

    }

    private void initView() {
        etRegisterUsername = findViewById(R.id.et_register_username);
        etRegisterPassword = findViewById(R.id.et_register_password);
        btnRegisterRegister = findViewById(R.id.btn_register_register);
        btnRegisterRegister.setOnClickListener(this);
    }

    private void initDB() {
        db = DBUtils.initAccount(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register_register:
                String name = etRegisterUsername.getText().toString();
                String password = etRegisterPassword.getText().toString();
                Cursor cursor = db.query("User", new String[] {"name"}, "name=?", new String[] {name}, null, null, null);
                if (cursor.getCount() != 0) {
                    Toast.makeText(this, "已被注册", Toast.LENGTH_SHORT).show();
                } else {
                    ContentValues values = new ContentValues();
                    values.put("name", name);
                    values.put("password", password);
                    db.insert("User", null, values);
                    values.clear();
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                    finish();
                }
                cursor.close();
                break;
        }
    }


}
