package com.yunhaoguo.closeto.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.adapter.MovieListAdapter;
import com.yunhaoguo.closeto.bean.MovieBean;
import com.yunhaoguo.closeto.entity.Constant;
import com.yunhaoguo.closeto.model.MoiveListModel;
import com.yunhaoguo.closeto.ui.MovieMoreActivity;
import com.yunhaoguo.closeto.utils.LogUtils;
import com.yunhaoguo.closeto.utils.OkHttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.fragment
 * 文件名:     HomeMovieFragment
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/4 下午4:22
 * 描述:      Home下的电影模块fragment
 */


public class HomeMovieFragment extends Fragment {

    public static final String TAG = "HomeMovieFragment";
    private RecyclerView rvMovie;

    private List<MovieBean> movieBeanList = new ArrayList<>();

    private MovieListAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_movie, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rvMovie = view.findViewById(R.id.rv_movie);
        initMovieData();
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MovieListAdapter(getActivity(), movieBeanList);
        rvMovie.setAdapter(adapter);
        adapter.setOnItemClickListener(new MovieListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), MovieMoreActivity.class);
                intent.putExtra("title", movieBeanList.get(position).getTitle());
                intent.putExtra("id", movieBeanList.get(position).getId());
                startActivity(intent);
            }
        });
    }

    private void initMovieData() {
        OkHttpUtils.get(Constant.HOME_MOVIE_LIST_URL, new OkHttpUtils.OnOkHttpCallback() {
            @Override
            public void onFailure(IOException e) {
                LogUtils.i(TAG, e.getMessage());
            }

            @Override
            public void onSuccess(String json) {
                if (!TextUtils.isEmpty(json)) {
                    loadMovieData(json);
                }
            }

            @Override
            public void onFailure(String msg) {
                LogUtils.i(TAG, msg);
            }
        });
    }

    private void loadMovieData(String json) {
        MoiveListModel model = new Gson().fromJson(json, MoiveListModel.class);
        List<MoiveListModel.DataBean> movieList = model.getData();
        for (MoiveListModel.DataBean data : movieList) {
            String title = data.getSubtitle();
            String picUrl = data.getImg_url();
            String content = data.getForward();
            MovieBean bean = new MovieBean();
            bean.setId(data.getItem_id());
            bean.setTitle(title);
            bean.setPicUrl(picUrl);
            bean.setContent(content);
            movieBeanList.add(bean);
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter.notifyDataSetChanged();
                }
            });
        }
    }
}
