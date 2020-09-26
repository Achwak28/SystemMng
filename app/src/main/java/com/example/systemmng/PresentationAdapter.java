package com.example.systemmng;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class PresentationAdapter extends FirestoreRecyclerAdapter<Presentation_type, PresentationAdapter.PresentationHolder> {


    public PresentationAdapter(@NonNull FirestoreRecyclerOptions<Presentation_type> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PresentationHolder presentationHolder, int i, @NonNull Presentation_type presentation_type) {
        presentationHolder.textviewFullname.setText(presentation_type.getFullName());
        presentationHolder.textviewPresenation.setText(presentation_type.getPresentation());
    }

    @NonNull
    @Override
    public PresentationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.presentation_item,
                parent,false);
        return new PresentationHolder(v);
    }


    class PresentationHolder extends RecyclerView.ViewHolder{

        TextView textviewFullname,textviewPresenation;

        public PresentationHolder(@NonNull View itemView) {
            super(itemView);
            textviewFullname=itemView.findViewById(R.id.text_full);
            textviewPresenation=itemView.findViewById(R.id.text_pres);
        }
    }
}
