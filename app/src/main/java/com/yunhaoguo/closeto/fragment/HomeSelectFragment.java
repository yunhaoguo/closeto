package com.yunhaoguo.closeto.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.entity.Constant;
import com.yunhaoguo.closeto.utils.LogUtils;
import com.yunhaoguo.closeto.utils.OkHttpUtils;

import java.io.IOException;


/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.fragment
 * 文件名:     HomeSelectFragment
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/4 下午3:57
 * 描述:      Home下的精选模块fragment
 */


public class HomeSelectFragment extends Fragment {


    public static final String TAG = "HomeSelectFragment";

    private ViewPager vp_home_select;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_select, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        OkHttpUtils.get(Constant.HOME_SELECT_URL, new OkHttpUtils.OnOkHttpCallback() {
            @Override
            public void onFailure(IOException e) {
                LogUtils.i(TAG, e.getMessage());
            }

            @Override
            public void onSuccess(final String json) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), json, Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }

    private void initView(View view) {
        vp_home_select = view.findViewById(R.id.vp_home_select);
    }
}
