package com.example.gallery.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gallery.R;
import com.example.gallery.data.GalleryRetrofitClient;
import com.example.gallery.pojo.GalleryModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GalleyViewModel viewModel = new ViewModelProvider(this).get(GalleyViewModel.class);
        viewModel.getPhotosFromRetrofit();


        RecyclerView recyclerView = findViewById(R.id.rv_main);
        GalleryAdapter adapter = new GalleryAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        

        viewModel.MVVMData.observe(this, new Observer<List<GalleryModel>>() {
            @Override
            public void onChanged(List<GalleryModel> galleryModels) {
                adapter.setArrayList(galleryModels);
            }
        });


    }
}
