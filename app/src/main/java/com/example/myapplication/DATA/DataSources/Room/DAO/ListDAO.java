package com.example.myapplication.DATA.DataSources.Room.DAO;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.DATA.DataSources.Room.Entities.Category;

import java.util.List;
@Dao
public interface ListDAO {
    @Query("SELECT * FROM Category WHERE catName LIKE :itemName")
    Category getCategoryByName(String itemName);
    @Insert
    void insertCategory(Category... categories);
    @Delete
    void deleteCategory(Category category);
    @Update
    void updateCategory(Category category);
}
