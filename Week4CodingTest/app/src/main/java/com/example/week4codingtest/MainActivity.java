package com.example.week4codingtest;

import android.os.Bundle;

import com.example.week4codingtest.model.datasource.remote.retrofit.ResponseObserver;
import com.example.week4codingtest.model.datasource.remote.retrofit.RetrofitHelper;
import com.example.week4codingtest.model.events.ResponseEvent;
import com.example.week4codingtest.model.response.Response;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvPictures;
    PicturesRVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPictures = findViewById(R.id.rvPictures);
        ArrayList<Response> itemList = new ArrayList();
        rvPictures.setLayoutManager(new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false));
        adapter = new PicturesRVAdapter(itemList);
        rvPictures.setAdapter(adapter);


        RetrofitHelper helper = new RetrofitHelper();
        helper.getService().getPicture().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new ResponseObserver());
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResponseEvent(ResponseEvent responseEvent){
        if(responseEvent.getResponseList() != null){
            adapter.setItemList(responseEvent.getResponseList());
        }
    }
}
