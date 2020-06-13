package com.example.gallery.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.gallery.R;
import com.example.gallery.pojo.GalleryModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    private List<GalleryModel> arrayList = new ArrayList<>();

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_list_item, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        // TODO اعرض الداتا بطريقه شبه دي
        holder.PostTitle.setText(arrayList.get(position).getTitle());
        holder.PostBody.setText(arrayList.get(position).getTitle());
        holder.CommentEmail.setText(arrayList.get(position).getTitle());

        if (arrayList.get(position).getThumbnailUrl().isEmpty()){
            holder.Image.setImageResource(R.drawable.ic_launcher_background);
        } else {
            Picasso.get()
                    .load(arrayList.get(position).getThumbnailUrl())
                    .into(holder.Image);
        }    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {

        TextView PostTitle, PostBody, CommentEmail;
        ImageView Image;


        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            // TODO هات الفيوز من الايتم شبه كدا
            Image = itemView.findViewById(R.id.iv_photo);
            PostTitle = itemView.findViewById(R.id.tv_title);
            CommentEmail = itemView.findViewById(R.id.tv_email);
            PostBody = itemView.findViewById(R.id.tv_body);
        }
    }


    public void setArrayList(List<GalleryModel> modelArrayList) {
        this.arrayList = modelArrayList;
        notifyDataSetChanged();
    }
}
