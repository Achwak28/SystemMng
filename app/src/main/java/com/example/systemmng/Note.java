package com.example.systemmng;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")

public class Note {

    @PrimaryKey(autoGenerate = true)
    public int id;


    public String priority;
    public String title;
    public String description;
    public String test2;
    public String presence;

    public Note(String title, String description, String priority,String test2,String presence) {
        this.title = title;
        this.description=description;
        this.priority=priority;
        this.test2=test2;
        this.presence=presence;
    }

    public void setId(int id) {
        this.id = id;
    }
}
