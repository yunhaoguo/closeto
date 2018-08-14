package com.yunhaoguo.closeto.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.adapter.AppListAdapter;
import com.yunhaoguo.closeto.manager.AppManager;
import com.yunhaoguo.closeto.model.AppModel;

import java.util.ArrayList;
import java.util.List;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.fragment
 * 文件名:     AppFragment
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/2 下午7:06
 * 描述:      应用fragment
 */


public class AppFragment extends Fragment {

    private static final int GET_DATA_CODE = 1002;
    private static final int REFRESH_CODE = 1001;
    private static final int DELAY = 1500;

    private int currentTab = 0;

    private RecyclerView rvApp;
    private TabLayout tlApp;

    private SwipeRefreshLayout srlApp;

    private List<AppModel> mList = new ArrayList<>();
    private List<AppModel> allAppList = new ArrayList<>();
    private AppListAdapter adapter;

    private static final String[] tabTitles = {"已安装", "系统应用", "全部应用"};


    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case GET_DATA_CODE:
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            allAppList = AppManager.getInstance(getActivity()).getAllApps();
                            sendEmptyMessage(REFRESH_CODE);
                        }
                    }).start();
                    break;
                case REFRESH_CODE:
                    loadData(currentTab);
                    break;

            }
        }
    };

    private void loadData(int currentTab) {
        this.currentTab = currentTab;
        if (mList != null) {
            mList.clear();
        }
        switch (currentTab) {
            case 0:
                for (int i = 0; i < allAppList.size(); i++) {
                    AppModel app = allAppList.get(i);
                    if (!app.isSys()) {
                        mList.add(app);
                    }
                }
                break;
            case 1:
                for (int i = 0; i < allAppList.size(); i++) {
                    AppModel app = allAppList.get(i);
                    if (app.isSys()) {
                        mList.add(app);
                    }
                }
                break;
            case 2:
                mList.addAll(allAppList);
                break;
        }
        adapter.notifyDataSetChanged();
        if (srlApp.isRefreshing()) {
            srlApp.setRefreshing(false);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_app, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tlApp = view.findViewById(R.id.tl_app);
        for (int i = 0; i < tabTitles.length; i++) {
            tlApp.addTab(tlApp.newTab().setText(tabTitles[i]), i);
        }
        tlApp.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                loadData(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        rvApp = view.findViewById(R.id.rv_app);
        rvApp.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AppListAdapter(getActivity(), mList);
        rvApp.setAdapter(adapter);

        //获取APPList数据
        handler.sendEmptyMessage(GET_DATA_CODE);

        srlApp = view.findViewById(R.id.srl_app);
        //下拉刷新重新获取最新APPList数据
        srlApp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(GET_DATA_CODE, DELAY);
            }
        });
    }


}
