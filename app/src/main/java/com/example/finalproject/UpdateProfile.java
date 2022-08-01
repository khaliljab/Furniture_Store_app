package com.example.finalproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.finalproject.HomePage.HomeActivity;
import com.example.finalproject.HomePage.Profile_Page_Fr;
import com.example.finalproject.LoginAndRegister.LoginActivity;
import com.example.finalproject.LoginAndRegister.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class UpdateProfile extends AppCompatActivity {

    ImageView add_photo,image_person;
    EditText ed_Address,ed_phone,ed_Username;
    FirebaseStorage firebaseStorage;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firestore;
    Uri uri;
    Button save_update;
    ProgressBar progressBar;


    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    uri =result.getData().getData();
                    image_person.setImageURI(uri);
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        ed_Address = findViewById(R.id.ed_Address);
        ed_phone = findViewById(R.id.ed_phone);
        add_photo = findViewById(R.id.add_photo);
        image_person = findViewById(R.id.image_person);
        save_update = findViewById(R.id.save_update);
        progressBar = findViewById(R.id.progressBar_profile);
        ed_Username = findViewById(R.id.ed_Username);



        firebaseStorage=FirebaseStorage.getInstance();
        firestore= FirebaseFirestore.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();

        add_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                launcher.launch(intent);
            }
        });


        save_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String address =ed_Address.getText().toString();
                    String phone =ed_phone.getText().toString();
                    String Name = ed_Username.getText().toString();
                    HashMap<String,Object> map =new HashMap<>();
                    map.put("Address",address);
                    map.put("Phone",phone);
                    map.put("Name",Name);

                if(Name.isEmpty()){
                    ed_Username.setError("الرجاء إدخال اسم المستخدم");
                    return;
                }

                    if(address.isEmpty()){
                        ed_Address.setError("الرجاء إدخال العنوان");
                        return;
                    }
                    if(phone.isEmpty()) {
                        ed_phone.setError("الرجاء إدخال رقم الهاتف");
                        return;
                    }
                    progressBar.setVisibility(View.VISIBLE);
                    firebaseStorage.getReference().child("images").child(firebaseAuth.getCurrentUser().getUid()).putFile(uri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if (task.isSuccessful()){
                                firebaseStorage.getReference().child("images").child(firebaseAuth.getCurrentUser().getUid()).getDownloadUrl()
                                        .addOnCompleteListener(new OnCompleteListener<Uri>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Uri> task) {
                                                task.getResult();
                                                map.put("Profile Photo",task.getResult());
                                                firestore.collection("Users").document(firebaseAuth.getCurrentUser().getUid())
                                                        .update(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        finish();
                                                    }
                                                });

                                            }
                                        });
                            }
                        }
                    });
                }

        });

        firestore.collection("Users").document(firebaseAuth.getCurrentUser().getUid())
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String UserName =(String) task.getResult().getData().get("Name");
                ed_Username.setText(UserName);
            }
        });
    }
}