package com.example.week4codingtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week4codingtest.model.response.Response;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PicturesRVAdapter extends RecyclerView.Adapter<PicturesRVAdapter.ViewHolder> {
    List<Response> itemList;

    public PicturesRVAdapter(List<Response> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_grid_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Response currentResponse = itemList.get(position);
        Picasso.get().load(currentResponse.getThumbnailUrl()).into(holder.ivThumbnail);
        holder.tvAlbum.setText(String.valueOf(currentResponse.getAlbumId()));
        holder.setResponse(currentResponse);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setItemList(List<Response> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        Response response;
        ImageView ivThumbnail;
        TextView tvAlbum;

        public void setResponse(Response response) {
            this.response = response;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
            tvAlbum = itemView.findViewById(R.id.tvAlbum);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), PictureDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("response", response);
            intent.putExtras(bundle);
            view.getContext().startActivity(intent);
        }
    }
}
