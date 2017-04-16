package com.example.niloy.my_house_renting_app;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by niloy on 3/16/2017.
 */

public class Data_Posting_Helper {

    private static Data_Posting_Helper data_posting_helper;
    private RequestQueue requestQueue;
    private static Context ctx;

    private Data_Posting_Helper(Context context)
    {
        ctx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized Data_Posting_Helper getData_posting_helper(Context context)
    {
        if (data_posting_helper==null)
        {
            data_posting_helper = new Data_Posting_Helper(context);
        }
        return data_posting_helper;
    }

    public RequestQueue getRequestQueue()
    {
        if(requestQueue==null)
        {
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T>void addtorequestqueue(Request<T> request)
    {
        requestQueue.add(request);
    }

}
