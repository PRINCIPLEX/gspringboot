package com.yz.gproject.utils;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class okHttp {


    public static void main(String[] args) {
        String url = "http://localhost:8080/test";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        try
        {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch(
                IOException e)

        {
            e.printStackTrace();
        }
    }


}
