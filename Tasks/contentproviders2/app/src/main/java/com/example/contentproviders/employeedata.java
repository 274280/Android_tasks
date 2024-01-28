package com.example.contentproviders;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class employeedata {
    String name,id;
    int salary;
    employeedata(String name,String id, int salary) {
        this.name = name;
        this.id = id;
        this.salary=salary;
    }
}