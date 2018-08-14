package com.yunhaoguo.closeto.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yunhaoguo.closeto.R;

public class ScreenCheckActivity extends Activity {

    private RelativeLayout rlScreenCheck;
    private TextView tvChangeColor;

    private int[] colors = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.WHITE};

    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_screen_check);
        initView();

    }

    private void initView() {
        tvChangeColor = findViewById(R.id.tv_screen_check_change);
        rlScreenCheck = findViewById(R.id.rl_screen_check);
        rlScreenCheck.setBackgroundColor(colors[index]);
        rlScreenCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                if (index < colors.length) {
                    if (index == colors.length - 1) {
                        tvChangeColor.setTextColor(Color.BLACK);
                    }
                    rlScreenCheck.setBackgroundColor(colors[index]);
                } else {
                    Toast.makeText(ScreenCheckActivity.this, "即将退出", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    }, 1500);
                }

            }
        });
    }
}
