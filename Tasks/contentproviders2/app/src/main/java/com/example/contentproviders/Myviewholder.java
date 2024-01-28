package com.example.contentproviders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Myviewholder extends RecyclerView.ViewHolder {
    TextView name,id,salary;
    View v;
    public Myviewholder(View itemview) {
        super(itemview);
        this.name = itemview.findViewById(R.id.text1);
        this.id = itemview.findViewById(R.id.text2);
        this.salary= itemview.findViewById(R.id.text3);
        this.v = itemview;
    }
}