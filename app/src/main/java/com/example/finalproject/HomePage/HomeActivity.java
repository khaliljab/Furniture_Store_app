package com.example.finalproject.HomePage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;


public class HomeActivity extends AppCompatActivity {
    BottomNavigationView nav_bar;
    TextView title_page;
    TextView Username_drawer;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    NavigationView navigationView;
    ImageButton menu_btn;
    DrawerLayout drawer;
    ImageView person_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        title_page=findViewById(R.id.title_page_home);
        nav_bar=findViewById(R.id.bottomNavigation);
        navigationView = findViewById(R.id.drawer);
        View headerView = navigationView.getHeaderView(0);
        Username_drawer= headerView.findViewById(R.id.Username_drawer);
        person_photo= headerView.findViewById(R.id.person_photo);
        menu_btn =findViewById(R.id.menu_btn);
        drawer = findViewById(R.id.drawer_layout);

        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();

        String id =firebaseAuth.getCurrentUser().getUid();

        firebaseFirestore.collection("Users").document(id)
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String name= (String) task.getResult().getData().get("Name");
                Username_drawer.setText(name);
                String image = (String) task.getResult().getData().get("Profile Photo");
                Picasso.get().load(image).into(person_photo);
            }
        });

        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
//                        fragment(new Home_Page_Fr());
//                        title_page.setText("الرئيسية");
                        Intent intent = new Intent(HomeActivity.this,HomeActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.facebook:
                        String urlPage = "https://www.facebook.com/modern.for.furniture";
                        Intent intent1 = new Intent(Intent.ACTION_VIEW);
                        intent1.setData(Uri.parse(urlPage));
                        startActivity(intent1);
                        break;

                    case R.id.call:

                        Intent intent2 = new Intent(Intent.ACTION_DIAL);
                        intent2.setData(Uri.parse("tel:+972597598035"));
                        startActivity(intent2);
                        break;

                    case R.id.logout:
                        SharedPreferences preferences =getSharedPreferences("MyFile",MODE_PRIVATE);
                        SharedPreferences.Editor editor= preferences.edit();
                        editor.putString("rem","false");
                        editor.apply();
                        finish();

                        break;
                }
                drawer.closeDrawer(GravityCompat.START);

                return true;
            }
        });



        fragment(new Home_Page_Fr());
        nav_bar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    fragment(new Home_Page_Fr());
                    title_page.setText("الرئيسية");
                    break;
                case R.id.favorite:
                    fragment(new Favorite_Page_Fr());
                    title_page.setText("المفضلة");

                    break;
                case R.id.cart:
                    fragment(new Cart_Page_Fr());
                    title_page.setText("السلة");

                    break;
                case R.id.profile:
                    fragment(new Profile_Page_Fr());
                    title_page.setText("الملف الشخصي");

                    break;
            }
            return true;
        });
    }
    public void fragment(Fragment fragment){
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }
}