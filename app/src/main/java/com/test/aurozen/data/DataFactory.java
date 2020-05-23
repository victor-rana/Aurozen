package com.test.aurozen.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataFactory {
    private final static String BASE_URL = "https://restcountries.eu/rest/v2/";
    public final static String URL_ALL_COUNTRIES=BASE_URL.concat("all");


    public static DataService create(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(DataService.class);
            }
}
