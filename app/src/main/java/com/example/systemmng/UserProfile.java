package com.example.systemmng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {
  TextView username;
  EditText name,password,email,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        username=findViewById(R.id.usr_profile);
        name=findViewById(R.id.fName);
        email=findViewById(R.id.em);
        password=findViewById(R.id.pass);
        phone=findViewById(R.id.number);

        // show all data
        showAllUserData();


    }

    private void showAllUserData() {
        Intent intent=getIntent();
        String uName= intent.getStringExtra("username");
        String userName= intent.getStringExtra("name");
        String user_email= intent.getStringExtra("email");
        String user_phone= intent.getStringExtra("phone");
        String user_password= intent.getStringExtra("password");

        username.setText(userName);
        name.setText(uName);
        email.setText(user_email);
        phone.setText(user_phone);
        password.setText(user_password);

    }
}
/*
 <View
                android:layout_below="@id/topview"
                android:id="@+id/view3"
                android:layout_width="match_parent"
                android:layout_height="100dp"
                />




            <TextView

                android:paddingTop="80dp"
                android:id="@+id/full_name"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginLeft="32dp"
                android:layout_toRightOf="@id/profile_image"
                android:fontFamily="serif"
                android:includeFontPadding="false"
                android:text="Achwak Cherif"
                android:textColor="#000"
                android:textSize="30sp" />
 */
