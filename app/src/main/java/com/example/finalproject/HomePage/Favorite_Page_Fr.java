package com.example.finalproject.HomePage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalproject.AdapterFavorite;
import com.example.finalproject.R;

import java.util.ArrayList;

public class Favorite_Page_Fr extends Fragment {

    RecyclerView recyclerView;
    AdapterFavorite adapterFavorite;


    public Favorite_Page_Fr() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_favorite__page_, container, false);
        recyclerView=view.findViewById(R.id.recycleView_Favorite);

        ArrayList<String> title = new ArrayList<>();
        title.add("كنب ثلاثة مقاعد");
        title.add("كنب مقعدين");
        title.add("كنب ثلاثة مقاعد");
        title.add("كنب مقعدين");
        title.add("كنب ثلاثة مقاعد");
        ArrayList<Integer> photo = new ArrayList<>();
        photo.add(R.drawable.photo_item_1);
        photo.add(R.drawable.photo_item_2);
        photo.add(R.drawable.photo_item_3);
        photo.add(R.drawable.photo_item_1);
        photo.add(R.drawable.photo_item_2);
        ArrayList<String> price = new ArrayList<>();
        price.add("180 $");
        price.add("120 $");
        price.add("150 $");
        price.add("190 $");
        price.add("250 $");

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        adapterFavorite= new AdapterFavorite(getActivity(),title,photo,price);
        recyclerView.setAdapter(adapterFavorite);
        return view;
    }
}