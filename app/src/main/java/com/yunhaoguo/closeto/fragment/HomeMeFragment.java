package com.yunhaoguo.closeto.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.adapter.LifestyleListAdapter;
import com.yunhaoguo.closeto.bean.LifestyleBean;
import com.yunhaoguo.closeto.entity.Constant;
import com.yunhaoguo.closeto.impl.WeatherApi;
import com.yunhaoguo.closeto.model.LifestyleModel;
import com.yunhaoguo.closeto.model.WeatherNowModel;
import com.yunhaoguo.closeto.ui.LoginActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.fragment
 * 文件名:     HomeMeFragment
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/4 下午4:22
 * 描述:      Home下的我的模块fragment
 */


public class HomeMeFragment extends Fragment {

    private CardView cvHomeMeWeather;
    private RecyclerView rvHomeMeInfo;
    private CircleImageView civHomeMeImage;
    private TextView tvHomeMeName;
    private TextView tvHomeMeDesc;
    private ImageView ivHomeMeNowweatherPic;
    private ImageView ivHomeMeNowweatherPic2;
    private TextView tvHomeMeCity;
    private TextView tvHomeMeWeather;
    private TextView tvHomeMeDegree;
    private TextView tvHomeMeUpdate;

    private Spinner spinnerCityList;
    private String[] cityArr;

    private WeatherApi weatherApi;

    private List<LifestyleBean> lifestyleAdapterList = new ArrayList<>();
    private LifestyleListAdapter adapter;
    private Map<String, String> lsTitleMap = new HashMap<>();
    private Map<String, Integer> weatherIconMap = new HashMap<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_me, container, false);
        init();
        initRetrofit();
        initView(view);
        initNowWeatherData("北京");
        initLifeStyle("北京");
        return view;
    }

    private void init() {
        //设置生活指数map
        lsTitleMap.put("comf", "舒适度指数");
        lsTitleMap.put("cw", "洗车指数");
        lsTitleMap.put("drsg", "穿衣指数");
        lsTitleMap.put("flu", "感冒指数");
        lsTitleMap.put("sport", "运动指数");
        lsTitleMap.put("trav", "旅游指数");
        lsTitleMap.put("uv", "紫外线指数");
        lsTitleMap.put("air", "空气污染扩散条件指数");
        //设置天气图标map
        weatherIconMap.put("晴", R.drawable.sunny);
        weatherIconMap.put("小雨", R.drawable.slightdrizzle);
        weatherIconMap.put("中雨", R.drawable.drizzle);
        weatherIconMap.put("大雨", R.drawable.drizzle2);
        weatherIconMap.put("雷阵雨", R.drawable.thunderstorms);
        weatherIconMap.put("阵雨", R.drawable.thunderstorms);
        weatherIconMap.put("多云", R.drawable.mostlycloudy);
        weatherIconMap.put("小雪", R.drawable.snow);

    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.WEATHER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherApi = retrofit.create(WeatherApi.class);
    }


    private void initView(View view) {

        cvHomeMeWeather = view.findViewById(R.id.cv_home_me_weather);
        rvHomeMeInfo = view.findViewById(R.id.rv_home_me_info);
        adapter = new LifestyleListAdapter(getActivity(), lifestyleAdapterList);
        rvHomeMeInfo.setAdapter(adapter);
        rvHomeMeInfo.setLayoutManager(new LinearLayoutManager(getActivity()));


        civHomeMeImage = view.findViewById(R.id.civ_home_me_image);
        tvHomeMeName = view.findViewById(R.id.tv_home_me_name);
        tvHomeMeDesc = view.findViewById(R.id.tv_home_me_desc);

        ivHomeMeNowweatherPic = view.findViewById(R.id.iv_home_me_nowweather_pic);
        ivHomeMeNowweatherPic2 = view.findViewById(R.id.iv_home_me_nowweather_pic2);

        tvHomeMeCity = view.findViewById(R.id.tv_home_me_city);
        tvHomeMeWeather = view.findViewById(R.id.tv_home_me_weather);
        tvHomeMeDegree = view.findViewById(R.id.tv_home_me_degree);
        tvHomeMeUpdate = view.findViewById(R.id.tv_home_me_update);

        spinnerCityList = view.findViewById(R.id.spinner_city_list);
        cityArr = new String[] {"北京", "石家庄", "上海", "成都", "广州"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, cityArr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCityList.setAdapter(adapter);
        spinnerCityList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                initNowWeatherData(cityArr[i]);
                initLifeStyle(cityArr[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        civHomeMeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    //获取天气情况
    private void initNowWeatherData(String location) {

        Call<WeatherNowModel> call = weatherApi.getNowWeather(location, Constant.WEATHER_KEY);
        call.enqueue(new Callback<WeatherNowModel>() {
            @Override
            public void onResponse(Call<WeatherNowModel> call, Response<WeatherNowModel> response) {
                WeatherNowModel weather = response.body();
                loadWeatherData(weather);
            }

            @Override
            public void onFailure(Call<WeatherNowModel> call, Throwable t) {

            }
        });
    }

    private void loadWeatherData(final WeatherNowModel weather) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                WeatherNowModel.HeWeather6Bean heWeather6Bean = weather.getHeWeather6().get(0);
                tvHomeMeCity.setText(heWeather6Bean.getBasic().getLocation());
                String startWeather = heWeather6Bean.getDaily_forecast().get(0).getCond_txt_d();
                String endWeather = heWeather6Bean.getDaily_forecast().get(0).getCond_txt_n();
                tvHomeMeWeather.setText(String.format("%s转%s", startWeather,endWeather));
                tvHomeMeDegree.setText(String.format("%s到%s度", heWeather6Bean.getDaily_forecast().get(0).getTmp_min(),
                        heWeather6Bean.getDaily_forecast().get(0).getTmp_max()));
                tvHomeMeUpdate.setText(heWeather6Bean.getUpdate().getLoc());
                if (weatherIconMap.containsKey(startWeather)) {
                    ivHomeMeNowweatherPic.setImageResource(weatherIconMap.get(startWeather));
                }
                if (weatherIconMap.containsKey(endWeather)) {
                    ivHomeMeNowweatherPic2.setImageResource(weatherIconMap.get(endWeather));
                }
            }
        });
    }

    private void initLifeStyle(String location) {
        Call<LifestyleModel> call = weatherApi.getLifeStyle(location, Constant.WEATHER_KEY);
        call.enqueue(new Callback<LifestyleModel>() {
            @Override
            public void onResponse(Call<LifestyleModel> call, Response<LifestyleModel> response) {
                LifestyleModel lifestyle = response.body();
                loadLifestyleData(lifestyle);
            }

            @Override
            public void onFailure(Call<LifestyleModel> call, Throwable t) {

            }
        });

    }

    private void loadLifestyleData(LifestyleModel lifestyle) {
        lifestyleAdapterList.clear();
        List<LifestyleModel.HeWeather6Bean.LifestyleBean> lifestyleBeanList =
                lifestyle.getHeWeather6().get(0).getLifestyle();
        for (LifestyleModel.HeWeather6Bean.LifestyleBean bean : lifestyleBeanList) {
            String type = bean.getType();
            String brf = bean.getBrf();
            String txt = bean.getTxt();
            LifestyleBean lifestyleBean = new LifestyleBean();
            lifestyleBean.setType(lsTitleMap.get(type));
            lifestyleBean.setBrf(brf);
            lifestyleBean.setTxt(txt);
            lifestyleAdapterList.add(lifestyleBean);
            adapter.notifyDataSetChanged();
        }
    }
}
