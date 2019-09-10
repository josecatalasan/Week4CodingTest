package com.example.week4codingtest.model.datasource.remote.retrofit.services;

import com.example.week4codingtest.model.response.Response;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

import static com.example.week4codingtest.model.datasource.remote.retrofit.Url_Constants.PATH_API;

public interface ObservableService {
    @GET(PATH_API)
    Observable<List<Response>> getPicture();
}
