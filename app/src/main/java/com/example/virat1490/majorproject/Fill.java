package com.example.virat1490.majorproject;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fill #newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fill extends Fragment {
Button reg,show;
View v;
EditText e1,e2,e3,e4,e5;
String s1,s2,s3,s4,s5;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_fill, container, false);
        reg=v.findViewById(R.id.button2);
        show=v.findViewById(R.id.button3);
        e1=v.findViewById(R.id.editTextRoll);
        e2=v.findViewById(R.id.editTextPass);
        e3=v.findViewById(R.id.editTextMob);
        e4=v.findViewById(R.id.editTextAdd);
        e5=v.findViewById(R.id.editTextQual);
        s1=e1.getText().toString();
        s2=e2.getText().toString();
        s3=e3.getText().toString();
        s4=e4.getText().toString();
        s5=e5.getText().toString();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();
                Register();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),fetch.class);
                startActivity(i);
            }
        });
        return v;
    }

    private void Register() {
        RequestQueue rq= Volley.newRequestQueue(getActivity());
        String url="https://studentdatabasevirat.000webhostapp.com/project/register.php?";
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(),"Data Registered",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"Data Not Registered",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hm=new HashMap<>();
                hm.put("r",s1);
                hm.put("p",s2);
                hm.put("m",s3);
                hm.put("a",s4);
                hm.put("q",s5);
                return hm;
            }
        };
        rq.add(sr);
    }
}