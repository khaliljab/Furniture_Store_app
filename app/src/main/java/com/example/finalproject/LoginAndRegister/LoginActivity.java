package com.example.finalproject.LoginAndRegister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.ForgetPassword;
import com.example.finalproject.HomePage.HomeActivity;
import com.example.finalproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    TextView register_now,forget_password;
    ImageView logo;
    FirebaseAuth firebaseAuth;
    EditText ed_email,ed_password;
    Button login;
    ProgressBar progressBar;
    CheckBox remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logo=findViewById(R.id.logo_login);
        LinearLayout l =findViewById(R.id.container_login);
        login =findViewById(R.id.login);
        forget_password =findViewById(R.id.forget_password);
        firebaseAuth = FirebaseAuth.getInstance();
        ed_email = findViewById(R.id.ed_email_login);
        ed_password =findViewById(R.id.ed_password_login);
        progressBar =findViewById(R.id.progressBar);
        remember=findViewById(R.id.remember);


        SharedPreferences preferences =getSharedPreferences("MyFile",MODE_PRIVATE);
        String checkbox =preferences.getString("rem","");
        if (checkbox.equals("true")){
            Intent intent =new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
        }else if (checkbox.equals("false")){
        }
        // Verify login information by firebaseAuth
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email =ed_email.getText().toString();
                String Password =ed_password.getText().toString();

                if(Email.isEmpty()){
                    ed_email.setError("الرجاء إدخال البريد الإلكتروني");
                    return;
                }else if(Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                }else
                        ed_email.setError("خطأ في صيغة البريد الإلكتروني");

                if(Password.isEmpty()) {
                    ed_password.setError("الرجاء إدخال كلمة المرور");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }else
                        Toast.makeText(LoginActivity.this, "خطأ في البريد الالكتروني أو كلمة المرور", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });

            }
        });

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_login);
        logo.startAnimation(animation);
        Animation animations = AnimationUtils.loadAnimation(this,R.anim.anim_login_buttom);
        l.startAnimation(animations);
        register_now=findViewById(R.id.register_now);
        register_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this, ForgetPassword.class);
                startActivity(intent);
            }
        });

        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("rem","true");
                    editor.apply();

                }else if(!compoundButton.isChecked()){
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("rem","false");
                    editor.apply();

                }
            }
        });

    }

}