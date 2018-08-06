package com.yunhaoguo.closeto.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.adapter.MusicListAdapter;
import com.yunhaoguo.closeto.bean.MusicBean;
import com.yunhaoguo.closeto.entity.Constant;
import com.yunhaoguo.closeto.model.MusicListModel;
import com.yunhaoguo.closeto.model.MusicModel;
import com.yunhaoguo.closeto.ui.MusicMoreActivity;
import com.yunhaoguo.closeto.utils.OkHttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.fragment
 * 文件名:     HomeMusicFragment
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/4 下午4:20
 * 描述:      Home下的音乐模块fragment
 */


public class HomeMusicFragment extends Fragment {

    private List<MusicBean> musicBeanList = new ArrayList<>();

    private RecyclerView rvMusicList;

    private MusicListAdapter musicListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_music, container, false);

        initView(view);
        initData();

        return view;
    }

    private void initData() {

        OkHttpUtils.get(Constant.HOME_MUSIC_LIST_URL, new OkHttpUtils.OnOkHttpCallback() {
            @Override
            public void onFailure(IOException e) {

            }

            @Override
            public void onSuccess(String json) {
                if (!TextUtils.isEmpty(json)) {
                    parseMusicListJson(json);
                }

            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }

    private void parseMusicListJson(String json) {
        MusicListModel musicListModel = new Gson().fromJson(json, MusicListModel.class);
        List<String> musicList = musicListModel.getData();
        for (int i = 0; i < musicList.size(); i++) {
            String musicMoreUrl = Constant.HOME_MUSIC_MORE_URL + musicList.get(i);
            OkHttpUtils.get(musicMoreUrl, new OkHttpUtils.OnOkHttpCallback() {
                @Override
                public void onFailure(IOException e) {

                }

                @Override
                public void onSuccess(String json) {
                    if (!TextUtils.isEmpty(json)) {
                        parseMusicMoreJson(json);
                    }
                }

                @Override
                public void onFailure(String msg) {

                }
            });
        }
    }

    private void parseMusicMoreJson(String json) {

        MusicModel music = new Gson().fromJson(json, MusicModel.class);
        String title = music.getData().getTitle();
        String picUrl = music.getData().getCover();
        String id = music.getData().getId();
        MusicBean musicBean = new MusicBean();
        musicBean.setId(id);
        musicBean.setPicUrl(picUrl);
        musicBean.setTitle(title);
        musicBeanList.add(musicBean);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                musicListAdapter.notifyDataSetChanged();
            }
        });

    }

    private void initView(View view) {
        rvMusicList = view.findViewById(R.id.rv_music);
        rvMusicList.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        musicListAdapter = new MusicListAdapter(getActivity(), musicBeanList);
        musicListAdapter.setOnItemClickListener(new MusicListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String musicMoreUrl = Constant.HOME_MUSIC_MORE_URL + musicBeanList.get(position).getId();
                Intent intent = new Intent(getActivity(), MusicMoreActivity.class);
                intent.putExtra("music_more_url", musicMoreUrl);
                startActivity(intent);
            }
        });
        rvMusicList.setAdapter(musicListAdapter);
    }

}
