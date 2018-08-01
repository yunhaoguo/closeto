package com.yunhaoguo.closeto;

import android.os.Bundle;
import android.widget.TextView;

import com.yunhaoguo.closeto.base.BasePermissionActivity;

public class MainActivity extends BasePermissionActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
    }

}
