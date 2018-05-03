package com.example.android.studentmanagmentapp;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class AppSetting extends AppCompatActivity {
public static String text_font;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_setting);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        final TextView textView = (TextView) findViewById(R.id.txt_sample);

        //SharedPreferences
        final SharedPreferences sharedPreferences = getSharedPreferences("Font",0); //0 mode means private
        int font_size = sharedPreferences.getInt("Font", 12);
        seekBar.setProgress(font_size);
        textView.setTextSize(font_size);
        RadioButton rdColorRed = (RadioButton) findViewById(R.id.rdColorRed);
        RadioButton rdColorGreen = (RadioButton) findViewById(R.id.rdColorGreen);

        /* False code - changes color to the opposite

        rdColorRed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                textView.setTextColor(Color.parseColor("#f44242"));
            }
        });

        rdColorGreen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                textView.setTextColor(Color.parseColor("#328941"));
            }
        });
        */

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int font_size2 = seekBar.getProgress();
                textView.setTextSize(font_size2);

                //SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("Font", font_size2);
                editor.commit();
                text_font = textView.getText().toString();

                Toast.makeText(getApplicationContext(), "Text size changed", Toast.LENGTH_LONG).show();
            }
        });
    }
//Search for OnCreateOptionMenu by using ctrl+O

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Search for OnCreateOptionMenu by using ctrl+O
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.m_share:
                /*Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "This is my application");
                startActivity(Intent.createChooser(intent, "Share via..."));
                break;*/

                // Commands to set the array back
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


// RadioButton that changes the collor of the text onChange

    public  void onChange (View view){
        final TextView textView = (TextView) findViewById(R.id.txt_sample);
        if (view.getId() == R.id.rdColorRed){
            textView.setTextColor (Color.parseColor("#f44242"));
        }
        if (view.getId() == R.id.rdColorGreen){
            textView.setTextColor (Color.parseColor("#328941"));
        }
    }

    //Popping out Dialog box
    public void btnLoginClick (View view){
        Dialog dialog = new Dialog((this));
        dialog.setContentView(R.layout.dialog_login_layout);
        dialog.setTitle("Login");
        dialog.getWindow().setLayout(700,700);
        dialog.show();
    }

    public int counter = 3;
    public void LoginCheck (View view){
        EditText user = findViewById(R.id.txtUsername);
        EditText pass = findViewById(R.id.txtPassword);
        Button button = findViewById(R.id.btnLogin);

        String username = user.getText().toString();
        String password = pass.getText().toString();

        if (username=="admin" && password=="123"){
            Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG);
        }
        else {
            counter = counter-1;
            if (counter>=3){
                Toast.makeText(getApplicationContext(), "Wrong login or password", Toast.LENGTH_LONG);
            }
            else {
                button.setVisibility(View.INVISIBLE);
            }
        }
    }

    //Save to internal memory
    public void saveText (View view) {
        FileOutputStream fileOutputStream;

        try {
            fileOutputStream = openFileOutput("Fontt.txt", 0);
            fileOutputStream.write(text_font.getBytes());
        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
        catch (IOException e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
