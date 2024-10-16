package com.example.hospitalmanagement;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class NurseRepository {
    private NurseDao nurseDao;
    private LiveData<List<Nurse>> allNurses;

    private MutableLiveData<Integer> insertSuccessful = new MutableLiveData<>();

    public LiveData<Integer> getInsertSuccessful() {
        return insertSuccessful;
    }


    public NurseRepository(Application application){
        AppDatabase db = AppDatabase.getInstance(application);
        nurseDao=db.nurseDao();
        allNurses= nurseDao.getAllNurses();
    }

    public void insert(Nurse nurse){
        insertAsync(nurse);
    }

    public LiveData<List<Nurse>> getAllNurses(){
        return allNurses;
    }

    private void insertAsync(final Nurse nurse) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    nurseDao.insert(nurse);
                    insertSuccessful.postValue(1);
                } catch (Exception e) {
                    insertSuccessful.postValue(0);
                }
            }
        }).start();
    }


}
