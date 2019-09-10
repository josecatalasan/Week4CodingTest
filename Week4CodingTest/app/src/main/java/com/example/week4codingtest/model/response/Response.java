package com.example.week4codingtest.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName="favorite_table")
public class Response implements Parcelable {

	@ColumnInfo(name="albumId")
	@SerializedName("albumId")
	private int albumId;

	@PrimaryKey
	@NonNull
	@ColumnInfo(name="id")
	@SerializedName("id")
	private int id;

	@ColumnInfo(name="title")
	@SerializedName("title")
	private String title;

	@ColumnInfo(name="url")
	@SerializedName("url")
	private String url;

	@ColumnInfo(name="thumbnailUrl")
	@SerializedName("thumbnailUrl")
	private String thumbnailUrl;

	public Response(int albumId, int id, String title, String url, String thumbnailUrl) {
		this.albumId = albumId;
		this.id = id;
		this.title = title;
		this.url = url;
		this.thumbnailUrl = thumbnailUrl;
	}

	protected Response(Parcel in) {
		albumId = in.readInt();
		id = in.readInt();
		title = in.readString();
		url = in.readString();
		thumbnailUrl = in.readString();
	}

	public static final Creator<Response> CREATOR = new Creator<Response>() {
		@Override
		public Response createFromParcel(Parcel in) {
			return new Response(in);
		}

		@Override
		public Response[] newArray(int size) {
			return new Response[size];
		}
	};

	public void setAlbumId(int albumId){
		this.albumId = albumId;
	}

	public int getAlbumId(){
		return albumId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setThumbnailUrl(String thumbnailUrl){
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getThumbnailUrl(){
		return thumbnailUrl;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"albumId = '" + albumId + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",url = '" + url + '\'' + 
			",thumbnailUrl = '" + thumbnailUrl + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeInt(albumId);
		parcel.writeInt(id);
		parcel.writeString(title);
		parcel.writeString(url);
		parcel.writeString(thumbnailUrl);
	}
}