package com.example.systemmng;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int ADD_NOTE_REQUEST = 1;
    public static final int EDIT_NOTE_REQUEST = 2;

    private NoteViewModel noteViewModel;
    RecyclerView recyclerView;
    FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd=findViewById(R.id.add_btn);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, AddEdit.class);
                startActivityForResult(i, ADD_NOTE_REQUEST);
            }
        });

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final NoteAdapter adapter= new NoteAdapter();
        recyclerView.setAdapter(adapter);

        noteViewModel= ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
               adapter.setNotes(notes);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            noteViewModel.delete(adapter.getNoteAt(viewHolder.getAdapterPosition()));

            Toast.makeText(MainActivity.this,"Note Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

       adapter.setOnItemClickListener(new NoteAdapter.OnItemClickListener() {
           @Override
           public void onItemClick(Note note) {
               Intent i = new Intent(MainActivity.this, AddEdit.class);

               i.putExtra(AddEdit.EXTRA_ID, note.id);
               i.putExtra(AddEdit.EXTRA_TITLE, note.title);
               i.putExtra(AddEdit.EXTRA_DESCRIPTION, note.description);
            //   i.putExtra(AddEdit.EXTRA_PRIORITY, note.priority);
               i.putExtra(AddEdit.EXTRA_TEST2, note.test2);
               i.putExtra(AddEdit.EXTRA_PRESENCE, note.presence);

               startActivityForResult(i, EDIT_NOTE_REQUEST);



           }
       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK){
            String title = data.getStringExtra(AddEdit.EXTRA_TITLE);
            String description = data.getStringExtra(AddEdit.EXTRA_DESCRIPTION);
           // String priority = data.getStringExtra(AddEdit.EXTRA_PRIORITY);
            String test2= data.getStringExtra(AddEdit.EXTRA_TEST2);
            String presence= data.getStringExtra(AddEdit.EXTRA_PRESENCE);
            String priority=String.valueOf(Integer.parseInt(test2)+Integer.parseInt(description)+Integer.parseInt(presence));

            Note note = new Note(title,description,priority,test2,presence);
            noteViewModel.insert(note);

            Toast.makeText(this,"Note saved", Toast.LENGTH_SHORT).show();
        } else if (requestCode == EDIT_NOTE_REQUEST && resultCode == RESULT_OK){
            int id = data.getIntExtra(AddEdit.EXTRA_ID, -1);

            if ( id == -1){
                Toast.makeText(this, "Note can't be updated", Toast.LENGTH_SHORT).show();
                return;
            }
            String title = data.getStringExtra(AddEdit.EXTRA_TITLE);
            String description = data.getStringExtra(AddEdit.EXTRA_DESCRIPTION);
          //  int priority = data.getIntExtra(AddEdit.EXTRA_PRIORITY, 1);

            String test2= data.getStringExtra(AddEdit.EXTRA_TEST2);
            String presence= data.getStringExtra(AddEdit.EXTRA_PRESENCE);
            String priority=String.valueOf(Integer.parseInt(test2)+Integer.parseInt(description)+Integer.parseInt(presence));

            Note note = new Note(title,description,priority,test2,presence);
            note.setId(id);
            noteViewModel.Update(note);
            Toast.makeText(this, "Note updated", Toast.LENGTH_SHORT).show();

        }
            else
         {
            Toast.makeText(this,"Not Saved", Toast.LENGTH_SHORT).show();
        }
    }
}
