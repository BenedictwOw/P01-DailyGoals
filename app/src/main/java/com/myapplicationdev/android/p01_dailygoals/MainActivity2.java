package com.myapplicationdev.android.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        //Getting the intent so as to get the data inside the intent
        Intent i =getIntent();
        //Get the String array named info we passed in
        String[] info = i.getStringArrayExtra("info");
        //Get the TextView object
        TextView tv1 = findViewById(R.id.textView8);
        //Display the name and age on the TextView
        tv1.setText("Read up on materials before class : "+info[1]+ "\n\nArrive on time so as not to miss important part of\nthe lesson :"+info[2]+ "\n\nAttempt the problem myself : "+info[3]
        +"\n\nReflection: "+info[0]);
    }
}
