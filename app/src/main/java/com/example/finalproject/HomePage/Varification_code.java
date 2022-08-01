package com.example.finalproject.HomePage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.finalproject.R;

public class Varification_code extends AppCompatActivity {
    Button confirm_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varification_code);
        confirm_code= findViewById(R.id.confirm_code);
        confirm_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Varification_code.this,NewPassword.class);
                startActivity(intent);
            }
        });
    }
}