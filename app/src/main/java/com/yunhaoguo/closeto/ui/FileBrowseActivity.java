package com.yunhaoguo.closeto.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.adapter.FileBrowseAdapter;
import com.yunhaoguo.closeto.base.BaseActivity;
import com.yunhaoguo.closeto.model.FileBrowseModel;
import com.yunhaoguo.closeto.utils.LogUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FileBrowseActivity extends BaseActivity {

    private RecyclerView rvFileBrowse;
    private TextView tvFileBack;

    private FileBrowseAdapter adapter;

    private List<FileBrowseModel> fileList = new ArrayList<>();

    private static final String BASE_PATH = Environment.getExternalStorageDirectory().getPath();

    //存放上一级菜单目录
    private Deque<String> fileStack = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_browse);
        getSupportActionBar().setTitle("内置SD卡文件");
        if (checkPermissions()) {
            initView();
            initData(BASE_PATH, false);
        }


    }

    private boolean checkPermissions() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            }, 101);
            return false;
        }
        return true;
    }

    private void initData(String path, boolean isBack) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            FileBrowseModel model = new FileBrowseModel();
            model.setTitle(f.getName());
            model.setPath(f.getPath());
            if (f.isDirectory()) {
                model.setIcon(getResources().getDrawable(R.drawable.directory));
            } else {
                model.setIcon(getResources().getDrawable(R.drawable.file));
            }
            fileList.add(model);
        }
        if (!isBack) {
            fileStack.offerLast(path);
        }
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        tvFileBack = findViewById(R.id.tv_file_back);
        tvFileBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!fileStack.isEmpty() && fileStack.size() > 1) {
                    fileStack.pollLast();
                    fileList.clear();
                    initData(fileStack.peekLast(), true);
                }
            }
        });
        rvFileBrowse = findViewById(R.id.rv_file_browse);
        rvFileBrowse.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FileBrowseAdapter(this, fileList);
        adapter.setOnItemClickListener(new FileBrowseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                FileBrowseModel fileModel = fileList.get(position);
                File file = new File(fileModel.getPath());
                if (file.isDirectory()) {
                    fileList.clear();
                    initData(fileModel.getPath(), false);
                }

            }
        });
        rvFileBrowse.setAdapter(adapter);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101 && grantResults.length > 0) {
            LogUtils.i("grant", grantResults[0] + " ");
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initView();
                initData(BASE_PATH, false);
            }
        }
    }
}
