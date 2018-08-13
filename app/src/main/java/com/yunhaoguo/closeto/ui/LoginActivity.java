package com.yunhaoguo.closeto.ui;

import android.content.Intent;
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

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        etUsername = findViewById(R.id.et_login_username);
        etPassword = findViewById(R.id.et_login_password);
        btnLogin = findViewById(R.id.btn_login_login);
        btnRegister = findViewById(R.id.btn_login_register);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_login:
                String name = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                SQLiteDatabase db = DBUtils.initAccount(this);
                Cursor cursor = db.query("User", new String[] {"password"}, "name=?", new String[] {name}, null, null, null);
                if (cursor.getCount() != 0) {
                    if (cursor.moveToFirst()) {
                        do {
                            if (password.equals(cursor.getString(cursor.getColumnIndex("password")))) {
                                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                                //finish();
                            } else {
                                Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                            }
                        }while (cursor.moveToNext());
                    }
                } else {
                    Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
                cursor.close();
                break;
            case R.id.btn_login_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }


}
