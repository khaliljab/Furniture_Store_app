package com.example.finalproject.HomePage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalproject.HomePage.AdapterRecycleViewHome2;
import com.example.finalproject.R;

import java.util.ArrayList;


public class categories_5 extends Fragment {

    RecyclerView recycleview_cat_5;

    public categories_5() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories_5, container, false);
        recycleview_cat_5=view.findViewById(R.id.recycleview_cat_5);
        ArrayList<String> title2 = new ArrayList<>();
        title2.add("غرفة نوم فاخرة");
        title2.add("غرفة نوم ملكية");
        title2.add("غرفة نوم فاخرة");
        title2.add("غرفة نوم ملكية");
        title2.add("غرفة نوم فاخرة");
        ArrayList<Integer> photo2 = new ArrayList<>();
        photo2.add(R.drawable.room_1);
        photo2.add(R.drawable.room_2);
        photo2.add(R.drawable.room_3);
        photo2.add(R.drawable.room_4);
        photo2.add(R.drawable.room_5);
        ArrayList<String> price = new ArrayList<>();
        price.add("1560 $");
        price.add("3800 $");
        price.add("2800 $");
        price.add("2300 $");
        price.add("1680 $");
        ArrayList<Float> rating = new ArrayList<>();
        rating.add(4f);
        rating.add(4.5f);
        rating.add(4f);
        rating.add(3.5f);
        rating.add(5f);

        AdapterRecycleViewHome2 adapter2 = new AdapterRecycleViewHome2(getActivity(),title2,photo2,price,rating);
        recycleview_cat_5.setAdapter(adapter2);
        RecyclerView.LayoutManager layoutManager2 =new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recycleview_cat_5.setLayoutManager(layoutManager2);
        return view;
    }
}