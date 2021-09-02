package com.example.virat1490.majorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class Select_student extends AppCompatActivity {
ListView lv;
Integer studentimage[]={R.drawable.s1, R.drawable.s2,R.drawable.s3, R.drawable.s4,R.drawable.s5,R.drawable.s6,R.drawable.s7,
        R.drawable.s9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_select_student);
        lv=findViewById(R.id.select_Student_List);
        Custom_select_student css=new Custom_select_student(Select_student.this,studentimage);
        lv.setAdapter(css);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i=new Intent(Select_student.this,Register.class);
                        i.putExtra("img",studentimage[position]);
                        startActivity(i);


            }
        });
    }
}