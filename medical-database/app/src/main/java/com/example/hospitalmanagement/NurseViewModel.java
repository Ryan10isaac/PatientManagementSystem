package com.example.hospitalmanagement;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NurseViewModel extends AndroidViewModel
{
    private NurseRepository repository;
    private LiveData<List<Nurse>> allNurses;
    private LiveData<Integer> insertSuccessful;

    public LiveData<Integer> getInsertSuccessful() {
        return insertSuccessful;
    }

    public NurseViewModel(@NonNull Application application) {
        super(application);

        repository =new NurseRepository(application);
        allNurses = repository.getAllNurses();

        insertSuccessful = repository.getInsertSuccessful();

    }

    public void insert(Nurse nurse){
        repository.insert(nurse);
    }

    public LiveData<List<Nurse>> getAllNurses() {
        return allNurses;
    }


}
