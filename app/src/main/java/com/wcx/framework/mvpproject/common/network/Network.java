package com.wcx.framework.mvpproject.common.network;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author wangchenxing
 * @data 30/11/2018 9:12 AM
 */
public class Network {
    private static volatile Api api;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create();

    public static Api getApi() {
        if (api == null) {
            synchronized (Api.class) {
                if (api == null) {
                    Retrofit retrofit = new Retrofit.Builder()
                            .client(okHttpClient)
                            .baseUrl(Url.baseUrl)
                            .addConverterFactory(gsonConverterFactory)
                            .addCallAdapterFactory(rxJava2CallAdapterFactory)
                            .build();
                    api = retrofit.create(Api.class);
                }
            }
        }
        return Network.api;
    }
}
