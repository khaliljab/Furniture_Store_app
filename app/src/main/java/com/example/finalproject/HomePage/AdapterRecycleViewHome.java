package com.example.finalproject.HomePage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;

import java.util.ArrayList;

public class AdapterRecycleViewHome extends RecyclerView.Adapter<AdapterRecycleViewHome.MyViewHolder> {

    Context context;
    ArrayList<String> data;
    ArrayList<Integer> photo;

    public AdapterRecycleViewHome(Context context, ArrayList<String> data, ArrayList<Integer> photo) {
        this.context = context;
        this.data = data;
        this.photo = photo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_rv_categories,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_title.setText(data.get(position));
        holder.background.setImageResource(photo.get(position));
        holder.card_view_categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_title;
        public ImageView background;
        public CardView card_view_categories;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.title);
            background = itemView.findViewById(R.id.background);
            card_view_categories = itemView.findViewById(R.id.card_view_categories);

        }
    }
}
