package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wynsbin.vciv.VerificationCodeInputView;

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