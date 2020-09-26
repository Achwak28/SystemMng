package com.example.systemmng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Home extends AppCompatActivity {

    LinearLayout marks,list,profile,contactus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        marks=findViewById(R.id.layoutStudent);
        profile=findViewById(R.id.layoutProfile);
        list=findViewById(R.id.layoutMark);
        contactus=findViewById(R.id.layoutContact);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,UserProfile.class);
                startActivity(intent);
            }
        });
        marks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
