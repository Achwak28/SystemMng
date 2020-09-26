package com.example.systemmng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.RenderScript;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddEdit extends AppCompatActivity {
    public static final String EXTRA_ID = "com.example.systemmng.EXTRA_ID";
    public static final String EXTRA_TITLE = "com.example.systemmng.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "com.example.systemmng.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "com.examplde.systemmng.EXTRA_PRIORITY";
    public static final String EXTRA_TEST2 = "com.examplde.systemmng.EXTRA_TEST2";
    public static final String EXTRA_PRESENCE = "com.examplde.systemmng.EXTRA_PRESENCE";
    EditText title,description,test2,presence;
  // NumberPicker priority;
    String priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title= findViewById(R.id.edit_title);
        description=findViewById(R.id.edit_description);
     //   priority=findViewById(R.id.numberPicker);
        test2=findViewById(R.id.edit_test2);
        presence=findViewById(R.id.edit_presence);

     /*   priority.setMinValue(0);
        priority.setMaxValue(20);*/

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent= getIntent();

        if (intent.hasExtra(EXTRA_ID)){
            setTitle("Edit Note");
            title.setText(intent.getStringExtra(EXTRA_TITLE));
            description.setText(intent.getStringExtra(EXTRA_DESCRIPTION));

           // priority.setValue(intent.getIntExtra(EXTRA_PRIORITY, 0));
            test2.setText(intent.getStringExtra(EXTRA_TEST2));
            presence.setText(intent.getStringExtra(EXTRA_PRESENCE));

        } else {
            setTitle("Add Note");
        }


    }

    public  void saveNote(){
        String txtTitle = title.getText().toString();
        String txtDescription = description.getText().toString();
       // int prio = priority.getValue();
        String tst2= test2.getText().toString();
        String pres= presence.getText().toString();


        if (txtTitle.isEmpty() || txtDescription.isEmpty()){
            Toast.makeText(this, "Please insert a title and a description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_TITLE, txtTitle);
        intent.putExtra(EXTRA_DESCRIPTION,txtDescription);
        //intent.putExtra(EXTRA_PRIORITY,prio);
        intent.putExtra(EXTRA_TEST2,tst2);
        intent.putExtra(EXTRA_PRESENCE,pres);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1){
            intent.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, intent);
        finish();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }
}

/*
  <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Priority:"
        android:layout_marginTop="8dp"
        android:textAppearance="@style/TextAppearance.AppCompat.Medium"/>

    <NumberPicker
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/numberPicker"
        />
 */
