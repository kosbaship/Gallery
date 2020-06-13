package com.example.gallery.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gallery.data.GalleryRetrofitClient;
import com.example.gallery.pojo.GalleryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleyViewModel extends ViewModel {
    MutableLiveData<List<GalleryModel>> MVVMData = new MutableLiveData<>();

    public void getPhotosFromRetrofit() {
        GalleryRetrofitClient.getInstance().getPhotosInTheClient().enqueue(new Callback<List<GalleryModel>>() {
            @Override
            public void onResponse(Call<List<GalleryModel>> call, Response<List<GalleryModel>> response) {
                MVVMData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<GalleryModel>> call, Throwable t) {

            }
        });
    }


    }
