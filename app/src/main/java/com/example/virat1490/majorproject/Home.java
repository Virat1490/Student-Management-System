package com.example.virat1490.majorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
ImageView imageGallery;
ListView lv;
String name[]={"Diploma","B.Tech","M.Tech","MBA"};
Integer image[]={R.drawable.diploma, R.drawable.btech,R.drawable.mtech, R.drawable.mba};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);
        imageGallery=findViewById(R.id.home_Gallary);
        imageGallery.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable)imageGallery.getBackground()).start();
            }
        });
        lv=findViewById(R.id.home_Customlist);
        Custom cs=new Custom(Home.this,name,image);
        lv.setAdapter(cs);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Toast.makeText(Home.this,"Diploma Opening",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(Home.this,Select_student.class);
                        startActivity(i);
                        break;
                    case 1:
                        Toast.makeText(Home.this,"Btech Opening",Toast.LENGTH_SHORT).show();
                        Intent j=new Intent(Home.this,Select_student.class);
                        startActivity(j);
                        break;
                    case 2:
                        Toast.makeText(Home.this,"Mtech Opening",Toast.LENGTH_SHORT).show();
                        Intent k=new Intent(Home.this,Select_student.class);
                        startActivity(k);
                        break;
                    case 3:
                        Toast.makeText(Home.this,"MBA Opening",Toast.LENGTH_SHORT).show();
                        Intent l=new Intent(Home.this,Select_student.class);
                        startActivity(l);
                        break;
                }
            }
        });
    }
}