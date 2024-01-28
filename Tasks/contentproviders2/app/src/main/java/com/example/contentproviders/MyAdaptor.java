package com.example.contentproviders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyAdaptor extends RecyclerView.Adapter<Myviewholder> {
    Context context;
    List<employeedata> list = new ArrayList<employeedata>();

    public MyAdaptor(List<employeedata> employdata,Context context) {
        this.list = employdata;
        this.context=context;

    }





    @NonNull
    @Override
    public Myviewholder onCreateViewHolder( ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.cardview,parent,false);
        Myviewholder viewholder = new Myviewholder(v);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        holder.name.setText(list.get(position).name);
        holder.id.setText(list.get(position).id);
        holder.salary.setText(list.get(position).salary);


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}