package com.example.week4codingtest.model.datasource.internal.room;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import com.example.week4codingtest.model.response.Response;

import java.util.List;

public class FavoriteRepository {
    private ResponseDao dao;
    private List<Response> allFavorites;

    public FavoriteRepository(Application application){
        FavoriteRoomDatabase db = FavoriteRoomDatabase.getDatabase(application);
        dao = db.responseDao();
    }

    List<Response> getAllFavorites(){
        return allFavorites;
    }

    public void insert(Response response){
        new insertAsyncTask(dao).execute(response);
    }

    private static class insertAsyncTask extends AsyncTask<Response, Void, Void>{

        private ResponseDao asynchDao;

        public insertAsyncTask(ResponseDao asynchDao) {
            this.asynchDao = asynchDao;
        }

        @Override
        protected Void doInBackground(Response... responses) {
            asynchDao.insert(responses[0]);
            Log.d("INSERT", "Added to db: " + responses[0].getId());
            return null;
        }
    }
}
