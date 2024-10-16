package com.example.hospitalmanagement;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "nurse_table")
public class Nurse {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "nurseId")
    private int nurseId;

    @ColumnInfo(name = "password")
    private String password;

    @Nullable
    @ColumnInfo(name = "firstName")
    private String firstName;

    @Nullable
    @ColumnInfo(name = "lastName")
    private String lastName;

    @Nullable
    @ColumnInfo(name = "department")
    private String department;

    public Nurse(Integer nurseId, String password, @Nullable String firstName, @Nullable String lastName, @Nullable String department) {
        this.nurseId = nurseId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public int getNurseId() {
        return nurseId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getPassword() {
        return password;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
