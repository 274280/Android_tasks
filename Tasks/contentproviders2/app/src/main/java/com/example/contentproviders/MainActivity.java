package com.example.contentproviders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyAdaptor adapter;
    List<employeedata>  list= new ArrayList<employeedata>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recycle = findViewById(R.id.recycler);

    adapter = new MyAdaptor(list,MainActivity.this);
    recycle.setAdapter(adapter);
    recycle.setLayoutManager(new LinearLayoutManager(this));

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void onClickAddDetails(View view) {

        EditText nameText = findViewById(R.id.textName);
        EditText employeID = findViewById(R.id.employeeID);
        EditText salary = findViewById(R.id.Salary);

        // class to add values in the database
        ContentValues values = new ContentValues();

        // fetching text from user
        values.put(MyContentProvider.EmployeeID,employeID.getText().toString());
        values.put(MyContentProvider.name,nameText.getText().toString());
        values.put(MyContentProvider.Salary,salary.getText().toString());

        // inserting into database through content URI
        getContentResolver().insert(MyContentProvider.CONTENT_URI, values);

        // displaying a toast message
        Toast.makeText(this, "New Record Inserted", Toast.LENGTH_LONG).show();

        nameText.setText("");
    }

    @SuppressLint("Range")
    public void onClickShowDetails(View view) {
        // inserting complete table details in this text field
        TextView resultView= (TextView) findViewById(R.id.res);

        // creating a cursor object of the
        // content URI
        Cursor cursor = getContentResolver().query(MyContentProvider.CONTENT_URI,
                null, null, null, null);

        // iteration of the cursor
        // to print whole table
        if(cursor.moveToFirst()) {
            //StringBuilder strBuild=new StringBuilder();
            while (!cursor.isAfterLast()) {
//                strBuild.append("\n").
//                        append(cursor.getString(cursor.getColumnIndex(MyContentProvider.id))).
//                        append("-").append(cursor.getString(cursor.getColumnIndex(MyContentProvider.name)))
//                        .append("-").append(cursor.getString(cursor.getColumnIndex(MyContentProvider.EmployeeID))).append("-").append(cursor.getString(cursor.getColumnIndex(MyContentProvider.Salary)));
                list.add(new employeedata(cursor.getString(cursor.getColumnIndex(MyContentProvider.name)),cursor.getString(cursor.getColumnIndex(MyContentProvider.EmployeeID)),cursor.getColumnIndex(MyContentProvider.Salary)));
                adapter.notifyItemInserted(list.size()-1);
                cursor.moveToNext();
            }
            //resultView.setText(strBuild);
        }
        else {
            resultView.setText("No Records Found");
        }
    }
}