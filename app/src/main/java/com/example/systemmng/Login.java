package com.example.systemmng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    Button callSignUp,go_btn;
    ImageView image;
    TextView logoText, sloganText;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        image= findViewById(R.id.logoImage);
        logoText= findViewById(R.id.logoName);
        sloganText=findViewById(R.id.sloganName);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        go_btn=findViewById(R.id.go);

        go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser(v);


            }
        });

        callSignUp= findViewById(R.id.signup_screen);

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);

                Pair[] pairs = new Pair[5];
                pairs[0] = new Pair<View, String>(image,"logo_image");
                pairs[1] = new Pair<View, String>(logoText,"logo_text");
                pairs[2] = new Pair<View, String>(sloganText,"logo_text");
                pairs[3] = new Pair<View, String>(username,"username_");
                pairs[4] = new Pair<View, String>(password,"password_");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);

                    startActivity(intent,options.toBundle());
                }
            }
        });


    }

    public boolean validateUserName(){
        String val= username.getText().toString();
       // String noWhiteSpace="\\A\\w{4,20}\\8";

        if (val.isEmpty()){
            username.setError("Field can not be empty");
            return false;
        } else {
           return true;
        }
    }

    public boolean validatePassword(){
        String val = password.getText().toString();

        if (val.isEmpty()){
            password.setError("Field can not be empty");
            return false;
        } else{
            return true;
        }
    }

  public void LoginUser(View view){
        if (!validateUserName() | !validatePassword()){

            return;

        }
       /* else {
            isUser();

        }*/
  }

  /*  private void isUser() {
        final String userEntered = username.getText().toString().trim();
        final String passwordEntered = password.getText().toString().trim();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");

        Query checkUser= reference.orderByChild("username").equalTo(userEntered);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    username.setError(null);
                    String passwordFromDB = dataSnapshot.child(userEntered).child("password").getValue(String.class);

                    if (passwordFromDB.equals(passwordEntered)){



                        String nameFromDB = dataSnapshot.child(userEntered).child("name").getValue(String.class);
                        String usernameFromDB = dataSnapshot.child(userEntered).child("username").getValue(String.class);
                        String phoneFromDB = dataSnapshot.child(userEntered).child("phone").getValue(String.class);
                        String emailFromDB = dataSnapshot.child(userEntered).child("email").getValue(String.class);

                        Intent intent = new Intent(Login.this, UserProfile.class);

                        intent.putExtra("name",nameFromDB);
                        intent.putExtra("username",usernameFromDB);
                        intent.putExtra("phone",phoneFromDB);
                        intent.putExtra("email",emailFromDB);
                        intent.putExtra("password",passwordFromDB);

                        startActivity(intent);



                    }
                   /* else {
                        password.setError("Wrong password");
                        password.requestFocus();

                    }

                }
                else {
                    username.setError("User do not exist");
                    username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }*/
}
