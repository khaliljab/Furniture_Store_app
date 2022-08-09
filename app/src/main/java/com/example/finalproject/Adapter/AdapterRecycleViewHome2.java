package com.example.finalproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;

import java.util.ArrayList;

public class AdapterRecycleViewHome2 extends RecyclerView.Adapter<AdapterRecycleViewHome2.MyViewHolder> {

    Context context;
    ArrayList<String> title;
    ArrayList<Integer> photo;
    ArrayList<String> price;
    ArrayList<Float> rating;

    public AdapterRecycleViewHome2(Context context, ArrayList<String> title, ArrayList<Integer> photo, ArrayList<String> price, ArrayList<Float> rating) {
        this.context = context;
        this.title = title;
        this.photo = photo;
        this.price = price;
        this.rating = rating;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_rv_categories_2,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_title.setText(title.get(position));
        holder.tv_price.setText(price.get(position));
        holder.photo.setImageResource(photo.get(position));
        holder.ratingBar.setRating(rating.get(position));
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_title,tv_price;
        public ImageView photo;
        RatingBar ratingBar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_price = itemView.findViewById(R.id.tv_price);
            photo = itemView.findViewById(R.id.photo);
            ratingBar=itemView.findViewById(R.id.rating);

        }
    }
}
