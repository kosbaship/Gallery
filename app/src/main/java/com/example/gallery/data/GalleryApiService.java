package com.example.gallery.data;

import com.example.gallery.pojo.GalleryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GalleryApiService {

    @GET("photos")
    Call<List<GalleryModel>> getPhotosFromServer();

    @GET("posts")
    Call<List<GalleryModel>> getPostsFromServer();

    @GET("comments")
    Call<List<GalleryModel>> getEmailsFromServer();

}
