package com.example.virat1490.majorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
Button login;
EditText e1,e2;
String roll,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login_Button);
        e1 = findViewById(R.id.userName);
        e2 = findViewById(R.id.password);
        roll = e1.getText().toString();
        pass = e2.getText().toString();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll = e1.getText().toString();
                pass = e2.getText().toString();
                LoginFun();
            }
        });
    }

            private void LoginFun() {
                RequestQueue rq= Volley.newRequestQueue(Login.this);
                String url="https://studentdatabasevirat.000webhostapp.com/project/login.php";
                StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contentEquals("done")) {
                            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Log.e("Check","Sucessful");
                            Intent i = new Intent(Login.this, Home.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(Login.this, "Login Not Successful", Toast.LENGTH_SHORT).show();
                            Log.e("Check","NOt Sucessful");
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Login.this,"Login Error...",Toast.LENGTH_SHORT).show();
                        Log.e("Check","Error");
                    }
                }){
                    protected Map<String,String> getParams() throws AuthFailureError {
                        HashMap<String,String> hhm=new HashMap<>();
                        hhm.put("r",roll);
                        hhm.put("p",pass);
                        return hhm;
                    }
                };
                rq.add(sr);
            }
}