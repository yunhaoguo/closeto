package com.yunhaoguo.closeto.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import com.yunhaoguo.closeto.base.BasePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.view
 * 文件名:     AutoViewPager
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/8 下午5:03
 * 描述:      自动轮播
 */


public class AutoViewPager extends ViewPager {

    private static final int AUTO_CODE = 1001;

    //轮播间隔时间
    private int interval = 3000;

    private List<View> viewList = new ArrayList<>();

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case AUTO_CODE:
                    int index = getCurrentItem();
                    if (index == viewList.size() - 1) {
                        setCurrentItem(0);
                    } else {
                        setCurrentItem(index + 1);
                    }
                    sendEmptyMessageDelayed(AUTO_CODE, interval);
                    break;
            }
        }
    };

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public AutoViewPager(@NonNull Context context) {
        super(context);
    }

    public AutoViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public void setView(View view) {
        viewList.add(view);
        setAdapter(new BasePagerAdapter(viewList));
    }

    public void start() {
        handler.sendEmptyMessage(AUTO_CODE);
    }
}
