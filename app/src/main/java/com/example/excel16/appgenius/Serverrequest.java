package com.example.excel16.appgenius;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.StringRequest;


import org.json.JSONObject;

import java.util.HashMap;

import java.util.Map;



/**
 * Created by jerin on 6/10/16.
 */

public class Serverrequest {
    ProgressDialog progressDialog;
    String url="http://jerintheawesomeapper.netne.net/register.php";// here is your URL path
    String url1="";
    Map<String,String> pamss= new HashMap<String, String>();
    Context context;
    Userinterface userinterface;

    Serverrequest(Context context){
        this.context=context;
        progressDialog=new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("please wait...");
    }

    public void storeuserdatainbackground(Map<String,String> pams, final Userinterface userinterface){
        progressDialog.show();
        this.pamss=pams;
        this.userinterface=userinterface;
        try {




            StringRequest stringRequest = new StringRequest(Request.Method.POST, url1,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {



                            userinterface.done(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressDialog.dismiss();


                        }
                    }){
                @Override
                protected Map<String,String> getParams(){
                    Map<String,String> params = new HashMap<String, String>();
                            params.put("name",pamss.get("name"));
                    params.put("password",pamss.get("password"));

                    return params;
                }

            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(1000 * 60, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            appcontroller.getInstance().addToRequestQueue(stringRequest);
        }
        catch(Exception e){

        }


    }


}
