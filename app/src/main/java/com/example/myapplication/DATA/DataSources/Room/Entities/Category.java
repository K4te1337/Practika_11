package com.example.myapplication.DATA.DataSources.Room.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Category {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "catName")
    public String catName;
    @ColumnInfo(name = "img")
    public int img;
}
