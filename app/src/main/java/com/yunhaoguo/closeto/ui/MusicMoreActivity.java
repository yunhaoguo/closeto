package com.yunhaoguo.closeto.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.base.BaseActivity;
import com.yunhaoguo.closeto.model.MusicModel;
import com.yunhaoguo.closeto.utils.OkHttpUtils;

import java.io.IOException;

public class MusicMoreActivity extends BaseActivity implements View.OnClickListener {


    private ImageView ivPic;
    private TextView tvTitle;
    private TextView tvStoryTitle;
    private TextView tvStoryContent;
    private TextView tvLyric;
    private TextView tvInfo;

    private TextView tvToOriPage;

    private Context context;

    private MusicModel musicModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_more);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("music_more_url");
        OkHttpUtils.get(url, new OkHttpUtils.OnOkHttpCallback() {
            @Override
            public void onFailure(IOException e) {

            }

            @Override
            public void onSuccess(String json) {
                if (!TextUtils.isEmpty(json)) {
                    parseJson(json);
                }
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }

    private void parseJson(String json) {
        musicModel = new Gson().fromJson(json, MusicModel.class);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Glide.with(context).load(musicModel.getData().getCover()).into(ivPic);
                tvTitle.setText(musicModel.getData().getTitle());
                tvStoryTitle.setText(musicModel.getData().getStory_title());
                tvStoryContent.setText(Html.fromHtml(musicModel.getData().getStory()));
                tvLyric.setText(musicModel.getData().getLyric());
                tvInfo.setText(musicModel.getData().getInfo());
                tvToOriPage.setVisibility(View.VISIBLE);
            }
        });

    }

    private void initView() {

        context = this;
        ivPic = findViewById(R.id.iv_music_more_pic);
        ivPic.setOnClickListener(this);

        tvTitle = findViewById(R.id.tv_music_more_title);

        tvStoryTitle = findViewById(R.id.tv_music_more_story_title);

        tvStoryContent = findViewById(R.id.tv_music_more_story_content);

        tvLyric = findViewById(R.id.tv_music_more_lyric);

        tvInfo = findViewById(R.id.tv_music_more_info);

        tvToOriPage = findViewById(R.id.tv_to_music_original_page);
        tvToOriPage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_music_more_pic:
                break;
            case R.id.tv_to_music_original_page:
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", musicModel.getData().getWeb_url());
                startActivity(intent);
                break;
        }
    }
}
