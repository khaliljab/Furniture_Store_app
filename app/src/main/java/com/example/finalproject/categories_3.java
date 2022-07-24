package com.example.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalproject.HomePage.AdapterRecycleViewHome2;

import java.util.ArrayList;


public class categories_3 extends Fragment {
    RecyclerView recycleview_cat_3;

    public categories_3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_categories_3, container, false);
        recycleview_cat_3=view.findViewById(R.id.recycleview_cat_3);
        ArrayList<String> title2 = new ArrayList<>();
        title2.add("سجادة ملونة حجم كبير");
        title2.add("سجادة عجمي حجم وسط");
        title2.add("سجادة جلد حجم وسط");
        title2.add("سجادة ممرات حجم وسط");
        title2.add("سجادة بيضاء فاخرة");
        ArrayList<Integer> photo2 = new ArrayList<>();
        photo2.add(R.drawable.carpets_1);
        photo2.add(R.drawable.carpets_2);
        photo2.add(R.drawable.carpets_3);
        photo2.add(R.drawable.carpets_4);
        photo2.add(R.drawable.carpets_5);
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
        recycleview_cat_3.setAdapter(adapter2);
        RecyclerView.LayoutManager layoutManager2 =new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recycleview_cat_3.setLayoutManager(layoutManager2);
        return view;
    }
}