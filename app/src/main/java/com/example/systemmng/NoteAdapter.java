package com.example.systemmng;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    List<Note> note = new ArrayList<>();
    OnItemClickListener listener;


    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {

        Note currentNote = note.get(position);
        holder.title.setText(currentNote.title);
        holder.description.setText(currentNote.description);
        holder.priority.setText(String.valueOf(currentNote.priority));

        holder.test2.setText(currentNote.test2);
        holder.presence.setText(currentNote.presence);


    }

    @Override
    public int getItemCount() {
        return note.size();
    }

    public void setNotes(List<Note> notes) {
        this.note = notes;
        notifyDataSetChanged();
    }

    public Note getNoteAt(int position) {
        return note.get(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        TextView title, priority, description,test2,presence;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_view_title);
            description = itemView.findViewById(R.id.text_view_description);
            priority = itemView.findViewById(R.id.text_view_priority);
            test2=itemView.findViewById(R.id.test_2);
            presence=itemView.findViewById(R.id.text_view_presence);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) ;
                    {
                        listener.onItemClick(note.get(position));
                    }

                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Note note);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {

        this.listener = listener;
    }
}
