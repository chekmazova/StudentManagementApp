package com.example.android.studentmanagmentapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class StudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onChange (View view){
        Button button1 = (Button) findViewById(R.id.btn_studentProfile);
        Button button2 = (Button) findViewById(R.id.btn_jobProfile);
        Fragment fragment;

        if (view == button1) {
            fragment = new StudentProfile();
            android.app.FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.Srudent_fragment, fragment);
            fragmentTransaction.commit();
        }

        else if (view == button2) {
            fragment = new StudentJobProfile();
            android.app.FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.Srudent_fragment, fragment);
            fragmentTransaction.commit();
        }
    }
}
