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

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.MyViewHolder> {

    Context context;
    ArrayList<String> title;
    ArrayList<Integer> photo;
    ArrayList<String> price;
    ArrayList<Float> rating;


    public AdapterCart(Context context, ArrayList<String> title, ArrayList<Integer> photo, ArrayList<String> price,ArrayList<Float> rating) {
        this.context = context;
        this.title = title;
        this.photo = photo;
        this.price = price;
        this.rating = rating;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_rv_cart,parent,false);
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
            product_photo=itemView.findViewById(R.id.photo_cart);
            product_Name=itemView.findViewById(R.id.tv_title_cart);
            product_Price=itemView.findViewById(R.id.tv_price_cart);
            ratingBar=itemView.findViewById(R.id.rating_cart);


        }
    }
}
