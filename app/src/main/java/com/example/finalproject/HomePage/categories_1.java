package com.example.finalproject.HomePage;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.finalproject.Adapter.AdapterRecycleViewHome2;
import com.example.finalproject.R;

import java.util.ArrayList;

public class categories_1 extends Fragment {
    RecyclerView recycleview_cat;
    TextView see_more_1;

    public categories_1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_categories_1, container, false);
        recycleview_cat=view.findViewById(R.id.recycleview_cat);
        see_more_1=view.findViewById(R.id.see_more_1);
        ArrayList<String> title2 = new ArrayList<>();
        title2.add("كنب ثلاثة مقاعد");
        title2.add("كنب مقعدين");
        title2.add("كنب ثلاثة مقاعد");
        title2.add("كنب مقعدين");
        title2.add("كنب ثلاثة مقاعد");
        ArrayList<Integer> photo2 = new ArrayList<>();
        photo2.add(R.drawable.photo_item_1);
        photo2.add(R.drawable.photo_item_2);
        photo2.add(R.drawable.photo_item_3);
        photo2.add(R.drawable.photo_item_1);
        photo2.add(R.drawable.photo_item_2);
        ArrayList<String> price = new ArrayList<>();
        price.add("180 $");
        price.add("120 $");
        price.add("150 $");
        price.add("190 $");
        price.add("250 $");
        ArrayList<Float> rating = new ArrayList<>();
        rating.add(4.5f);
        rating.add(3.5f);
        rating.add(4f);
        rating.add(2.5f);
        rating.add(5f);

        AdapterRecycleViewHome2 adapter2 = new AdapterRecycleViewHome2(getActivity(),title2,photo2,price,rating);
        recycleview_cat.setAdapter(adapter2);
        RecyclerView.LayoutManager layoutManager2 =new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recycleview_cat.setLayoutManager(layoutManager2);

        see_more_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Show_All_Categories.class);
                startActivity(intent);
            }
        });

        return view;
    }
}