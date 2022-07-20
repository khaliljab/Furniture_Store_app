package com.example.finalproject.OnboardingAndSplash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.finalproject.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;

public class ShowOnboarding extends AppCompatActivity {
    ViewPager2 viewPager2;
    DotsIndicator dotsIndicator;
    TextView skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_onboarding);
        dotsIndicator=findViewById(R.id.dots_indicator);
        viewPager2=findViewById(R.id.viewPager2);
        skip=findViewById(R.id.skip);

        ArrayList<Fragment> fragments =new ArrayList<>();
        fragments.add(new Onboarding_1());
        fragments.add(new Onboarding_2());
        fragments.add(new Onboarding_3());


        Adapter adapter =new Adapter(this,fragments);
        viewPager2.setAdapter(adapter);
        dotsIndicator.setViewPager2(viewPager2);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager2.setCurrentItem(getItem(+2));
            }
        });
    }
    private int getItem(int i) {
        return viewPager2.getCurrentItem() +i;
    }
}