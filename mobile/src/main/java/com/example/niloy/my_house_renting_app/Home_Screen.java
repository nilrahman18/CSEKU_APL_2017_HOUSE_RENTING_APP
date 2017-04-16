package com.example.niloy.my_house_renting_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by niloy on 3/30/2017.
 */

public class Home_Screen extends AppCompatActivity {

    private int Splash_Time_Out = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable()
        {
         public void run() {
             Intent intent=new Intent(Home_Screen.this,Home.class);
             startActivity(intent);
         }

        },Splash_Time_Out);

    }
}