package com.yunhaoguo.closeto.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.yunhaoguo.closeto.MainActivity;
import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.base.BasePagerAdapter;
import com.yunhaoguo.closeto.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    private ViewPager vp_guide;

    private View view1, view2, view3;

    private List<View> viewList;

    private int currentIndex;

    private int startX, endX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initData();
        initView();
    }

    //加载数据
    private void initData() {
        view1 = View.inflate(this, R.layout.layout_guide_view_1, null);
        view2 = View.inflate(this, R.layout.layout_guide_view_2, null);
        view3 = View.inflate(this, R.layout.layout_guide_view_3, null);

        viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
    }

    //加载view
    private void initView() {
        vp_guide = (ViewPager) findViewById(R.id.vp_guide);

        vp_guide.setAdapter(new BasePagerAdapter(viewList));
        vp_guide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vp_guide.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = (int) motionEvent.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        endX = (int) motionEvent.getX();
                        if (currentIndex == viewList.size() - 1) {
                            if (startX - endX > ScreenUtils.width / 4) {
                                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                                finish();
                            }
                        }
                        break;
                }
                return false;
            }
        });
    }


}
