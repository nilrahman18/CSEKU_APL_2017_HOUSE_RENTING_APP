package com.example.niloy.my_house_renting_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ParseException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by niloy on 4/16/2017.
 */

public class Search_Rangpur extends AppCompatActivity{

    ArrayList<Ads> adList;

    ListView listview;

    CustomAdapter adapter;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        spinner = (Spinner) findViewById(R.id.spinner);
        adList = new ArrayList<Ads>();
        new Search_Rangpur.JSONAsyncTask().execute("http://192.168.0.100/rangpur.php");

        listview = (ListView)findViewById(R.id.lv);
        adapter = new CustomAdapter(getApplicationContext(), R.layout.information_adapter, adList);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com"));
                startActivity(intent);
            }
        });

        listview.setTextFilterEnabled(true);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {

                    case 0:
                        new Search_Rangpur.JSONAsyncTask().execute("http://192.168.0.100/rangpur.php");

                        listview = (ListView)findViewById(R.id.lv);
                        adList.clear();
                        adapter = new CustomAdapter(getApplicationContext(), R.layout.information_adapter, adList);

                        listview.setAdapter(adapter);

                        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com"));
                                startActivity(intent);
                            }
                        });
                        break;

                    case 1:
                        new Search_Rangpur.JSONAsyncTask().execute("http://192.168.0.100/rangpur_1_5000.php");

                        listview = (ListView)findViewById(R.id.lv);
                        adList.clear();
                        adapter = new CustomAdapter(getApplicationContext(), R.layout.information_adapter, adList);

                        listview.setAdapter(adapter);

                        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com"));
                                startActivity(intent);
                            }
                        });
                        break;

                    case 2:
                        new Search_Rangpur.JSONAsyncTask().execute("http://192.168.0.100/rangpur_5001_10000.php");

                        listview = (ListView)findViewById(R.id.lv);
                        adList.clear();
                        adapter = new CustomAdapter(getApplicationContext(), R.layout.information_adapter, adList);

                        listview.setAdapter(adapter);

                        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com"));
                                startActivity(intent);
                            }
                        });
                        break;

                    case 3:
                        new Search_Rangpur.JSONAsyncTask().execute("http://192.168.0.100/rangpur_10001_15000.php");

                        listview = (ListView)findViewById(R.id.lv);
                        adList.clear();
                        adapter = new CustomAdapter(getApplicationContext(), R.layout.information_adapter, adList);

                        listview.setAdapter(adapter);

                        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com"));
                                startActivity(intent);
                            }
                        });
                        break;

                    case 4:
                        new Search_Rangpur.JSONAsyncTask().execute("http://192.168.0.100/rangpur_15001_20000.php");

                        listview = (ListView)findViewById(R.id.lv);
                        adList.clear();
                        adapter = new CustomAdapter(getApplicationContext(), R.layout.information_adapter, adList);

                        listview.setAdapter(adapter);

                        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com"));
                                startActivity(intent);
                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(Search_Rangpur.this);
            dialog.setMessage("Loading, please wait");
            dialog.setTitle("Connecting server");
            dialog.show();
            dialog.setCancelable(false);
        }

        @Override
        protected Boolean doInBackground(String... urls) {
            try {

                HttpGet httppost = new HttpGet(urls[0]);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(httppost);

                int status = response.getStatusLine().getStatusCode();

                if (status == 200) {
                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);


                    JSONObject jsono = new JSONObject(data);
                    JSONArray jarray = jsono.getJSONArray("Server_Response");

                    for (int i = 0; i < jarray.length(); i++) {
                        JSONObject object = jarray.getJSONObject(i);

                        Ads ads = new Ads();

                        ads.setName(object.getString("Name"));
                        ads.setURL(object.getString("URL"));
                        ads.setOwner(object.getString("Owner"));
                        ads.setDivision(object.getString("Division"));
                        ads.setAddress(object.getString("Address"));
                        ads.setDescription(object.getString("Description"));
                        ads.setPrice(Integer.parseInt(object.getString("Price")));
                        ads.setContact(Integer.parseInt(object.getString("Contact")));

                        adList.add(ads);
                    }
                    return true;
                }

                //------------------>>

            } catch (ParseException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return false;
        }

        protected void onPostExecute(Boolean result) {
            dialog.cancel();
            adapter.notifyDataSetChanged();
            if(result == false)
                Toast.makeText(getApplicationContext(), "No Home Found", Toast.LENGTH_LONG).show();

        }
    }

}
