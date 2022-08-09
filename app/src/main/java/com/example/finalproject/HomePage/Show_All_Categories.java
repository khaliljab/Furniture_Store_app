package com.example.finalproject.HomePage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finalproject.Adapter.AdapterShowAll;
import com.example.finalproject.R;

import java.util.ArrayList;

public class Show_All_Categories extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);
        recyclerView=findViewById(R.id.recycleView_all);

        ArrayList<String> title = new ArrayList<>();
        title.add("كنب ثلاثة مقاعد");
        title.add("كنب مقعدين");
        title.add("كنب مقعدين");
        title.add("كنب ثلاثة مقاعد");
        title.add("كنب ثلاثة مقاعد");
        title.add("كنب مقعدين");
        title.add("كنب ثلاثة مقاعد");
        title.add("كنب ثلاثة مقاعد");
        ArrayList<Integer> photo = new ArrayList<>();
        photo.add(R.drawable.photo_item_1);
        photo.add(R.drawable.photo_item_2);
        photo.add(R.drawable.photo_item_2);
        photo.add(R.drawable.photo_item_3);
        photo.add(R.drawable.photo_item_3);
        photo.add(R.drawable.photo_item_1);
        photo.add(R.drawable.photo_item_2);
        photo.add(R.drawable.photo_item_2);
        ArrayList<String> price = new ArrayList<>();
        price.add("180 $");
        price.add("120 $");
        price.add("120 $");
        price.add("150 $");
        price.add("150 $");
        price.add("190 $");
        price.add("250 $");
        price.add("250 $");
        ArrayList<Float> rating = new ArrayList<>();
        rating.add(4.5f);
        rating.add(3.5f);
        rating.add(4f);
        rating.add(2.5f);
        rating.add(5f);
        rating.add(3f);
        rating.add(4.5f);
        rating.add(2.5f);
        recyclerView.setLayoutManager(new GridLayoutManager(Show_All_Categories.this,2));
        AdapterShowAll adapterShowAll= new AdapterShowAll(Show_All_Categories.this,title,photo,price,rating);
        recyclerView.setAdapter(adapterShowAll);
    }
}