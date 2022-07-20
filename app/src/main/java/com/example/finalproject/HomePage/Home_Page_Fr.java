package com.example.finalproject.HomePage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.finalproject.HomePage.AdapterRecycleViewHome;
import com.example.finalproject.HomePage.AdapterRecycleViewHome2;
import com.example.finalproject.R;

import java.util.ArrayList;


public class Home_Page_Fr extends Fragment {

    public Home_Page_Fr() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home__page_, container, false);

        // slider image in home page

        ImageSlider imageSlider =view.findViewById(R.id.image_slider);
        ArrayList<SlideModel> slideModels =new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.slider_1,null));
        slideModels.add(new SlideModel(R.drawable.slider_2,null));
        slideModels.add(new SlideModel(R.drawable.slider_3,null));
        imageSlider.setImageList(slideModels);

        // Test to RecycleView_categories in home page

        ArrayList<String> title = new ArrayList<>();
        title.add("الكنب");
        title.add("الإضاءة");
        title.add("السجاد");
        title.add("طاولة سفرة");
        title.add("غرف نوم");
        ArrayList<Integer> photo = new ArrayList<>();
        photo.add(R.drawable.item_bg_2);
        photo.add(R.drawable.bg_1);
        photo.add(R.drawable.bg_2);
        photo.add(R.drawable.bg_3);
        photo.add(R.drawable.bg_4);

        RecyclerView recyclerView =view.findViewById(R.id.rv_1);
        AdapterRecycleViewHome adapter = new AdapterRecycleViewHome(getActivity(),title,photo);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);


        // Test to RecycleView_Details in home page

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

        RecyclerView recycle =view.findViewById(R.id.recycle);
        AdapterRecycleViewHome2 adapter2 = new AdapterRecycleViewHome2(getActivity(),title2,photo2,price,rating);
        recycle.setAdapter(adapter2);
        RecyclerView.LayoutManager layoutManager2 =new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recycle.setLayoutManager(layoutManager2);

        return view;
    }
}