package com.example.gallery.data;

import com.example.gallery.pojo.GalleryModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface GalleryApiService {

    @GET("photos")
    Observable<List<GalleryModel>> getPhotosFromServer();

//    @GET("posts")
//    Observable<List<GalleryModel>> getPostsFromServer();
//
//    @GET("comments")
//    Observable<List<GalleryModel>> getEmailsFromServer();

}
