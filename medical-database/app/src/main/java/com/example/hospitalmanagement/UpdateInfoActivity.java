package com.example.hospitalmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateInfoActivity extends AppCompatActivity {
    private PatientViewModel patientViewModel;

    private EditText editTextNurseId;
    private EditText editTextPatientId;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextDepartment;
    private EditText editTextRoom;
    private Button btnUpdatePatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);

        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);

        editTextNurseId=findViewById(R.id.editTextNurseId);
        editTextPatientId=findViewById(R.id.editTextPatientId);
        editTextFirstName=findViewById(R.id.editTextFirstName);
        editTextLastName=findViewById(R.id.editTextLastName);
        editTextDepartment=findViewById(R.id.editTextDepartment);
        editTextRoom=findViewById(R.id.editTextRoom);
        btnUpdatePatient=findViewById(R.id.btnUpdatePatient);

        Intent intent = getIntent();

        editTextNurseId.setText(String.valueOf(intent.getIntExtra("nurseId", 0)));
        editTextPatientId.setText(String.valueOf(intent.getIntExtra("patientId", 0)));
        editTextFirstName.setText(intent.getStringExtra("firstName"));
        editTextRoom.setText(intent.getStringExtra("room"));
        editTextDepartment.setText(intent.getStringExtra("department"));
        editTextLastName.setText(intent.getStringExtra("lastName"));

        btnUpdatePatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Integer patientIdToUpdate = Integer.parseInt(editTextPatientId.getText().toString());

                Patient updatedPatient = new Patient(patientIdToUpdate,
                        Integer.parseInt(editTextNurseId.getText().toString()),
                        editTextFirstName.getText().toString(),
                        editTextLastName.getText().toString(),
                        editTextDepartment.getText().toString(),
                        editTextRoom.getText().toString()
                        );
                patientViewModel.update(updatedPatient);

            }
        });
        patientViewModel.getUpdateSuccessful().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer result) {
                if (result == 1) {
                    Toast.makeText(UpdateInfoActivity.this, "Patient successfully updated.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), PatientListActivity.class);
                    startActivity(intent);
                    return;

                } else {
                    Toast.makeText(UpdateInfoActivity.this, "Error updating patient", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}