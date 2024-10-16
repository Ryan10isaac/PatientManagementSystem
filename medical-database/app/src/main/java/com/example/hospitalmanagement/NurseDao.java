package com.example.hospitalmanagement;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NurseDao {

    @Insert
    void insert(Nurse nurse);

    @Query("SELECT * FROM nurse_table")
    LiveData<List<Nurse>> getAllNurses();

}
