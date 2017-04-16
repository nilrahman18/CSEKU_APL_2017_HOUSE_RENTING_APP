package com.example.niloy.my_house_renting_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by niloy on 3/5/2017.
 */

public class Upload_Page extends AppCompatActivity{

    EditText Name;
    EditText Division;
    EditText Address;
    EditText Description;
    EditText Price;
    EditText Contact;
    Button Add_Informations;

    String SERVER_URL = "http://192.168.0.103/Upload_Info.php";
    AlertDialog.Builder Builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        Name = (EditText) findViewById(R.id.Name);
        Address = (EditText) findViewById(R.id.Address);
        Contact = (EditText) findViewById(R.id.Contact);
        Division = (EditText) findViewById(R.id.Division);
        Price = (EditText) findViewById(R.id.Price);
        Description = (EditText) findViewById(R.id.Description);

        Builder = new AlertDialog.Builder(Upload_Page.this);

        Add_Informations = (Button)findViewById(R.id.Add_Informations);

        Add_Informations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MakeRequest();
                startActivity(new Intent(Upload_Page.this, Image_Upload.class));

            }
        });
    }

    private void MakeRequest()
    {

        final String User_Name, User_Division, User_Address, User_Description, User_Price, User_Contact;
        User_Name = Name.getText().toString();
        User_Division = Division.getText().toString();
        User_Address = Address.getText().toString();
        User_Description = Description.getText().toString();
        User_Price = Price.getText().toString();
        User_Contact = Contact.getText().toString();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, SERVER_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Builder.setTitle("Server Response");
                Builder.setMessage("Response :" + response);
                Builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Name.setText("");
                                Division.setText("");
                                Address.setText("");
                                Description.setText("");
                                Price.setText("");
                                Contact.setText("");
                            }
                        }


                );

                AlertDialog alertDialog = Builder.create();
                alertDialog.show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Upload_Page.this, "Error", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> Params = new HashMap<>();
                Params.put("Name", User_Name);
                Params.put("Division", User_Division);
                Params.put("Address", User_Address);
                Params.put("Description", User_Description);
                Params.put("Price", User_Price);
                Params.put("Contact", User_Contact);
                return Params;
            }
        };
        Data_Posting_Helper.getData_posting_helper(Upload_Page.this).addtorequestqueue(stringRequest);
    }

}