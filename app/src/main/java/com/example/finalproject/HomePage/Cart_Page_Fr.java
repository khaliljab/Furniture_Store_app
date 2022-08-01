package com.example.finalproject.HomePage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalproject.R;

import java.util.ArrayList;


public class Cart_Page_Fr extends Fragment {
    RecyclerView recyclerView;
    AdapterCart adapterCart;

    public Cart_Page_Fr() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart__page_, container, false);
        recyclerView=view.findViewById(R.id.recycleView_cart);

        ArrayList<String> title = new ArrayList<>();
        title.add("كنب ثلاثة مقاعد");
        title.add("كنب مقعدين");
        title.add("كنب ثلاثة مقاعد");
        title.add("كنب مقعدين");
        title.add("كنب ثلاثة مقاعد");
        title.add("كنب ثلاثة مقاعد");
        ArrayList<Integer> photo = new ArrayList<>();
        photo.add(R.drawable.photo_item_1);
        photo.add(R.drawable.photo_item_2);
        photo.add(R.drawable.photo_item_3);
        photo.add(R.drawable.photo_item_1);
        photo.add(R.drawable.photo_item_2);
        photo.add(R.drawable.photo_item_2);
        ArrayList<String> price = new ArrayList<>();
        price.add("180 $");
        price.add("120 $");
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
        rating.add(5f);

        adapterCart = new AdapterCart(getActivity(),title,photo,price,rating);
        recyclerView.setAdapter(adapterCart);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);



        return view;
    }
}