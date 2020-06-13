package com.example.gallery.data;

import com.example.gallery.pojo.GalleryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GalleryRetrofitClient {
    private static final String BASE_URL= "https://jsonplaceholder.typicode.com/";
    GalleryApiService api;
    static GalleryRetrofitClient Instance;

    public GalleryRetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(GalleryApiService.class);
    }

    public static GalleryRetrofitClient getInstance(){
        if (null == Instance){
            Instance = new GalleryRetrofitClient();
        }
        return Instance;
    }

    public Call<List<GalleryModel>> getPhotosInTheClient(){
        return api.getPhotosFromServer();
    }

    public Call<List<GalleryModel>> getPostsInTheClient(){
        return api.getPostsFromServer();
    }

    public Call<List<GalleryModel>> getEmailsInTheClient(){
        return api.getEmailsFromServer();
    }

}
