package com.yunhaoguo.closeto.impl;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.impl
 * 文件名:     WeatherApi
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/9 下午3:06
 * 描述:      天气接口
 */


import com.yunhaoguo.closeto.model.LifestyleModel;
import com.yunhaoguo.closeto.model.WeatherNowModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("s6/weather/forecast?")
    Call<WeatherNowModel> getNowWeather(@Query("location") String location, @Query("key") String key);

    @GET("s6/weather/lifestyle?")
    Call<LifestyleModel> getLifeStyle(@Query("location") String location, @Query("key") String key);

}
