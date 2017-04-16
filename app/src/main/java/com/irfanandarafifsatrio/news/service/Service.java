package com.irfanandarafifsatrio.news.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by irfanandarafifsatrio on 4/15/17.
 */

public class Service {
    public static final String API_KEY = "c5a413b844d64762b60e124618c0eddd";
    public static final String BASE_URL = "https://newsapi.org/v1/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S createService(Class<S> serviceClass){
        return retrofit.create(serviceClass);
    }

}
