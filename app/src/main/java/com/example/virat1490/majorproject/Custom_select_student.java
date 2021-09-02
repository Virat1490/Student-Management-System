package com.example.virat1490.majorproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Custom_select_student extends ArrayAdapter {
    Activity c;
    Integer studentimg[];
    ImageView im;
    public Custom_select_student(Context context, Integer[] resource) {
        super(context,R.layout.activity_select_student, resource);
        c=(Activity)context;
        studentimg=resource;
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        LayoutInflater lf=c.getLayoutInflater();
        convertView=lf.inflate(R.layout.custom_list_student,null);
        im=convertView.findViewById(R.id.student_List_img);
        im.setImageResource(studentimg[position]);
        return convertView;
    }
}
