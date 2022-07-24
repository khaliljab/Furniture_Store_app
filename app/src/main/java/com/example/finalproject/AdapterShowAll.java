package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterShowAll extends RecyclerView.Adapter<AdapterShowAll.MyViewHolder> {
    Context context;
    ArrayList<String> title;
    ArrayList<Integer> photo;
    ArrayList<String> price;
    ArrayList<Float> rating;

    public AdapterShowAll(Context context, ArrayList<String> title, ArrayList<Integer> photo, ArrayList<String> price, ArrayList<Float> rating) {
        this.context = context;
        this.title = title;
        this.photo = photo;
        this.price = price;
        this.rating = rating;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_rv_all,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.product_Name.setText(title.get(position));
        holder.product_Price.setText(price.get(position));
        holder.product_photo.setImageResource(photo.get(position));
        holder.ratingBar.setRating(rating.get(position));
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView product_photo;
        TextView product_Name,product_Price;
        RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            product_photo=itemView.findViewById(R.id.product_photo_all);
            product_Name=itemView.findViewById(R.id.product_Name_all);
            product_Price=itemView.findViewById(R.id.product_Price_all);
            ratingBar=itemView.findViewById(R.id.rating_all);

        }
    }
}
