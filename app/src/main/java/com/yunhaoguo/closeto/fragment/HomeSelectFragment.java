package com.yunhaoguo.closeto.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.base.BasePagerAdapter;
import com.yunhaoguo.closeto.entity.Constant;
import com.yunhaoguo.closeto.model.SelectModel;
import com.yunhaoguo.closeto.utils.LogUtils;
import com.yunhaoguo.closeto.utils.OkHttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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

    private ViewPager vpHomeSelect;

    private List<SelectModel> selectModelList;
    private List<View> pagerList;

    private TextView tvCurrentIndex;
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
                        if (!TextUtils.isEmpty(json)) {
                            initViewPagerData(json);
                        }
                    }
                });
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }

    private void initViewPagerData(String json) {
        selectModelList = new ArrayList<>();
        try {
            JSONObject jsonContent = new JSONObject(json);
            JSONArray dataArr = jsonContent.getJSONArray("data");
            for (int i = 0; i < dataArr.length(); i++) {
                JSONObject data = (JSONObject) dataArr.get(i);
                SelectModel selectModel = new SelectModel();
                selectModel.setTitle(data.getString("hp_title"));
                selectModel.setAuthor(data.getString("hp_author"));
                selectModel.setContent(data.getString("hp_content"));
                selectModel.setImgUrl(data.getString("hp_img_url"));
                selectModel.setLastUpdateTime(data.getString("last_update_date"));
                selectModel.setWebUrl(data.getString("web_url"));
                selectModelList.add(selectModel);
            }
            pagerList = new ArrayList<>();
            for (int i = 0; i < selectModelList.size(); i++) {
                View view = View.inflate(getActivity(), R.layout.layout_home_select_item, null);
                SelectModel model = selectModelList.get(i);
                String title = model.getTitle();
                String author = model.getAuthor();
                String content = model.getContent();
                String picUrl = model.getImgUrl();
                TextView tvTitle = view.findViewById(R.id.tv_select_item_title);
                TextView tvAuthor = view.findViewById(R.id.tv_select_item_author);
                TextView tvContent = view.findViewById(R.id.tv_select_item_content);
                ImageView ivPic = view.findViewById(R.id.iv_select_item_pic);
                tvTitle.setText(title);
                tvAuthor.setText(author);
                tvContent.setText(content);
                Glide.with(this).load(picUrl).into(ivPic);
                pagerList.add(view);
            }
            vpHomeSelect.setAdapter(new BasePagerAdapter(pagerList));

            tvCurrentIndex.setText("1/" + pagerList.size());
            vpHomeSelect.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    tvCurrentIndex.setText((position + 1) + "/" + pagerList.size());
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void initView(View view) {
        vpHomeSelect = view.findViewById(R.id.vp_home_select);
        tvCurrentIndex = view.findViewById(R.id.tv_select_curindex);
    }
}
