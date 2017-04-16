package com.example.niloy.my_house_renting_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by niloy on 4/16/2017.
 */

public class Division_Selector extends AppCompatActivity
{

    Button Dhaka;
    Button Chittagong;
    Button Khulna;
    Button Rajshahi;
    Button Sylhet;
    Button Barisal;
    Button Rangpur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.divison_selector);
        Dhaka = (Button) findViewById(R.id.dhaka);
        Khulna = (Button) findViewById(R.id.khulna);
        Chittagong = (Button) findViewById(R.id.chittagong);
        Rajshahi = (Button) findViewById(R.id.rajshahi);
        Barisal = (Button) findViewById(R.id.barisal);
        Sylhet = (Button) findViewById(R.id.sylhet);
        Rangpur = (Button) findViewById(R.id.rangpur);

        Khulna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Division_Selector.this,Search_Khulna.class));
            }
        });

        Dhaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Division_Selector.this,Search_Dhaka.class));
            }
        });

        Rangpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Division_Selector.this,Search_Rangpur.class));
            }
        });

        Chittagong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Division_Selector.this,Search_Chittagong.class));
            }
        });

        Rajshahi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Division_Selector.this,Search_Rajshahi.class));
            }
        });

        Barisal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Division_Selector.this,Search_Barisal.class));
            }
        });

        Sylhet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Division_Selector.this,Search_Sylhet.class));
            }
        });

    }

}
