package com.example.virat1490.majorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class fetch extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    Button fetch,update,del;
    String froll,fpass,fmob,fadd,fqual,s90,s91,s92,s93;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);
        e1=findViewById(R.id.editRoll);
        e2=findViewById(R.id.editPass);
        e3=findViewById(R.id.editMob);
        e4=findViewById(R.id.editadd);
        e5=findViewById(R.id.editqual);
        fetch=findViewById(R.id.buttonFetch);
        update=findViewById(R.id.buttonUpdate);
        del=findViewById(R.id.buttonDetet);
        froll=e1.getText().toString();
        fpass=e2.getText().toString();
        fmob=e3.getText().toString();
        fadd=e4.getText().toString();
        fqual=e5.getText().toString();
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                froll=e1.getText().toString();
                fpass=e2.getText().toString();
                fmob=e3.getText().toString();
                fadd=e4.getText().toString();
                fqual=e5.getText().toString();
                Fetch();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                froll=e1.getText().toString();
                fpass=e2.getText().toString();
                fmob=e3.getText().toString();
                fadd=e4.getText().toString();
                fqual=e5.getText().toString();
                Update();
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                froll=e1.getText().toString();
                Delete();
            }
        });
    }

    private void Fetch() {
        RequestQueue rq= Volley.newRequestQueue(fetch.this);
        StringRequest sr=new StringRequest(config.DATA_URL + froll, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONFETCH(response);
                Toast.makeText(fetch.this,"Data fetched",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(fetch.this,"Data Not fetched",Toast.LENGTH_SHORT).show();
            }
        });
        rq.add(sr);
    }

    public void JSONFETCH(String response){
        try{
            JSONObject jb=new JSONObject(response);
            JSONArray jr=jb.getJSONArray(config.DATA_RESULT);
            JSONObject jb1=jr.getJSONObject(0);
            s90=jb1.getString(config.DATA_PASS);
            s91= jb1.getString(config.DATA_MOBILE);
            s92=jb1.getString(config.DATA_ADDRESS);
            s93=jb1.getString(config.DATA_QUALIFICATION);
        }catch (JSONException e){

        }
        e2.setText(s90);
        e3.setText(s91);
        e4.setText(s92);
        e5.setText(s93);
    }

    private void Update() {

        RequestQueue rq= Volley.newRequestQueue(fetch.this);
        String url="https://studentdatabasevirat.000webhostapp.com/project/update.php";
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(fetch.this,"Data Updated",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(fetch.this,"Data Not Updated",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hm=new HashMap<>();
                hm.put("r",froll);
                hm.put("p",fpass);
                hm.put("m",fmob);
                hm.put("a",fadd);
                hm.put("q",fqual);
                return hm;
            }
        };
        rq.add(sr);
    }

    private void Delete() {

        RequestQueue rq= Volley.newRequestQueue(fetch.this);
        String url="https://studentdatabasevirat.000webhostapp.com/project/delete.php";
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(fetch.this,"Data Deleted",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(fetch.this,"Data Not Delete",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hm=new HashMap<>();
                hm.put("r",froll);
                return hm;
            }
        };
        rq.add(sr);
    }
}