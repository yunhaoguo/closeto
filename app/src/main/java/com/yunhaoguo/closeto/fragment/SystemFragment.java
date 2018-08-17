package com.yunhaoguo.closeto.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.manager.CacheCleanManager;
import com.yunhaoguo.closeto.ui.FileBrowseActivity;
import com.yunhaoguo.closeto.ui.ScreenCheckActivity;
import com.yunhaoguo.closeto.ui.SystemInfoActivity;
import com.yunhaoguo.closeto.utils.FileUtils;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.fragment
 * 文件名:     SystemFragment
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/2 下午7:07
 * 描述:      系统fragment
 */


public class SystemFragment extends Fragment implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {

    private LinearLayout llScreenCheck;
    private LinearLayout llFileManage;
    private LinearLayout llSystemInfo;

    private View vTotalSpace;
    private View vRestSpace;
    private View vUsedSpace;

    private View rootView;

    private Button btnCleanCache;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_system, container, false);
        rootView = view;
        initView(view);
        return view;
    }

    private void initView(View view) {



        llScreenCheck = view.findViewById(R.id.ll_screen_check);
        llScreenCheck.setOnClickListener(this);

        llFileManage = view.findViewById(R.id.ll_file_manage);
        llFileManage.setOnClickListener(this);

        llSystemInfo = view.findViewById(R.id.ll_system_info);
        llSystemInfo.setOnClickListener(this);

        vRestSpace = view.findViewById(R.id.v_rest_space);
        vTotalSpace = view.findViewById(R.id.v_total_space);
        vUsedSpace = view.findViewById(R.id.v_used_space);

        btnCleanCache = view.findViewById(R.id.btn_cache_clean);
        btnCleanCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(getActivity(), "缓存" + CacheCleanManager.getTotalCacheSize(getActivity()), Toast.LENGTH_SHORT).show();
                    CacheCleanManager.clearAllCache(getActivity());
                    Toast.makeText(getActivity(), "缓存" + CacheCleanManager.getTotalCacheSize(getActivity()), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        ViewTreeObserver observer = view.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(this);



    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.ll_screen_check:
                intent.setClass(getActivity(), ScreenCheckActivity.class);
                break;
            case R.id.ll_file_manage:
                intent.setClass(getActivity(), FileBrowseActivity.class);
                break;
            case R.id.ll_system_info:
                intent.setClass(getActivity(), SystemInfoActivity.class);
        }
        startActivity(intent);
    }


    @Override
    public void onGlobalLayout() {
        long restSpace = FileUtils.getSDSize(1);
        long totalSpace = FileUtils.getSDSize(0);

        LinearLayout.LayoutParams pRest = (LinearLayout.LayoutParams) vRestSpace.getLayoutParams();
        pRest.height = (int) (vTotalSpace.getHeight() * restSpace / totalSpace);
        vRestSpace.setLayoutParams(pRest);
        LinearLayout.LayoutParams pUsed = (LinearLayout.LayoutParams) vUsedSpace.getLayoutParams();
        pUsed.height = (int) (vTotalSpace.getHeight() * (totalSpace - restSpace) / totalSpace);
        vUsedSpace.setLayoutParams(pUsed);
        rootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
}
