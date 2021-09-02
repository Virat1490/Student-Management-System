package com.example.virat1490.majorproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Register extends AppCompatActivity {
ImageView ig;
Button add;
FragmentManager fg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);
        fg=getSupportFragmentManager();
        ig=findViewById(R.id.imageView);
        add=findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fg.beginTransaction().replace(R.id.frame,new Fill()).commit();
            }
        });
        Intent i=getIntent();
        Integer str=i.getIntExtra("img",0);
        ig.setImageResource(str);

    }
}