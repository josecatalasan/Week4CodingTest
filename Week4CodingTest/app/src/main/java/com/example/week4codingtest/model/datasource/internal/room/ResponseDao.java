package com.example.week4codingtest.model.datasource.internal.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.week4codingtest.model.response.Response;

import java.util.List;

@Dao
public interface ResponseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Response response);

    @Query("DELETE FROM favorite_table")
    void deleteAll();

    @Query("SELECT * from favorite_table ORDER BY id ASC")
    List<Response> getAllFavorites();
}
