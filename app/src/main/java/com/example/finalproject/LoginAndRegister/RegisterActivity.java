package com.example.finalproject.LoginAndRegister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.HomePage.HomeActivity;
import com.example.finalproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    TextView login_now;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    EditText ed_Username,ed_email,ed_password;
    Button create_account;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ImageView logo=findViewById(R.id.logo_Register);
        LinearLayout l =findViewById(R.id.container_Register);
        login_now=findViewById(R.id.login_now);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        ed_Username =findViewById(R.id.ed_Username_Reg);
        ed_email =findViewById(R.id.ed_email_Reg);
        ed_password =findViewById(R.id.ed_password_Reg);
        create_account =findViewById(R.id.create_account);
        progressBar =findViewById(R.id.progressBar_Register);


        // add Email and password in firebaseAuth
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name =ed_Username.getText().toString();
                String Email =ed_email.getText().toString();
                String Password =ed_password.getText().toString();
                HashMap<Object,Object> map =new HashMap<>();
                map.put("Name",Name);
                map.put("Email",Email);
                if(Name.isEmpty()){
                    ed_Username.setError("الرجاء إدخال اسم المستخدم");
                    return;
                }
                if(Email.isEmpty()){
                    ed_email.setError("الرجاء إدخال البريد الإلكتروني");
                    return;
                }else if(Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                }else
                    ed_email.setError("خطأ في صيغة البريد الإلكتروني");

                if(Password.isEmpty()){
                    ed_password.setError("الرجاء إدخال كلمة المرور");
                    return;
                }else if(Password.length()<6) {
                    ed_password.setError("يجب أن لا تكون كلمة المرور أقل من 6 خانات");
                }
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "تم إنشاء الحساب بنجاح", Toast.LENGTH_SHORT).show();
                        // add all data in Firestore
                        firebaseFirestore.collection("Users").document(firebaseAuth.getCurrentUser().getUid()).set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                ed_email.setText("");
                                ed_Username.setText("");
                                ed_password.setText("");
                            }
                        });
                        Intent intent =new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }else
                        Toast.makeText(RegisterActivity.this, "فشل إنشاء الحساب", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);

                    }

                });
            }
        });
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_login);
        logo.startAnimation(animation);
        l.startAnimation(animation);
        Animation animations = AnimationUtils.loadAnimation(this,R.anim.anim_login_buttom);
        l.startAnimation(animations);
        login_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}