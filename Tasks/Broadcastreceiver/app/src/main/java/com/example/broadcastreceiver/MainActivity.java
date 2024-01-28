package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    reciever Reciever = new reciever();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter=new IntentFilter();
       filter.addAction("com.example.ANIL_BROADCAST");
        //filter.addAction("com.example.another_app");
       getApplicationContext().registerReceiver(Reciever,filter, Context.RECEIVER_NOT_EXPORTED);


        Button b1 = findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broadcast();
               // broadcast2();
            }


            public void broadcast() {
                Intent intent = new Intent();
                intent.setPackage("com.example.broadcastreceiver");
                //intent.setAction("com.example.ANIL_BROADCAST");
                sendBroadcast(intent);
            }
            public void broadcast2() {
                Intent intent = new Intent();
                intent.setPackage("com.example.broadcastreceiver");
                intent.setAction("com.example.another_app");
                sendBroadcast(intent);
            }
        });

    }
}