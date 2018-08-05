package com.yunhaoguo.closeto.utils;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.utils
 * 文件名:     OkHttpUtils
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/4 下午8:19
 * 描述:      OkHttp封装
 */


import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static void get(String url, final OnOkHttpCallback callback) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();
                    callback.onSuccess(json);
                } else {
                    callback.onFailure("response is not successful.");
                }
            }
        });
    }

    public static void postJson(String url, String json, final OnOkHttpCallback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();
                    callback.onSuccess(json);
                } else {
                    callback.onFailure("response is not successful.");
                }
            }
        });
    }

    public static void postMap(String url, Map<String, String> map, final OnOkHttpCallback callback) {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder formbody = new FormBody.Builder();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                formbody.add(entry.getKey(), entry.getValue());
            }
        }
        RequestBody requestBody = formbody.build();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();
                    callback.onSuccess(json);
                } else {
                    callback.onFailure("response is not successful.");
                }
            }
        });
    }

    public interface OnOkHttpCallback {

        //失败
        void onFailure(IOException e);

        //成功
        void onSuccess(String json);

        //成功但是没结果
        void onFailure(String msg);
    }
}
