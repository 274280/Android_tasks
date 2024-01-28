package com.elektrobit.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EmployeeAdapter adapter;
    RecyclerView recyclerView;
    ClickListener listener;



    List<EmployeeData> list = new ArrayList<EmployeeData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView username= findViewById(R.id.employeename);
        TextView emp_id = findViewById(R.id.id);
        TextView emp_dep = findViewById(R.id.dep);

        recyclerView
                = (RecyclerView)findViewById(
                R.id.recyclerView);
        Button b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(new EmployeeData(username.getText().toString(),emp_id.getText().toString(),emp_dep.getText().toString()));
                adapter.notifyItemInserted(list.size()-1);
            }
        });
        listener = new ClickListener() {
            @Override
            public void click(int index){
                Toast.makeText(getApplicationContext(), "Clicked item index is "+index, Toast.LENGTH_SHORT).show();
            }
        };
        adapter
                = new EmployeeAdapter(
                list, getApplication(),listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(MainActivity.this));


    }



    private List<EmployeeData> getData()
    {
        List<EmployeeData> list = new ArrayList<>();
        list.add(new EmployeeData("Ayush",
                "123456",
                "COS"));
        list.add(new EmployeeData("Vivek",
                "923456",
                "COS"));
        list.add(new EmployeeData("Akshay",
                "823456",
                "COS"));
        list.add(new EmployeeData("Ayush",
                "123456",
                "COS"));
        list.add(new EmployeeData("Vivek",
                "923456",
                "COS"));
        list.add(new EmployeeData("Akshay",
                "823456",
                "COS"));
        list.add(new EmployeeData("Ayush",
                "123456",
                "COS"));
        list.add(new EmployeeData("Vivek",
                "923456",
                "COS"));
        list.add(new EmployeeData("Akshay",
                "823456",
                "COS"));
        list.add(new EmployeeData("Ayush",
                "123456",
                "COS"));
        list.add(new EmployeeData("Vivek",
                "923456",
                "COS"));
        list.add(new EmployeeData("Akshay",
                "823456",
                "COS"));

        return list;
    }
}