package com.example.systemmng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Presentation extends AppCompatActivity {
    FirebaseFirestore db= FirebaseFirestore.getInstance();
    CollectionReference presentationRef = db.collection("Presentation");

    PresentationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

       // setUpRecyclerview();
    }

   /* private void setUpRecyclerview() {
        Query query=presentationRef.orderBy("presentation",Query.Direction.DESCENDING);

        FirebaseRecyclerOptions.Builder<Presentation_type> presentation_typeBuilder = new FirebaseRecyclerOptions.Builder<Presentation_type>();
        presentation_typBuilder.setQuery(query, Presentation_type.class);
        FirebaseRecyclerOptions<Presentation_type> options= presentation_typBuilder
                .build();

    }*/
}
