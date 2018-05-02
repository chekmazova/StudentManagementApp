package com.example.android.studentmanagmentapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> menuIcon;
    GridView gridView;
    GridAdapter adapter;
    public static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuIcon = new ArrayList<>();
        activity = this;

        gridView = (GridView) findViewById(R.id.grdView);
        menuIcon.add("Students");
        menuIcon.add("Marks");
        menuIcon.add("Subjects");
        menuIcon.add("Attendance");

        adapter = new GridAdapter(activity, menuIcon);
        gridView.setAdapter(adapter);
    }
}
