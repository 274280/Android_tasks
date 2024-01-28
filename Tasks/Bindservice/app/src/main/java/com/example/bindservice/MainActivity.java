package com.example.bindservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyService myservice = new MyService();
    boolean Isbound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Main activity","oncreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        bindservice();
    }
    protected void onStop() {
        super.onStop();
        if(Isbound) {
            Log.d("MyServiceExample", "ServiceConnection:Disconnected.");
            unbindService(serviceConnection);
        }
    }

    private void bindservice()  {
        Log.i("Main activity","bindservice");
        Intent servicebind = new Intent(MainActivity.this,MyService.class);
        bindService(servicebind,serviceConnection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection serviceConnection =  new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("Main activity","serviceconnection");
        MyService.Mybinder binder = (MyService.Mybinder) service;
        myservice = binder.getservice();
        Isbound = true;
        sum();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("Service","service got disconnected");
            Isbound=false;

        }
    };
    private void sum() {
       // Log.d("Myserviceexample", "sum of two numbers" + myservice.sumofno(3, 5));
        Log.i("Main activity","sum");
        int a = myservice.sumofno(3, 5);
        Log.i("Main activity","returned value");
        Toast.makeText(MainActivity.this,a,Toast.LENGTH_LONG).show();
    }

}