package com.example.finalproject.HomePage;

import static android.content.Context.MODE_PRIVATE;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Iterator;


public class Profile_Page_Fr extends Fragment {

    ImageView add_photo,image_person;
    FirebaseStorage firebaseStorage;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firestore;
    Uri uri;
    Button add_firestore;
    TextView TV_Username,TV_Email;
    LinearLayout liner_logout;

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
    public Profile_Page_Fr() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile__page_, container, false);

        liner_logout = view.findViewById(R.id.liner_logout);

        TV_Username = view.findViewById(R.id.TV_Username);
        TV_Email = view.findViewById(R.id.TV_Email);
        add_photo = view.findViewById(R.id.add_photo);
        image_person = view.findViewById(R.id.image_person);
        add_firestore = view.findViewById(R.id.add_firestore);
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


        add_firestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseStorage.getReference().child("images").child(firebaseAuth.getCurrentUser().getUid()).putFile(uri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                        if (task.isSuccessful()){
                            firebaseStorage.getReference().child("images").child(firebaseAuth.getCurrentUser().getUid()).getDownloadUrl()
                                    .addOnCompleteListener(new OnCompleteListener<Uri>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Uri> task) {
                                            task.getResult();
                                            HashMap<String,Object> map =new HashMap<>();
                                            map.put("Profile Photo",task.getResult());
                                            firestore.collection("Users").document(firebaseAuth.getCurrentUser().getUid())
                                                    .update(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
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
                String Email =(String) task.getResult().getData().get("Email");
                String UserName =(String) task.getResult().getData().get("Name");
                String image = (String) task.getResult().getData().get("Profile Photo");
                Picasso.get().load(image).into(image_person);
                TV_Username.setText(UserName);
                TV_Email.setText(Email);
            }
        });

        liner_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getActivity().getSharedPreferences("MyFile", MODE_PRIVATE);
                SharedPreferences.Editor editor= preferences.edit();
                editor.putString("rem","false");
                editor.apply();
                getActivity().finish();
            }
        });

        return view;

    }
}

















