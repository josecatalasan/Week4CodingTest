package com.example.week4codingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.week4codingtest.model.datasource.internal.room.FavoriteRepository;
import com.example.week4codingtest.model.response.Response;
import com.squareup.picasso.Picasso;

public class PictureDetailActivity extends AppCompatActivity {

    TextView tvTitle, tvId;
    ImageView ivPicture;
    FavoriteRepository favoriteRepository;
    Response response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivPicture = findViewById(R.id.ivPicture);
        tvTitle = findViewById(R.id.tvTitle);
        tvId = findViewById(R.id.tvId);

        response = getIntent().getExtras().getParcelable("response");
        Picasso.get().load(response.getUrl()).into(ivPicture);
        tvTitle.setText(response.getTitle());
        tvId.setText(String.valueOf(response.getId()));

        favoriteRepository = new FavoriteRepository(this.getApplication());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_favorite) {
            favoriteRepository.insert(response);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
