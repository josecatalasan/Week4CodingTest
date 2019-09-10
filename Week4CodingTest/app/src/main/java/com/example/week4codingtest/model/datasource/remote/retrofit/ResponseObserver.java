package com.example.week4codingtest.model.datasource.remote.retrofit;

import android.util.Log;

import com.example.week4codingtest.model.events.ResponseEvent;
import com.example.week4codingtest.model.response.Response;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ResponseObserver implements Observer<List<Response>> {

    private List<Response> responseList;

    @Override
    public void onSubscribe(Disposable d) {
        Log.d("TAG", "Subscribe");
    }

    @Override
    public void onNext(List<Response> responses) {
        responseList = responses;
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        EventBus.getDefault().post(new ResponseEvent(responseList));
    }
}
