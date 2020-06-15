package com.example.gallery.ui;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gallery.data.GalleryRetrofitClient;
import com.example.gallery.pojo.GalleryModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class GalleyViewModel extends ViewModel {

    private static final String TAG = "ViewModel";

    MutableLiveData<List<GalleryModel>> MVVMData = new MutableLiveData<>();

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    public void getPhotosFromRetrofit() {
        Observable<List<GalleryModel>> observable = GalleryRetrofitClient.getInstance().getPhotosInTheClient()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        compositeDisposable.add(observable.subscribe(o -> MVVMData.setValue(o), e -> Log.d(TAG, "getPhotosFromRetrofit: Error" + e)));

    }


    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
