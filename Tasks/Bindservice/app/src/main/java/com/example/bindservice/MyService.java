package com.example.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private final IBinder iBinder = new Mybinder();
    public MyService() {
    }
    public class Mybinder extends Binder {
        MyService getservice() {
            Log.i("Main service","binder");
            return MyService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return iBinder;
    }
    public int sumofno(int a,int b) {

        Log.i("My service","sum");
        return a+b;
    }
}