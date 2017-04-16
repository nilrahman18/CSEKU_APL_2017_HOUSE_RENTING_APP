package com.example.niloy.my_house_renting_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Search = (Button) findViewById(R.id.Search_Ad);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Division_Selector.class));
            }
        });

    }

    public void Go_To_Upload_Page(View Upload_Page_Layout)
    {
        String Upload_Page_Navigator = ((Button) Upload_Page_Layout).getText().toString();
        if (Upload_Page_Navigator.equals("Upload"))
        {
            Intent Open_Upload_Page = new Intent(this , Upload_Page.class);
            startActivity(Open_Upload_Page);
        }
    }

}
