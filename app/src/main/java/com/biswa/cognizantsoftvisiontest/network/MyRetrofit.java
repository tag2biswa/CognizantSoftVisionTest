package com.biswa.cognizantsoftvisiontest.network;

import android.app.Application;
import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Application class, initializes Retrofit
 */
public class MyRetrofit extends Application {
    private static final String BASE_URL = "https://dl.dropboxusercontent.com";
    private static MyRetrofit mInstance;
    public static Context context;
    public RestApi service;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        context = this;
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        service = retrofit.create(RestApi.class);
    }

    public static synchronized MyRetrofit getInstance() {
        return mInstance;
    }
}
