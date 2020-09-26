package com.example.systemmng;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM student_table")
    void deleteAllNotes();


    @Query("SELECT * FROM student_table ORDER BY priority DESC")
     LiveData<List<Note>> getAllNotes();



}



