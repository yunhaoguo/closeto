package com.yunhaoguo.closeto.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.gson.Gson;
import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.base.BaseActivity;
import com.yunhaoguo.closeto.base.BasePagerAdapter;
import com.yunhaoguo.closeto.model.MovieModel;
import com.yunhaoguo.closeto.utils.LogUtils;
import com.yunhaoguo.closeto.utils.OkHttpUtils;
import com.yunhaoguo.closeto.view.AutoViewPager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MovieMoreActivity extends BaseActivity implements View.OnClickListener {

    public static final String TAG = "MovieMoreActivity";

    private ImageView ivMovieMoreIndexPic;
    private ImageView ivMovieMorePic;
    private TextView tvMovieMoreScore;
    private TextView tvMovieMoreMaketime;
    private TextView tvMovieMoreInfo;
    private TextView tvMovieMoreHistory;
    private ImageView ivMovieMorePoster;
    private TextView tvMovieMoreTitle;
    private TextView tvMovieMoreOrigin;

    private AutoViewPager avpMovieMore;

    private MovieModel movie;

    //图片下载计数器
    private AtomicInteger count = new AtomicInteger(0);
    private List<View> viewList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_more);
        initData();
        initView();
    }

    private void initView() {

        ivMovieMoreIndexPic = findViewById(R.id.iv_movie_more_index_pic);
        ivMovieMorePic = findViewById(R.id.iv_movie_more_pic);
        ivMovieMorePic.setOnClickListener(this);
        tvMovieMoreScore = findViewById(R.id.tv_movie_more_score);
        tvMovieMoreMaketime = findViewById(R.id.tv_movie_more_maketime);
        tvMovieMoreInfo = findViewById(R.id.tv_movie_more_info);
        tvMovieMoreHistory = findViewById(R.id.tv_movie_more_history);
        ivMovieMorePoster = findViewById(R.id.iv_movie_more_poster);
        ivMovieMorePoster.setOnClickListener(this);
        tvMovieMoreTitle = findViewById(R.id.tv_movie_more_title);

        avpMovieMore = findViewById(R.id.avp_movie_more);


        tvMovieMoreOrigin = findViewById(R.id.tv_movie_more_origin);
        tvMovieMoreOrigin.setOnClickListener(this);
    }

    private void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
        String id = intent.getStringExtra("id");
        String url = "http://v3.wufazhuce.com:8000/api/movie/detail/" + id
                + "/?channel=wdj&source=channel_movie&source_id=9240&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";
        requestData(url);
    }

    private void requestData(String url) {
        OkHttpUtils.get(url, new OkHttpUtils.OnOkHttpCallback() {
            @Override
            public void onFailure(IOException e) {
                LogUtils.i(TAG, e.getMessage());
            }

            @Override
            public void onSuccess(String json) {
                if (!TextUtils.isEmpty(json)) {
                    parseJson(json);
                }
            }

            @Override
            public void onFailure(String msg) {
                LogUtils.i(TAG, msg);
            }
        });
    }

    private void parseJson(String json) {
        movie = new Gson().fromJson(json, MovieModel.class);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Glide.with(getApplicationContext()).load(movie.getData().getIndexcover()).into(ivMovieMoreIndexPic);
                Glide.with(getApplicationContext()).load(movie.getData().getDetailcover()).into(ivMovieMorePic);
                Glide.with(getApplicationContext()).load(movie.getData().getPoster()).into(ivMovieMorePoster);
                String score = movie.getData().getReview();
                if (!TextUtils.isEmpty(score)) {
                    tvMovieMoreScore.setText(score);
                }
                tvMovieMoreMaketime.setText(movie.getData().getMaketime());
                tvMovieMoreInfo.setText(movie.getData().getInfo());
                tvMovieMoreHistory.setText(movie.getData().getOfficialstory());
                tvMovieMoreTitle.setText(movie.getData().getTitle());
                addAutoView(movie.getData().getPhoto());
            }
        });


    }

    //下载并添加轮播图
    private void addAutoView(final List<String> photoUrls) {
        for (String url : photoUrls) {
            final View view = View.inflate(this, R.layout.layout_auto_view_pager_item, null);
            final ImageView ivPic = view.findViewById(R.id.iv_auto_view_pager_pic);
            Glide.with(this).load(url).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                    count.getAndAdd(1);
                    ivPic.setImageDrawable(resource);
                    viewList.add(view);
                    if (count.get() == photoUrls.size()) {
                        avpMovieMore.setViewList(viewList);
                        avpMovieMore.setAdapter(new BasePagerAdapter(viewList));
                        avpMovieMore.start();
                    }
                    //把打开原始网页的文字链接显示出来
                    tvMovieMoreOrigin.setVisibility(View.VISIBLE);
                }
            });

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_movie_more_origin:
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", movie.getData().getWeb_url());
                startActivity(intent);
                break;
        }
    }
}
