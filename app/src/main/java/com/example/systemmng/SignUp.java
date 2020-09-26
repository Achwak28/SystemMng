package com.example.systemmng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
  Button btn_go,hom;
  EditText regName,regUserName,regEmail,regPhone,regPassword;

  FirebaseDatabase rootNode;
  DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
       hom= findViewById(R.id.log_in);
       regName=findViewById(R.id.name);
       regUserName=findViewById(R.id.username);
       regEmail=findViewById(R.id.email);
       regPhone=findViewById(R.id.phoneNumber);
       regPassword=findViewById(R.id.password);



       hom.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i= new Intent(SignUp.this,Login.class);
               startActivity(i);
           }
       });
     btn_go = findViewById(R.id.hom_btn);
     btn_go.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             rootNode=FirebaseDatabase.getInstance();
             reference=rootNode.getReference("users");
             // get all the values from the text filds
             String name=regName.getText().toString();
             String username=regUserName.getText().toString();
             String email=regEmail.getText().toString();
             String phone=regPhone.getText().toString();
             String password=regPassword.getText().toString();

             UserHelperClass helperClass=new UserHelperClass(name,username,email,phone,password);

             reference.child(phone).setValue(helperClass);
             Toast.makeText(SignUp.this,"User Registered Successfull",Toast.LENGTH_SHORT).show();
             Intent intent = new Intent(SignUp.this, Home.class);
             startActivity(intent);
         }
     });
    }
}

/*    <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="200dp"
            android:background="#0099ff"
            android:padding="20dp">



            <ImageView
                android:id="@+id/profile_image"
                android:layout_width="100dp"
                android:layout_height="100dp"
                android:layout_centerVertical="true"
                android:src="@drawable/profile" />

            <TextView
                android:id="@+id/full_name"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_centerVertical="true"
                android:layout_marginLeft="10dp"
                android:layout_toRightOf="@id/profile_image"
                android:fontFamily="sans-serif-black"
                android:includeFontPadding="false"
                android:text="Achwak Cherif"
                android:textColor="#000"
                android:textSize="20sp" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_below="@id/full_name"
                android:layout_marginLeft="10dp"
                android:layout_toRightOf="@id/profile_image"
                android:includeFontPadding="false"
                android:text="Achwak Cherif"
                android:textSize="14sp"

                />


        </RelativeLayout>

*/
