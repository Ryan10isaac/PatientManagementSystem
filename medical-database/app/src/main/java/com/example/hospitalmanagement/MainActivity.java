package com.example.hospitalmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void moveToPatientListActivity(View view){
        Intent intent = new Intent(this, PatientListActivity.class);

        startActivity(intent);
    }

    public void moveToTestListActivity(View view){
        Intent intent = new Intent(this, TestListActivity.class);

        startActivity(intent);
    }


}