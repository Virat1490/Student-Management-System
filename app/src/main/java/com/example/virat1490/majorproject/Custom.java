package com.example.virat1490.majorproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Custom extends ArrayAdapter {
    Activity c;
    String name1[];
    Integer image1[];
    TextView tv;
    ImageView im;
    public Custom(@NonNull Context context,String[] resource,Integer[] textViewResourceId) {
        super(context, R.layout.activity_home, resource);
        c=(Activity)context;
        name1=resource;
        image1=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater lf=c.getLayoutInflater();
        convertView=lf.inflate(R.layout.custom_list,null);
        tv=convertView.findViewById(R.id.listText);
        im=convertView.findViewById(R.id.listImage);
        tv.setText(name1[position]);
        im.setImageResource(image1[position]);
        return convertView;
    }

}
