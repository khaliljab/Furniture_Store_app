package com.example.finalproject.OnboardingAndSplash;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.finalproject.LoginAndRegister.LoginActivity;
import com.example.finalproject.R;


public class Onboarding_3 extends Fragment {
    Button startNow;

    public Onboarding_3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_onboarding_3, container, false);
        startNow=view.findViewById(R.id.startNow);
        startNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;

    }
}