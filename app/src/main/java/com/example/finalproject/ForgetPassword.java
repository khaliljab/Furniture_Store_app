package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finalproject.LoginAndRegister.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
    Button resetPassword;
    EditText Forgot_Email_Ed;
    FirebaseAuth firebaseAuth;
    ImageView back_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        back_btn = findViewById(R.id.back_btn);

        resetPassword = findViewById(R.id.resetPassword);
        Forgot_Email_Ed = findViewById(R.id.Forgot_Email_Ed);
        firebaseAuth =FirebaseAuth.getInstance();

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Forgot_Email_Ed.getText().toString();
                if(email.isEmpty()){
                    Forgot_Email_Ed.setError("الرجاء إدخال البريد الإلكتروني");
                    return;
                }else if(Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                }else
                    Forgot_Email_Ed.setError("خطأ في صيغة البريد الإلكتروني");

                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(ForgetPassword.this, "لقد قمنا بإرسال رسالة على البريد الإلكتروني بإمكانك إسترجاع كلمة المرور من خلاله", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(ForgetPassword.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(ForgetPassword.this, LoginActivity.class);
               startActivity(intent);
            }
        });













//        sent_code = findViewById(R.id.sent_code);
//        sent_code.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ForgetPassword.this,Varification_code.class);
//                startActivity(intent);
//            }
//        });
    }
}