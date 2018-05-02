package com.example.android.studentmanagmentapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter{
    ArrayList names;
    public static Activity activity;

    public GridAdapter(Activity activity, ArrayList names) {
        this.names = names;
        this.activity=activity;
    }

    @Override
    public int getCount() {return names.size();}

    @Override
    public Object getItem(int i) {return names.get(i);}

    @Override
    public long getItemId(int i) {return i;}

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if (convertView==null){
            LayoutInflater inflater = LayoutInflater.from(activity);
            convertView = inflater.inflate(R.layout.basic_layout, null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.grdBasic);

        switch (names.get(i).toString()){
            case "Students": imageView.setImageResource(R.drawable.ic_profile);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, StudentsActivity.class);
                    activity.startActivity(intent);
                    activity.setContentView(R.layout.activity_students);
                }
            });
            break;

            case "Marks": imageView.setImageResource(R.drawable.ic_marks);
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(activity, MarksActivity.class);
                        activity.startActivity(intent);
                        activity.setContentView(R.layout.activity_marks);
                    }
                });
            break;
            case "Subjects": imageView.setImageResource(R.drawable.ic_subjects);
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(activity, SubjectsActivity.class);
                        activity.startActivity(intent);
                        activity.setContentView(R.layout.activity_subjects);
                    }
                });
            break;
            case "Attendance": imageView.setImageResource(R.drawable.ic_attendance);
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(activity, AttendanceActivity.class);
                        activity.startActivity(intent);
                        activity.setContentView(R.layout.activity_attendance);
                    }
                });
        }
        return convertView;
    }
}
