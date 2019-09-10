package com.example.week4codingtest.model.datasource.remote.retrofit;

import com.example.week4codingtest.model.datasource.remote.retrofit.services.ObservableService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.week4codingtest.model.datasource.remote.retrofit.Url_Constants.BASE_URL;

public class RetrofitHelper {

    private Retrofit getInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public ObservableService getService(){
        return getInstance().create(ObservableService.class);
    }
}
