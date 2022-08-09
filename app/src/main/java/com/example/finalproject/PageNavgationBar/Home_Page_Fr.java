package com.example.finalproject.PageNavgationBar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.finalproject.HomePage.categories_1;
import com.example.finalproject.HomePage.categories_2;
import com.example.finalproject.HomePage.categories_3;
import com.example.finalproject.HomePage.categories_4;
import com.example.finalproject.HomePage.categories_5;
import com.example.finalproject.R;

import java.util.ArrayList;


public class Home_Page_Fr extends Fragment {

    Button cat_1,cat_2,cat_3,cat_4,cat_5;

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

        categories_1 c =new categories_1();
        fragment(c);

        cat_1=view.findViewById(R.id.cat_1);
        cat_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories_1 cat_1 = new categories_1();
                fragment(cat_1);
            }
        });
        cat_2=view.findViewById(R.id.cat_2);
        cat_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories_2 cat_2 = new categories_2();
                fragment(cat_2);

            }
        });
        cat_3=view.findViewById(R.id.cat_3);
        cat_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories_3 cat_3 = new categories_3();
                fragment(cat_3);
            }
        });
        cat_4=view.findViewById(R.id.cat_4);
        cat_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                categories_4 cat_4 = new categories_4();
                fragment(cat_4);
            }
        });
        cat_5=view.findViewById(R.id.cat_5);
        cat_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories_5 cat_5 = new categories_5();
                fragment(cat_5);
            }
        });



        return view;
    }
    public void fragment(Fragment fragment){
        FragmentManager fragmentManager =getChildFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_cat,fragment);
        fragmentTransaction.commit();
    }
    }













//        // Test to RecycleView_categories in home page
//
//        ArrayList<String> title = new ArrayList<>();
//        title.add("الكنب");
//        title.add("الإضاءة");
//        title.add("السجاد");
//        title.add("طاولة سفرة");
//        title.add("غرف نوم");
//        ArrayList<Integer> photo = new ArrayList<>();
//        photo.add(R.drawable.item_bg_2);
//        photo.add(R.drawable.bg_1);
//        photo.add(R.drawable.bg_2);
//        photo.add(R.drawable.bg_3);
//        photo.add(R.drawable.bg_4);
//
//        RecyclerView recyclerView =view.findViewById(R.id.rv_1);
//        AdapterRecycleViewHome adapter = new AdapterRecycleViewHome(getActivity(),title,photo);
//        recyclerView.setAdapter(adapter);
//        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
//        recyclerView.setLayoutManager(layoutManager);